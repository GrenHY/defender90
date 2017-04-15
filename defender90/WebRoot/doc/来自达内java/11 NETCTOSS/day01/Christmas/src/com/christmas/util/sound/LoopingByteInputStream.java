package com.christmas.util.sound;

import java.io.ByteArrayInputStream;
import java.io.IOException;
/**
 * �Զ���byte�����ȡ��
 * @author ��Ԋ�L���
 *
 */
public class LoopingByteInputStream extends ByteArrayInputStream {
	/**�ж����Ƿ�ر�*/
	public boolean closed;
	
	public LoopingByteInputStream(byte[] buf) {
		super(buf);
		closed=false;
	}
	/**
	 * ��дread����
	 */
	@Override
	public int read(byte[] buffer, int offset, int length) {
		if (closed) {
			return -1;
		}
		//�����ȡ���ֽ���
		int totalBytesRead = 0;
		while (totalBytesRead < length) {
			//�Ѷ�ȡ���ֽ���
			int numBytesRead = super.read(buffer, offset + totalBytesRead,
					length - totalBytesRead);
			//�����ȡ���ֽ�������0���ӵ����ֽ�����
			if (numBytesRead > 0) {
				totalBytesRead += numBytesRead;
			} else {
				//��λ
				reset();
			}
		}
		return totalBytesRead;
	}
	/**
	 * ��дclose����
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
