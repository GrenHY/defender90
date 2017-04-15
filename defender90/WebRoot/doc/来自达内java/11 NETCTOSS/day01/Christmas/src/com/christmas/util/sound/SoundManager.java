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
 * �Զ�������������
 * 
 * @author ��ʫ������
 * 
 */
public class SoundManager extends ThreadPool {
	/**��Ƶ��ʽ*/
	private AudioFormat playbackFormat;
	/**���ڲ��ŵ��߳�,�洢��д������Դ*/
	private ThreadLocal<SourceDataLine> localLine;
	/** ���ڻ�����̣߳���ֵ����ڻ�����ֽ�����*/
	private ThreadLocal<byte[]> localBuffer;
	/**ͬ����־���󣬱��Ⲣ��*/
	private Object pausedLocak;
	/** �Ƿ���ͣ*/
	private boolean paused;
	/**�ر�ѭ��*/
	public boolean closed = false; 

	public SoundManager(int maxSimultaneousSounds) {
		super(maxSimultaneousSounds);
		localLine = new ThreadLocal<SourceDataLine>();
		localBuffer = new ThreadLocal<byte[]>();
		pausedLocak = new Object();
		// �������еĵȴ��߳�
		synchronized (this) {
			notifyAll();
		}
	}

	/**
	 * �ر��̳߳أ������̽�����������
	 */
	public synchronized void close() {
		super.close();
	}

	/**
	 * �ر�һ��ѭ���߳�
	 */
	public void closeLoop() {
		if (!closed) {
			closed = true;
		}
	}

	/**
	 * �ر����е�ѭ���߳� �ر��̳߳أ����ȴ���������ִ�����
	 */
	public void join() {
		super.join();
	}

	/**
	 * ������ͣ
	 * 
	 * @param paused
	 */
	public void setPaused(boolean paused) {
		// �ж��Ƿ���ͣ
		if (this.paused != paused) {
			synchronized (pausedLocak) {
				this.paused = paused;
				// ���û����ͣ ����
				if (!paused) {
					// ������������
					pausedLocak.notifyAll();
				}
			}
		}
	}

	/**
	 * ��ȡ���ֵķ���
	 */
	public Sound getSound(String filename) {
		return getSound(getAudioInputStream(filename));
	}

	/**
	 * ͨ��һ����Ƶ��������ȡ����
	 * 
	 * @param audioInputStream
	 * @return sound
	 */
	private Sound getSound(AudioInputStream audioInputStream) {
		if (audioInputStream == null) {
			return null;
		}
		// �õ�Ҫ��ȡ���ֽڳ���
		int length = (int) (audioInputStream.getFrameLength() * audioInputStream
				.getFormat().getFrameSize());
		// ��ȡ������Ƶ��
		byte[] samples = new byte[length];
		// ת���ɸ߼���
		DataInputStream dis = new DataInputStream(audioInputStream);
		// ��audioInputStream�ж�ȡȫ���ֽ�
		try {
			dis.readFully(samples);
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ����һ����������
		return new Sound(samples);
	}

	/**
	 * ͨ��һ���ļ���ȡһ����Ƶ������
	 * 
	 * @param filename
	 * @return in
	 */
	public AudioInputStream getAudioInputStream(String filename) {
		InputStream in = this.getClass().getResourceAsStream(filename);
		return getAudioInputStream(in);

	}

	/**
	 * ͨ��һ����������ȡ��Ƶ�������ķ���
	 * @param is
	 * @return ais
	 */
	public AudioInputStream getAudioInputStream(InputStream is) {
		// �����������֧��mark()��reset()��������ɻ�����
		try {
			if (!is.markSupported()) {
				is = new BufferedInputStream(is);
			}
			// ����Դ��
			AudioInputStream ais = AudioSystem.getAudioInputStream(is);
			playbackFormat = ais.getFormat();
			// ת��Ϊ���Ÿ�ʽ
			return AudioSystem.getAudioInputStream(playbackFormat, ais);
		} catch (UnsupportedAudioFileException e) {
			System.out.println("��ʽ��֧��");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ����һ������
	 * @param sound
	 * @return is
	 */
	public InputStream play(Sound sound) {
		return play(sound, false);
	}

	/**
	 * ȷ���Ƿ�ѭ��
	 * @param sound
	 * @param looping
	 * @return is
	 */
	public InputStream play(Sound sound, boolean loop) {
		InputStream is;
		if (sound != null) {
			// ���ѭ��
			if (loop) {
				// �����ѭ���ֽ�������
				is = new LoopingByteInputStream(sound.getSamples());
			} else {
				// �����ѭ�������ֽ�����������
				is = new ByteArrayInputStream(sound.getSamples());
			}
			return play(is, loop);
		}
		return null;
	}

	/**
	 * ͨ��һ��������������������������һ������
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
	 * �߳̽��������������
	 */
	protected void threadStopped() {
		SourceDataLine line = (SourceDataLine) localLine.get();
		if (line != null) {
			line.drain();
			line.close();
		}
	}

	/**
	 * �����������뻺��
	 */
	public void setLineAndBuffer(AudioFormat format) {
		// �õ�����Ĵ�С
		int bufferSize = format.getFrameSize()
				* Math.round(format.getSampleRate() / 10);

		SourceDataLine line;
		// ������Ƶ��ʽ����������
		DataLine.Info lineInfo = new DataLine.Info(SourceDataLine.class,
				format, AudioSystem.NOT_SPECIFIED);
		try {
			line = (SourceDataLine) AudioSystem.getLine(lineInfo);
			// ����Ƶ��ʹ���ÿɲ���
			line.open(format, bufferSize);
		} catch (LineUnavailableException ex) {
			// ����������ǿգ���ϵ�ǰ�߳�
			Thread.currentThread().interrupt();
			return;
		}
		// ������Ƶ
		line.start();

		// ������������
		byte[] buffer = new byte[bufferSize];

		// ���õ���ǰ�߳���
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
