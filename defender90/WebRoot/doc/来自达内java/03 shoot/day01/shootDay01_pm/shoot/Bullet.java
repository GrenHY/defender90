package com.tarena.shoot;
/** �ӵ�:�Ƿ�����  */
public class Bullet extends FlyingObject {
	private int speed = 3;  //�߲��Ĳ���
	
	/** �ӵ� */
	public Bullet(int x,int y){
		image = ShootGame.bullet;   //ͼƬ
		width = image.getWidth();   //��
		height = image.getHeight(); //��
		this.x = x;  //x����(����Ӣ�ۻ�����������)
		this.y = y;  //y����(����Ӣ�ۻ�����������)
	}
}
