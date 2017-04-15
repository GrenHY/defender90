package com.tarena.shoot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Graphics; 


/** �����Ϸ�� */
public class ShootGame extends JPanel {
	
	public static final int WIDTH = 400;  //��
	public static final int HEIGHT = 654; //��
	
	public static BufferedImage background; //����
	public static BufferedImage start;  //��ʼ
	public static BufferedImage pause;  //��ͣ
	public static BufferedImage gameover; //��Ϸ����
	public static BufferedImage airplane; //�л�
	public static BufferedImage bee;   //�۷�
	public static BufferedImage bullet; //�ӵ�
	public static BufferedImage hero0;  //Ӣ�ۻ�1
	public static BufferedImage hero1;  //Ӣ�ۻ�2
	
	private Hero hero = new Hero();  //Ӣ�ۻ�
	private Bullet[] bullets = {};   //�ӵ�
	private FlyingObject[] flyings = {}; //����(�л����۷�)
	
	public ShootGame(){
		bullets = new Bullet[2];
		bullets[0] = new Bullet(0,0);
		bullets[1] = new Bullet(40,100);
		
		flyings = new FlyingObject[2];
		flyings[0] = new Airplane();
		flyings[1] = new Bee();
	}
	
	static{   //���ؾ�̬��Դ(ͼƬ����Ƶ����Ƶ)
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
	
	/** ��дpaint������ʵ�ֻ���/��    
	 *  g:����
	 *  paint()�����Ǳ��Զ����õ�:
	 *    1)frame.setVisible(true);
	 *    2)repaint();*/
	public void paint(Graphics g){
		g.drawImage(background,0,0,null); //������ͼ
		paintHero(g);   //��Ӣ�ۻ�
		paintBullets(g);  //���ӵ�
		paintFlyingObjects(g);  //������
	}
	
	/** ��Ӣ�ۻ� */
	public void paintHero(Graphics g){
		g.drawImage(hero.image,hero.x,hero.y,null);
	}
	
	/** ���ӵ� */
	public void paintBullets(Graphics g){
		for(int i=0;i<bullets.length;i++){ //���������ӵ�
			Bullet b = bullets[i];  //ÿһ���ӵ�����
			g.drawImage(b.image,b.x,b.y,null);
		}
	}
	
	/** ������(�л����۷�) */
	public void paintFlyingObjects(Graphics g){
		for(int i=0;i<flyings.length;i++){ //�������е���
			FlyingObject f = flyings[i];  //ÿһ�����˶���
			g.drawImage(f.image,f.x,f.y,null);
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fly"); //��
		ShootGame game = new ShootGame(); //���
		frame.add(game);  //�������ӵ�����
		
		frame.setSize(WIDTH,HEIGHT);  //���ÿ�Ĵ�С
		frame.setAlwaysOnTop(true); //��������������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����Ĭ�Ϲرղ���
		frame.setLocationRelativeTo(null); //���ô����ʼλ��
		frame.setVisible(true); //���ÿɼ����������paint()����	
	}
}






