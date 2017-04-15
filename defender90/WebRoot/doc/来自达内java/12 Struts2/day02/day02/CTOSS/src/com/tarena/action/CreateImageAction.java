package com.tarena.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.tarena.util.ImageUtil;

/**
 *	生成验证码图片
 */
public class CreateImageAction {
	
	/**
	 * 将生成的图片转换成输入流，然后将此输入流
	 * 传递给StreamResult，该Result可以自动创建
	 * 输出流，然后将输入流的内容输出到页面。
	 * 在这个过程中，Result只负责输出，内容由
	 * Action提供，要求内容必须是InputStream类型。
	 */
	private InputStream imageStream;
	
	public String execute() throws IOException {
		//创建图片
		Map<String, BufferedImage> map = 
			ImageUtil.createImage();
		//遍历Map，得到验证码，放入session
		String code = 
			map.keySet().iterator().next();
		HttpSession session = 
			ServletActionContext.getRequest().getSession();
		session.setAttribute("imageCode", code);
		//获取图片
		BufferedImage image = map.get(code);
		//将图片转换为输入流，由Result输出
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
