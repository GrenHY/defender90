package com.tarena.shoot;
/** 子弹:是飞行物  */
public class Bullet extends FlyingObject {
	private int speed = 3;  //走步的步数
	
	/** 子弹 */
	public Bullet(int x,int y){
		image = ShootGame.bullet;   //图片
		width = image.getWidth();   //宽
		height = image.getHeight(); //高
		this.x = x;  //x坐标(根据英雄机坐标计算而得)
		this.y = y;  //y坐标(根据英雄机坐标计算而得)
	}
}
