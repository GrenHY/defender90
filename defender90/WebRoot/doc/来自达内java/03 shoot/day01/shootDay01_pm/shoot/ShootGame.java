package com.tarena.shoot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Graphics; 


/** 射击游戏类 */
public class ShootGame extends JPanel {
	
	public static final int WIDTH = 400;  //宽
	public static final int HEIGHT = 654; //高
	
	public static BufferedImage background; //背景
	public static BufferedImage start;  //开始
	public static BufferedImage pause;  //暂停
	public static BufferedImage gameover; //游戏结束
	public static BufferedImage airplane; //敌机
	public static BufferedImage bee;   //蜜蜂
	public static BufferedImage bullet; //子弹
	public static BufferedImage hero0;  //英雄机1
	public static BufferedImage hero1;  //英雄机2
	
	private Hero hero = new Hero();  //英雄机
	private Bullet[] bullets = {};   //子弹
	private FlyingObject[] flyings = {}; //敌人(敌机、蜜蜂)
	
	public ShootGame(){
		bullets = new Bullet[2];
		bullets[0] = new Bullet(0,0);
		bullets[1] = new Bullet(40,100);
		
		flyings = new FlyingObject[2];
		flyings[0] = new Airplane();
		flyings[1] = new Bee();
	}
	
	static{   //加载静态资源(图片、音频、视频)
		try {
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** 重写paint方法，实现绘制/画    
	 *  g:画笔
	 *  paint()方法是被自动调用的:
	 *    1)frame.setVisible(true);
	 *    2)repaint();*/
	public void paint(Graphics g){
		g.drawImage(background,0,0,null); //画背景图
		paintHero(g);   //画英雄机
		paintBullets(g);  //画子弹
		paintFlyingObjects(g);  //画敌人
	}
	
	/** 画英雄机 */
	public void paintHero(Graphics g){
		g.drawImage(hero.image,hero.x,hero.y,null);
	}
	
	/** 画子弹 */
	public void paintBullets(Graphics g){
		for(int i=0;i<bullets.length;i++){ //遍历所有子弹
			Bullet b = bullets[i];  //每一个子弹对象
			g.drawImage(b.image,b.x,b.y,null);
		}
	}
	
	/** 画敌人(敌机、蜜蜂) */
	public void paintFlyingObjects(Graphics g){
		for(int i=0;i<flyings.length;i++){ //遍历所有敌人
			FlyingObject f = flyings[i];  //每一个敌人对象
			g.drawImage(f.image,f.x,f.y,null);
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fly"); //框
		ShootGame game = new ShootGame(); //面板
		frame.add(game);  //将面板添加到框中
		
		frame.setSize(WIDTH,HEIGHT);  //设置框的大小
		frame.setAlwaysOnTop(true); //设置总在最上面
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置默认关闭操作
		frame.setLocationRelativeTo(null); //设置窗体初始位置
		frame.setVisible(true); //设置可见，尽快调用paint()方法	
	}
}






