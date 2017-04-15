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
 * panel��
 * @author ��ʫ������
 *
 */
public class ChristMasPanel extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	
	/**�̶���ѩ����״*/
	private static final String snow="*";
	
	/**�̶���UIͼƬ��������ô������һ���ģ����Զ���Ϊ����*/
	private static final ImageIcon CLOSE=GetImgUtil.CLOSE;
	private static final ImageIcon MIN=GetImgUtil.MIN;
	private static final Image CHANGE=GetImgUtil.CHANGE;
	
	/**panel�ĳ������ñ���ͼƬ��̬�õ�����*/
	public static int Width=GetImgUtil.icon.getIconWidth();
	public static int Height=GetImgUtil.icon.getIconHeight();
	
	/**����ͼƬ��ùرհ�ť�ĳ�������ȷ����ťλ�ü�����¼����ж�*/
	public static final int CLOSE_WIDTH=CLOSE.getIconWidth();
	public static final int CLOSE_HEIGHT=CLOSE.getIconHeight();
	
	/**����ͼƬ���min��ť�ĳ�������ȷ����ťλ�ü�����¼����ж�*/
	public static final int MIN_WIDTH=MIN.getIconWidth();
	public static final int MIN_HEIGHT=MIN.getIconHeight();
	
	/**����ͼƬ���change��ť�ĳ�������ȷ����ťλ�ü�����¼����ж�*/
	public static final int CHANGE_WIDTH=CHANGE.getWidth(null);
	public static final int CHANGE_HEIGHT=CHANGE.getHeight(null);
	
	/**�ж��Ƿ��ںؿ�����ʾѩ�� */
	public static boolean isSnow=true;
	/**�жϵ�ǰ�ĺؿ�����*/
	public boolean show_Back=true;
	/**���ϻ��е�ʥ�����˵ĳ�ʼ������*/
	public int christX=Width-GetImgUtil.CHRIST.getIconWidth();
	/**ѩ���ĺ�������ļ�������*/
	private int []x=new int[50];
	private int []y=new int[50];
	
	private Random r=new Random();
	
	public ChristMasPanel() {
		initSnow();
		repaint();
	}
	/**
	 * ��ʼ��ѩ��
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
	 * ����merry ChristMas
	 * @param g
	 */
	private void paintTitle(Graphics2D g) {
		g.setColor(new Color(r.nextInt(0xffffff)));
		g.setFont(new Font("����", Font.ITALIC,32));
		g.drawString("Merry Christmas", 350, 85);
	}
	/**
	 * ����ͼƬ��panel��
	 * @param g
	 */
	private void paintImg(Graphics2D g) {
		g.drawImage(GetImgUtil.icon.getImage(), 0,0, null);
		g.drawImage(CLOSE.getImage(),Width-CLOSE_WIDTH,0, null);
		g.drawImage(MIN.getImage(),Width-CLOSE_WIDTH-MIN_WIDTH-10,0, null);
		g.drawImage(CHANGE,(Width-CHANGE_WIDTH)/2,0,null);
		
	}
	
	/**
	 * ����ѩ������
	 * @param g
	 */
	
	private void paintSnow(Graphics2D g){
		for (int i = 0; i < x.length; i++) {
			g.setFont(new Font("����", Font.BOLD,(int) (Math.random()*32)));
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
	 * �ж�ѩ������ػ��ķ���
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
	 * �Ƿ�����ȥ��ѩ��
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
	 * ���ݱ���ͼƬ�ĸı䣬���ĺؿ��Ŀ��
	 * @param icon
	 */
	public static void set_Width_Height(Icon icon){
		Width=icon.getIconWidth();
		Height=icon.getIconHeight();
	}
}
