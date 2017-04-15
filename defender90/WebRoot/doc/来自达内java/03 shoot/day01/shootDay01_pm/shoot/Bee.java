package com.tarena.shoot;
import java.util.Random;
/** 蜜蜂:既是飞行物，也是奖励 */
public class Bee extends FlyingObject implements Award {
	private int xSpeed = 1;  //走步时x步数
	private int ySpeed = 2;  //走步时y步数
	private int awardType;   //奖励的类型
	
	/** 构造方法 */
	public Bee(){
		image = ShootGame.bee;      //图片
		width = image.getWidth();   //宽
		height = image.getHeight(); //高
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - width);  //x坐标
		//y = -height;   //y坐标
		y = 10;
		awardType = rand.nextInt(2); //奖励类型，生成0和1
	}
	
	/** 获取奖励类型(awardType) */
	public int getType(){
		return awardType;
	}
}
