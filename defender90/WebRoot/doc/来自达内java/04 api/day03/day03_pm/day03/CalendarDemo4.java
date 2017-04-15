package day03;

import java.util.Calendar;

/**
 * 获取Calendar中某个时间分量对应的值
 * @author Administrator
 *
 */
public class CalendarDemo4 {
	public static void main(String[] args) {
		Calendar calendar 
			= Calendar.getInstance();
		
		/*
		 * int get(int field)
		 * 根据给定的时间分量获取对应的值
		 */
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int date = calendar.get(Calendar.DATE);
		
		calendar.set(Calendar.DAY_OF_MONTH, 28);
		/*
		 * 一周的第一天是周日
		 */
		int w = calendar.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(year+"-"+month+"-"+date);
		System.out.println("星期:"+(w==1?7:w-1));
	}
}






