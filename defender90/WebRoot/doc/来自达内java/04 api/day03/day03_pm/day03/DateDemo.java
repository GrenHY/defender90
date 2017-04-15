package day03;

import java.util.Date;

/**
 * java.util.Date
 * 该类的每一个实例用于表示一个时间
 * @author Administrator
 *
 */
public class DateDemo {
	public static void main(String[] args) {
		/*
		 * 默认表示当前系统时间
		 */
		Date date = new Date();
		System.out.println(date);
		
		/*
		 * 获取该Date内部维护的long值
		 * 表示从1970-1-1 00:00:00到这一刻
		 * 的毫秒值
		 */
		long time = date.getTime();
		System.out.println(time);
		
		/*
		 * 让当前date表示给定毫秒所表示的时间
		 */
		date.setTime(time + 24 *60 * 60 * 1000);
		System.out.println(date);
		
		
	}
}




