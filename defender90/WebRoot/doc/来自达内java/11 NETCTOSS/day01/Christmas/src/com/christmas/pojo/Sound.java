package com.christmas.pojo;
/**
 * ��Чʵ����
 * @author ��ʫ������
 *
 */
public class Sound {
	/**�洢��Ч��byte����*/
	private byte[]samples;

	public Sound(byte[] samples) {
		this.samples=samples;
	}

	public byte[] getSamples() {
		return samples;
	}

	public void setSamples(byte[] samples) {
		this.samples = samples;
	}
	
}
