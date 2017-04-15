package com.christmas.util.sound;

import java.io.ByteArrayInputStream;
import java.io.IOException;
/**
 * 自定义byte数组读取流
 * @author 四詩風雅頌
 *
 */
public class LoopingByteInputStream extends ByteArrayInputStream {
	/**判断流是否关闭*/
	public boolean closed;
	
	public LoopingByteInputStream(byte[] buf) {
		super(buf);
		closed=false;
	}
	/**
	 * 重写read方法
	 */
	@Override
	public int read(byte[] buffer, int offset, int length) {
		if (closed) {
			return -1;
		}
		//定义读取的字节数
		int totalBytesRead = 0;
		while (totalBytesRead < length) {
			//已读取的字节数
			int numBytesRead = super.read(buffer, offset + totalBytesRead,
					length - totalBytesRead);
			//如果读取的字节数大于0，加到总字节数中
			if (numBytesRead > 0) {
				totalBytesRead += numBytesRead;
			} else {
				//复位
				reset();
			}
		}
		return totalBytesRead;
	}
	/**
	 * 重写close方法
	 */
	public void close() throws IOException {
		super.close();
		closed= true;
	}
	public boolean isClosed() {
		return closed;
	}
	public void setClosed(boolean closed) {
		this.closed = closed;
	}
}
