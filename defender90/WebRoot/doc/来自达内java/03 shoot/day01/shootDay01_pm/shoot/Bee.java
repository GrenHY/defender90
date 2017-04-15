package com.tarena.shoot;
import java.util.Random;
/** �۷�:���Ƿ����Ҳ�ǽ��� */
public class Bee extends FlyingObject implements Award {
	private int xSpeed = 1;  //�߲�ʱx����
	private int ySpeed = 2;  //�߲�ʱy����
	private int awardType;   //����������
	
	/** ���췽�� */
	public Bee(){
		image = ShootGame.bee;      //ͼƬ
		width = image.getWidth();   //��
		height = image.getHeight(); //��
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - width);  //x����
		//y = -height;   //y����
		y = 10;
		awardType = rand.nextInt(2); //�������ͣ�����0��1
	}
	
	/** ��ȡ��������(awardType) */
	public int getType(){
		return awardType;
	}
}
