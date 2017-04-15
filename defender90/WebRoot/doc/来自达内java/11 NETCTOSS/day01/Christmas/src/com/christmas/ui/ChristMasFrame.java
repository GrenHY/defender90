package com.christmas.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.christmas.util.GetImgUtil;
import com.christmas.util.sound.SoundManager;

/**
 * frame类
 * @author 四诗风雅颂
 *
 */
public class ChristMasFrame extends JFrame implements 
									MouseListener,MouseMotionListener{

	private static final long serialVersionUID = 1L;
	/**主面板*/
	private ChristMasPanel panel;
	/**鼠标是否压下*/
	private boolean isDraging;
	/**鼠标压下时frame左上角横坐标*/
	protected int xx;
	/**鼠标压下时frame左上角纵坐标*/
	protected int yy;
	/**声音适配器*/
	private SoundManager m;

	public void setPanel(ChristMasPanel panel) {
		this.panel = panel;
	}

	public ChristMasFrame(SoundManager m) {
		this.m=m;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	/**
	 * 根据图片大小设置frame的边框大小
	 * @param icon
	 */
	public void setSize(Icon icon){
		super.setSize(icon.getIconWidth(), icon.getIconHeight());
	}
	/**
	 * 根据图片大小初始化frame信息
	 * @param icon
	 */
	public void init(Icon icon){
		this.setSize(icon);
		this.setIconImage(GetImgUtil.LOGO);
		this.setUndecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationByIcon(GetImgUtil.icon);
		this.add(panel);
		this.setVisible(true);
		
	}
	/**
	 * 线程启动方法
	 */
	public void start(){
		new Thread(panel).start();
	}
	/**
	 * 通过图片尺寸设置frame所在位置
	 * @param icon
	 */
	public void setLocationByIcon(ImageIcon icon) {
		int x,y;
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		x=(int) ((d.getWidth()-icon.getIconWidth())/2);
		y=(int) ((d.getHeight()-icon.getIconHeight())/2);
		this.setLocation(x, y);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (isDraging) {
			int left =getLocation().x;
			int top = getLocation().y;
			setLocation(left + e.getX() - xx, top + e.getY() - yy);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(getLocation().x+":"+getLocation().y);
		int x=e.getX();
		int y=e.getY();
		onClick(x, y);
	}
	/**
	 * 鼠标单击事件判断
	 * @param x
	 * @param y
	 */
	private void onClick(int x, int y) {
		if(isClose(x, y)){
			m.closeLoop();
			m.close();
			System.exit(EXIT_ON_CLOSE);
		}else if(isMin(x, y)){
			this.setState(JFrame.ICONIFIED);
		}else if(isChange(x,y)){
			changeBackgroundImage();
			setSize(GetImgUtil.icon);
			setLocationByIcon(GetImgUtil.icon);
			panel.repaint();
		}else{
			panel.function();
		}
	}
	/**
	 * 更换背景图片方法
	 */
	private void changeBackgroundImage() {
		if(panel.show_Back){
			GetImgUtil.icon.setImage(GetImgUtil.BACK.getImage());
			ChristMasPanel.set_Width_Height(GetImgUtil.icon);
			panel.initSnow();
			panel.show_Back=false;
		}else{
			ImageIcon icon=new ImageIcon(GetImgUtil.getImgUrl("christmas"));
			GetImgUtil.icon.setImage(icon.getImage());
			ChristMasPanel.set_Width_Height(GetImgUtil.icon);
			panel.initSnow();
			panel.show_Back=true;
		}
	}
	/**
	 * 判断点击位置是否在换图片的位子上
	 * @param x
	 * @param y
	 * @return flag
	 */
	private boolean isChange(int x, int y) {
		boolean flag= x>=(ChristMasPanel.Width-ChristMasPanel.CHANGE_WIDTH)/2 &&
				y>=0 && x<=(ChristMasPanel.Width+ChristMasPanel.CHANGE_WIDTH)/2
				&& y<=ChristMasPanel.CHANGE_HEIGHT;
		return flag;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		isDraging = true;
		xx = e.getX();
		yy = e.getY();
		System.out.println(xx+":"+yy);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		isDraging=false;
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	/**
	 * 判断是否处于min按钮的位置上
	 * @param x
	 * @param y
	 * @return flag
	 */
	private boolean isMin(int x,int y){
		boolean flag= x<=ChristMasPanel.Width-ChristMasPanel.CLOSE_WIDTH-10 && 
			x>=ChristMasPanel.Width-ChristMasPanel.CLOSE_WIDTH-ChristMasPanel.
					MIN_WIDTH-10&& y>=0 && y<=ChristMasPanel.MIN_HEIGHT;
		return flag;
	}
	/**
	 * 判断是否处于close按钮的位置上
	 * @param x
	 * @param y
	 * @return flag
	 */
	private boolean isClose(int x,int y){
		boolean flag= x<=ChristMasPanel.Width && x>=ChristMasPanel.Width-
				ChristMasPanel.CLOSE_WIDTH && y>=0 && 
				y<=ChristMasPanel.CLOSE_HEIGHT;
		return flag;
	}
}
