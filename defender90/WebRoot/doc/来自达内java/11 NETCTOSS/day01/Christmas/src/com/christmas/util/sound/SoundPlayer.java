package com.christmas.util.sound;

import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.SourceDataLine;
/**
 * 音效管理器
 * @author 四诗风雅颂
 *
 */
public class SoundPlayer implements Runnable{
	private InputStream source;
	//声音管理器
	private SoundManager sondManager;
	private AudioFormat format;
	private boolean closed = false;
	public SoundPlayer(InputStream source,SoundManager sondManager,AudioFormat format){
		this.source =source;
		this.sondManager = sondManager;
		this.format = format;
	}
	/**
	 * 运行任务逻辑
	 */
	public void run() {
		//从当前线程中获取数据
		sondManager.setLineAndBuffer(format);
		SourceDataLine line = sondManager.getLocalLine().get();
		byte[] buffer = sondManager.getLocalBuffer().get();
		//如果没有数据，那么播放数据没有被初始化返回
		if(line==null||buffer==null){
			return;
		}
		//将缓冲的数据复制到播放的数据里面
		try {
			int numBytesRead = 0;
			while(!closed&&numBytesRead != -1){
				synchronized (sondManager.getPausedLocak()) {
					if(sondManager.closed){
						closed=true;
						sondManager.closed = false;
					}
					//如果暂停，等待到开始的时候
					if(sondManager.isPaused()){
						try {
							sondManager.getPausedLocak().wait();
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}
				}
				//开始复制数据
				//1、从目标缓冲中读取资源
				numBytesRead = source.read(buffer,0,buffer.length);
				if(numBytesRead!=-1){
					//2、写入数据源
					line.write(buffer, 0, numBytesRead);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	public boolean isClosed() {
		return closed;
	}
	public void setClosed(boolean closed) {
		this.closed = closed;
	}

}
