package com.tarena.shoot;
import java.util.Random;
/** 敌机:既是飞行物，也是敌人 */
public class Airplane extends FlyingObject implements Enemy {
	private int speed = 2;  //敌机走步的步数
	
	/** 构造方法 */
	public Airplane(){
		image = ShootGame.airplane;  //图片
		width = image.getWidth();  //宽
		height = image.getHeight();  //高
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH-this.width);  //x坐标
		//y = -height;   //y坐标
		y = 10;
	}
	
	/** 得分，打掉一个敌机，得5分 */
	public int getScore(){
		return 5;
	}
}
