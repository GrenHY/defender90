package day03;

import java.util.Calendar;

/**
 * 使用Calendar计算时间
 * @author Administrator
 */
public class CalendarDemo5 {
	public static void main(String[] args) {
		Calendar calendar
			= Calendar.getInstance();
		/*
		 * void add(int field,int n)
		 * 为当前Calendar指定时间分量上累加给定值
		 * 若传入的是负数，则是累减
		 */
		calendar.add(Calendar.DAY_OF_YEAR, 15);
		
		System.out.println(calendar.getTime());
		
	}
}



