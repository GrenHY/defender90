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
		 * һ����ͼ
		 */
		//1. ����һ���ڴ�ӳ�����(����)
		BufferedImage image = 
			new BufferedImage(80,30,
					BufferedImage.TYPE_INT_RGB);
		//2.��û���
		Graphics g = image.getGraphics();
		//3.����������ɫ
		g.setColor(new Color(255,255,255));
		//4.���������ñ���
		g.fillRect(0, 0, 80, 30);
		//5,����������ɫ(�����ɫ)
		Random r = new Random();
		g.setColor(new Color(r.nextInt(255),
				r.nextInt(255),r.nextInt(255)));
		//  Font(����,���,��С);
		g.setFont(new Font(null,Font.ITALIC,22));
		//6,��number���Ƶ�ͼƬ��
		String number = getNumber(5);
		//����֤��󶩵�session������
		HttpSession session = 
			request.getSession();
		session.setAttribute("number", number);
		g.drawString(number, 2, 24);
		//7,��һЩ������
		for(int i = 0;i < 6; i++){
			g.drawLine(r.nextInt(80), r.nextInt(30), 
					r.nextInt(80), r.nextInt(30));
		}
		/*
		 * ������ͼƬѹ��,Ȼ����� 
		 */
		//1.����content-type��Ϣͷ���������
		//�������ص���ͼƬ
		response.setContentType("image/jpeg");
		//2.����ֽ������
		OutputStream ops =
			  response.getOutputStream();
		//3.��ͼƬѹ����Ȼ�����
		javax.imageio.ImageIO
		.write(image, "jpeg", ops);
		ops.close();
	}
	
	//����Ϊsize���ַ���������Щ�ַ������
	//"A~Z,0~9"��ѡȡ��
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
