package com.tarena.shoot;
import java.awt.image.BufferedImage;
/** Ӣ�ۻ�:�Ƿ����� */
public class Hero extends FlyingObject {
	private int life;        //��
	private int doubleFire;  //����
	
	private BufferedImage[] images; //ͼƬ����
	private int index;   //ͼƬ�л���Ƶ������
	
	/** ���췽�� */
	public Hero(){
		image = ShootGame.hero0;     //ͼƬ
		width = image.getWidth();    //��
		height = image.getHeight();  //��
		x = 150;   //x����
		y = 400;   //y����
		life = 3;  //Ĭ��3����
		doubleFire = 0;  //Ĭ�ϵ�������
		images = new BufferedImage[]{ShootGame.hero0,ShootGame.hero1};
		index = 0;  //ͼƬ�л�������
	}
}




