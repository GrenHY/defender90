package com.christmas.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.christmas.util.GetImgUtil;
/**
 * panel类
 * @author 四诗风雅颂
 *
 */
public class ChristMasPanel extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	
	/**固定的雪花形状*/
	private static final String snow="*";
	
	/**固定的UI图片，无论怎么换都是一样的，所以定义为常量*/
	private static final ImageIcon CLOSE=GetImgUtil.CLOSE;
	private static final ImageIcon MIN=GetImgUtil.MIN;
	private static final Image CHANGE=GetImgUtil.CHANGE;
	
	/**panel的长宽，利用背景图片动态得到长宽*/
	public static int Width=GetImgUtil.icon.getIconWidth();
	public static int Height=GetImgUtil.icon.getIconHeight();
	
	/**利用图片获得关闭按钮的长宽，用于确定按钮位置及点击事件的判定*/
	public static final int CLOSE_WIDTH=CLOSE.getIconWidth();
	public static final int CLOSE_HEIGHT=CLOSE.getIconHeight();
	
	/**利用图片获得min按钮的长宽，用于确定按钮位置及点击事件的判定*/
	public static final int MIN_WIDTH=MIN.getIconWidth();
	public static final int MIN_HEIGHT=MIN.getIconHeight();
	
	/**利用图片获得change按钮的长宽，用于确定按钮位置及点击事件的判定*/
	public static final int CHANGE_WIDTH=CHANGE.getWidth(null);
	public static final int CHANGE_HEIGHT=CHANGE.getHeight(null);
	
	/**判断是否在贺卡上显示雪花 */
	public static boolean isSnow=true;
	/**判断当前的贺卡背景*/
	public boolean show_Back=true;
	/**地上滑行的圣诞老人的初始横坐标*/
	public int christX=Width-GetImgUtil.CHRIST.getIconWidth();
	/**雪花的横纵坐标的集合数组*/
	private int []x=new int[50];
	private int []y=new int[50];
	
	private Random r=new Random();
	
	public ChristMasPanel() {
		initSnow();
		repaint();
	}
	/**
	 * 初始化雪花
	 */
	public void initSnow() {
		for (int i = 0; i < x.length; i++) {
			x[i]=(int)(Math.random()*Width);
			y[i]=(int)(Math.random()*Height);
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g1=(Graphics2D) g;
		paintImg(g1);
		paintTitle(g1);
		if(isSnow){
			g1.setColor(Color.WHITE);
			g1.drawImage(GetImgUtil.CHRIST.getImage(),christX
					,Height-GetImgUtil.CHRIST.getIconHeight()+20,null);
			paintSnow(g1);
		}
	}
	/**
	 * 绘制merry ChristMas
	 * @param g
	 */
	private void paintTitle(Graphics2D g) {
		g.setColor(new Color(r.nextInt(0xffffff)));
		g.setFont(new Font("宋体", Font.ITALIC,32));
		g.drawString("Merry Christmas", 350, 85);
	}
	/**
	 * 绘制图片到panel上
	 * @param g
	 */
	private void paintImg(Graphics2D g) {
		g.drawImage(GetImgUtil.icon.getImage(), 0,0, null);
		g.drawImage(CLOSE.getImage(),Width-CLOSE_WIDTH,0, null);
		g.drawImage(MIN.getImage(),Width-CLOSE_WIDTH-MIN_WIDTH-10,0, null);
		g.drawImage(CHANGE,(Width-CHANGE_WIDTH)/2,0,null);
		
	}
	
	/**
	 * 绘制雪花方法
	 * @param g
	 */
	
	private void paintSnow(Graphics2D g){
		for (int i = 0; i < x.length; i++) {
			g.setFont(new Font("宋体", Font.BOLD,(int) (Math.random()*32)));
			g.drawString(snow, x[i], y[i]);
		}
	}
	
	@Override
	public void run() {
		try {
			while(isSnow){
				Thread.sleep(130);
				christX-=10;
				if(christX<=-GetImgUtil.CHRIST.getIconWidth()){
					christX=Width;
				}
				for (int i = 0; i < x.length; i++) {
					int j=r.nextInt(2);
					y[i]+=10;
					x[i]=j==0?x[i]+5:x[i]-5;
					snowDown(i);
				}
				repaint();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 判断雪花出界回环的方法
	 * @param i
	 */
	private void snowDown(int i) {
		if(y[i]>=Height)
			y[i]=0;
		if(x[i]<=0)
			x[i]=Width;
		if(x[i]>=Width)
			x[i]=0;
	}
	/**
	 * 是否清屏去掉雪花
	 */
	public void function(){
		if(isSnow){
			isSnow=false;
			repaint();
		}else{
			isSnow=true;
			new Thread(this).start();
		}
	}
	/**
	 * 根据背景图片的改变，更改贺卡的宽高
	 * @param icon
	 */
	public static void set_Width_Height(Icon icon){
		Width=icon.getIconWidth();
		Height=icon.getIconHeight();
	}
}
