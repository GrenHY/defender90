package com.tarena.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.tarena.util.ImageUtil;

/**
 *	������֤��ͼƬ
 */
public class CreateImageAction {
	
	/**
	 * �����ɵ�ͼƬת������������Ȼ�󽫴�������
	 * ���ݸ�StreamResult����Result�����Զ�����
	 * �������Ȼ�������������������ҳ�档
	 * ����������У�Resultֻ���������������
	 * Action�ṩ��Ҫ�����ݱ�����InputStream���͡�
	 */
	private InputStream imageStream;
	
	public String execute() throws IOException {
		//����ͼƬ
		Map<String, BufferedImage> map = 
			ImageUtil.createImage();
		//����Map���õ���֤�룬����session
		String code = 
			map.keySet().iterator().next();
		HttpSession session = 
			ServletActionContext.getRequest().getSession();
		session.setAttribute("imageCode", code);
		//��ȡͼƬ
		BufferedImage image = map.get(code);
		//��ͼƬת��Ϊ����������Result���
		imageStream = 
			ImageUtil.getInputStream(image);
		return "success";
	}

	public InputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}

}
