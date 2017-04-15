package com.christmas.util;

import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
/**
 * 图片获取工具类
 * @author 四诗风雅颂
 *
 */
public class GetImgUtil {
	/**背景图片*/
	public static ImageIcon icon=new ImageIcon(getImgUrl("christmas"));
	/**关闭按钮图片*/
	public final static ImageIcon CLOSE=new ImageIcon(getImgUrl("close"));
	/**最小化按钮图片*/
	public final static ImageIcon MIN=new ImageIcon(getImgUrl("min"));
	/**LOGO图片*/
	public final static Image LOGO=new ImageIcon(getImgUrl("MyLogo")).getImage();
	/**换背景按钮图片*/
	public final static Image CHANGE=new ImageIcon(getImgUrl("start")).getImage();
	/**第二张背景图片*/
	public final static ImageIcon BACK=new ImageIcon(getImgUrl("christmas1"));		
	/**滑行的圣诞老人图片*/
	public final static ImageIcon CHRIST=new ImageIcon(getGIF("christ"));
	/**
	 * 获得PNG图片的URL的路径
	 * @param name
	 * @return url
	 */
	public static URL getImgUrl(String name){
		URL url=GetImgUtil.class.getResource("img"+File.separator+name+".png");
		return url;
	}
	/**
	 * 获得GIF图片的URL路径
	 * @param name
	 * @return url
	 */
	private static URL getGIF(String name){
		URL url=GetImgUtil.class.getResource("img"+File.separator+name+".gif");
		return url;
	}
}
