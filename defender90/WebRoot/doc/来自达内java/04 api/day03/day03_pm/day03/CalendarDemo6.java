package day03;

import java.util.Calendar;

/**
 * 三个月后的十天后的那周的周三是几号
 * @author Administrator
 *
 */
public class CalendarDemo6 {
	public static void main(String[] args) {
		Calendar calendar
			= Calendar.getInstance();
		calendar.add(Calendar.MONTH, 3);
		calendar.add(Calendar.DAY_OF_YEAR, 10);
		calendar.set(Calendar.DAY_OF_WEEK, 4);
		
		System.out.println(calendar.getTime());
	}
}
