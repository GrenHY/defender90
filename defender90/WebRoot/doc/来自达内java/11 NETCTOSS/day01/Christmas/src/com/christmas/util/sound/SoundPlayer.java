package com.christmas.util.sound;

import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.SourceDataLine;
/**
 * ��Ч������
 * @author ��ʫ������
 *
 */
public class SoundPlayer implements Runnable{
	private InputStream source;
	//����������
	private SoundManager sondManager;
	private AudioFormat format;
	private boolean closed = false;
	public SoundPlayer(InputStream source,SoundManager sondManager,AudioFormat format){
		this.source =source;
		this.sondManager = sondManager;
		this.format = format;
	}
	/**
	 * ���������߼�
	 */
	public void run() {
		//�ӵ�ǰ�߳��л�ȡ����
		sondManager.setLineAndBuffer(format);
		SourceDataLine line = sondManager.getLocalLine().get();
		byte[] buffer = sondManager.getLocalBuffer().get();
		//���û�����ݣ���ô��������û�б���ʼ������
		if(line==null||buffer==null){
			return;
		}
		//����������ݸ��Ƶ����ŵ���������
		try {
			int numBytesRead = 0;
			while(!closed&&numBytesRead != -1){
				synchronized (sondManager.getPausedLocak()) {
					if(sondManager.closed){
						closed=true;
						sondManager.closed = false;
					}
					//�����ͣ���ȴ�����ʼ��ʱ��
					if(sondManager.isPaused()){
						try {
							sondManager.getPausedLocak().wait();
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}
				}
				//��ʼ��������
				//1����Ŀ�껺���ж�ȡ��Դ
				numBytesRead = source.read(buffer,0,buffer.length);
				if(numBytesRead!=-1){
					//2��д������Դ
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
