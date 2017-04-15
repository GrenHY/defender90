package com.christmas.util;

import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
/**
 * ͼƬ��ȡ������
 * @author ��ʫ������
 *
 */
public class GetImgUtil {
	/**����ͼƬ*/
	public static ImageIcon icon=new ImageIcon(getImgUrl("christmas"));
	/**�رհ�ťͼƬ*/
	public final static ImageIcon CLOSE=new ImageIcon(getImgUrl("close"));
	/**��С����ťͼƬ*/
	public final static ImageIcon MIN=new ImageIcon(getImgUrl("min"));
	/**LOGOͼƬ*/
	public final static Image LOGO=new ImageIcon(getImgUrl("MyLogo")).getImage();
	/**��������ťͼƬ*/
	public final static Image CHANGE=new ImageIcon(getImgUrl("start")).getImage();
	/**�ڶ��ű���ͼƬ*/
	public final static ImageIcon BACK=new ImageIcon(getImgUrl("christmas1"));		
	/**���е�ʥ������ͼƬ*/
	public final static ImageIcon CHRIST=new ImageIcon(getGIF("christ"));
	/**
	 * ���PNGͼƬ��URL��·��
	 * @param name
	 * @return url
	 */
	public static URL getImgUrl(String name){
		URL url=GetImgUtil.class.getResource("img"+File.separator+name+".png");
		return url;
	}
	/**
	 * ���GIFͼƬ��URL·��
	 * @param name
	 * @return url
	 */
	private static URL getGIF(String name){
		URL url=GetImgUtil.class.getResource("img"+File.separator+name+".gif");
		return url;
	}
}
