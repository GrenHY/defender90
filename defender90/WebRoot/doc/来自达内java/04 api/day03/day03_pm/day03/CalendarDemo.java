package day03;

import java.util.Calendar;
import java.util.Date;

/**
 * 日历类
 * 用于操作时间的类
 * @author Administrator
 *
 */
public class CalendarDemo {
	public static void main(String[] args) {
		/*
		 * 默认创建的Calendar表示当前系统时间
		 */
		Calendar calendar 
				= Calendar.getInstance();
		System.out.println(calendar);
		/*
		 * Date getTime()
		 * 该方法用于获取一个Date对象，该对象表示
		 * 的时间就是当前Calendar所表示的时间
		 */
		Date date = calendar.getTime();
		System.out.println(date);
		
	}
}








