package com.christmas.pojo;
/**
 * 音效实体类
 * @author 四诗风雅颂
 *
 */
public class Sound {
	/**存储音效的byte数组*/
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
