package com.christmas.util.sound;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.christmas.pojo.Sound;

/**
 * 自定义声音管理器
 * 
 * @author 四诗风雅颂
 * 
 */
public class SoundManager extends ThreadPool {
	/**音频格式*/
	private AudioFormat playbackFormat;
	/**正在播放的线程,存储的写入数据源*/
	private ThreadLocal<SourceDataLine> localLine;
	/** 正在缓存的线程，村粗的正在缓存的字节数组*/
	private ThreadLocal<byte[]> localBuffer;
	/**同步标志对象，避免并发*/
	private Object pausedLocak;
	/** 是否暂停*/
	private boolean paused;
	/**关闭循环*/
	public boolean closed = false; 

	public SoundManager(int maxSimultaneousSounds) {
		super(maxSimultaneousSounds);
		localLine = new ThreadLocal<SourceDataLine>();
		localBuffer = new ThreadLocal<byte[]>();
		pausedLocak = new Object();
		// 唤醒所有的等待线程
		synchronized (this) {
			notifyAll();
		}
	}

	/**
	 * 关闭线程池，并立刻结束所有任务
	 */
	public synchronized void close() {
		super.close();
	}

	/**
	 * 关闭一个循环线程
	 */
	public void closeLoop() {
		if (!closed) {
			closed = true;
		}
	}

	/**
	 * 关闭所有的循环线程 关闭线程池，并等待所有任务执行完毕
	 */
	public void join() {
		super.join();
	}

	/**
	 * 设置暂停
	 * 
	 * @param paused
	 */
	public void setPaused(boolean paused) {
		// 判断是否暂停
		if (this.paused != paused) {
			synchronized (pausedLocak) {
				this.paused = paused;
				// 如果没有暂停 启动
				if (!paused) {
					// 重新启动声音
					pausedLocak.notifyAll();
				}
			}
		}
	}

	/**
	 * 获取音乐的方法
	 */
	public Sound getSound(String filename) {
		return getSound(getAudioInputStream(filename));
	}

	/**
	 * 通过一个音频输入流获取声音
	 * 
	 * @param audioInputStream
	 * @return sound
	 */
	private Sound getSound(AudioInputStream audioInputStream) {
		if (audioInputStream == null) {
			return null;
		}
		// 得到要读取的字节长度
		int length = (int) (audioInputStream.getFrameLength() * audioInputStream
				.getFormat().getFrameSize());
		// 读取整个音频流
		byte[] samples = new byte[length];
		// 转换成高级流
		DataInputStream dis = new DataInputStream(audioInputStream);
		// 从audioInputStream中读取全部字节
		try {
			dis.readFully(samples);
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 返回一个声音对象
		return new Sound(samples);
	}

	/**
	 * 通过一个文件获取一个音频输入流
	 * 
	 * @param filename
	 * @return in
	 */
	public AudioInputStream getAudioInputStream(String filename) {
		InputStream in = this.getClass().getResourceAsStream(filename);
		return getAudioInputStream(in);

	}

	/**
	 * 通过一个输入流获取音频输入流的方法
	 * @param is
	 * @return ais
	 */
	public AudioInputStream getAudioInputStream(InputStream is) {
		// 如果输入流不支持mark()与reset()方法，变成缓冲流
		try {
			if (!is.markSupported()) {
				is = new BufferedInputStream(is);
			}
			// 打开资源流
			AudioInputStream ais = AudioSystem.getAudioInputStream(is);
			playbackFormat = ais.getFormat();
			// 转换为播放格式
			return AudioSystem.getAudioInputStream(playbackFormat, ais);
		} catch (UnsupportedAudioFileException e) {
			System.out.println("格式不支持");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 播放一个声音
	 * @param sound
	 * @return is
	 */
	public InputStream play(Sound sound) {
		return play(sound, false);
	}

	/**
	 * 确定是否循环
	 * @param sound
	 * @param looping
	 * @return is
	 */
	public InputStream play(Sound sound, boolean loop) {
		InputStream is;
		if (sound != null) {
			// 如果循环
			if (loop) {
				// 则采用循环字节输入流
				is = new LoopingByteInputStream(sound.getSamples());
			} else {
				// 如果不循环采用字节数组输入流
				is = new ByteArrayInputStream(sound.getSamples());
			}
			return play(is, loop);
		}
		return null;
	}

	/**
	 * 通过一个输入流和声音过滤器来播放一个声音
	 * 
	 * @param is
	 * @param filter
	 * @return is
	 */
	public InputStream play(InputStream is, boolean loop) {
		if (is != null) {
			runTask(new SoundPlayer(is, this, playbackFormat));
		}
		return is;
	}

	/**
	 * 线程结束后清空数据行
	 */
	protected void threadStopped() {
		SourceDataLine line = (SourceDataLine) localLine.get();
		if (line != null) {
			line.drain();
			line.close();
		}
	}

	/**
	 * 设置数据行与缓存
	 */
	public void setLineAndBuffer(AudioFormat format) {
		// 得到缓存的大小
		int bufferSize = format.getFrameSize()
				* Math.round(format.getSampleRate() / 10);

		SourceDataLine line;
		// 根据音频格式创建数据行
		DataLine.Info lineInfo = new DataLine.Info(SourceDataLine.class,
				format, AudioSystem.NOT_SPECIFIED);
		try {
			line = (SourceDataLine) AudioSystem.getLine(lineInfo);
			// 打开音频，使其变得可操作
			line.open(format, bufferSize);
		} catch (LineUnavailableException ex) {
			// 如果数据行是空，打断当前线程
			Thread.currentThread().interrupt();
			return;
		}
		// 播放音频
		line.start();

		// 创建缓存数组
		byte[] buffer = new byte[bufferSize];

		// 设置到当前线程中
		localLine.set(line);
		localBuffer.set(buffer);
	}

	public ThreadLocal<SourceDataLine> getLocalLine() {
		return localLine;
	}

	public ThreadLocal<byte[]> getLocalBuffer() {
		return localBuffer;
	}

	public Object getPausedLocak() {
		return pausedLocak;
	}

	public boolean isPaused() {
		return paused;
	}

	public AudioFormat getPlaybackFormat() {
		return playbackFormat;
	}

}
