package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckcodeServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("checkcode's service...");
		/*
		 * 一、绘图
		 */
		//1. 创建一个内存映像对象(画布)
		BufferedImage image = 
			new BufferedImage(80,30,
					BufferedImage.TYPE_INT_RGB);
		//2.获得画笔
		Graphics g = image.getGraphics();
		//3.给笔设置颜色
		g.setColor(new Color(255,255,255));
		//4.给画布设置背景
		g.fillRect(0, 0, 80, 30);
		//5,给笔设置颜色(随机颜色)
		Random r = new Random();
		g.setColor(new Color(r.nextInt(255),
				r.nextInt(255),r.nextInt(255)));
		//  Font(字体,风格,大小);
		g.setFont(new Font(null,Font.ITALIC,22));
		//6,将number绘制到图片上
		String number = getNumber(5);
		//将验证码绑订到session对象上
		HttpSession session = 
			request.getSession();
		session.setAttribute("number", number);
		g.drawString(number, 2, 24);
		//7,加一些干扰线
		for(int i = 0;i < 6; i++){
			g.drawLine(r.nextInt(80), r.nextInt(30), 
					r.nextInt(80), r.nextInt(30));
		}
		/*
		 * 二、将图片压缩,然后输出 
		 */
		//1.设置content-type消息头，告诉浏览
		//器，返回的是图片
		response.setContentType("image/jpeg");
		//2.获得字节输出流
		OutputStream ops =
			  response.getOutputStream();
		//3.将图片压缩，然后输出
		javax.imageio.ImageIO
		.write(image, "jpeg", ops);
		ops.close();
	}
	
	//长度为size个字符，并且这些字符随机从
	//"A~Z,0~9"中选取。
	private String getNumber(int size) {
		String str = "ABCDEFGHIJKLMNOPQR" +
				"STUVWXYZ0123456789";
		String number = "";
		Random r = new Random();
		for(int i = 0 ;i < size; i ++){
			number += str.charAt(r.nextInt(str.length()));
		}
		return number;
	}

}
