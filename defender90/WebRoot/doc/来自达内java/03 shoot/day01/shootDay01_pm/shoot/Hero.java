package com.tarena.shoot;
import java.awt.image.BufferedImage;
/** 英雄机:是飞行物 */
public class Hero extends FlyingObject {
	private int life;        //命
	private int doubleFire;  //火力
	
	private BufferedImage[] images; //图片数组
	private int index;   //图片切换的频率索引
	
	/** 构造方法 */
	public Hero(){
		image = ShootGame.hero0;     //图片
		width = image.getWidth();    //宽
		height = image.getHeight();  //高
		x = 150;   //x坐标
		y = 400;   //y坐标
		life = 3;  //默认3条命
		doubleFire = 0;  //默认单倍火力
		images = new BufferedImage[]{ShootGame.hero0,ShootGame.hero1};
		index = 0;  //图片切换的索引
	}
}




