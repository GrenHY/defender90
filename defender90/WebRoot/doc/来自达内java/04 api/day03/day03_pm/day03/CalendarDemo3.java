package day03;

import java.util.Calendar;
import java.util.Date;

/**
 * 使用Calendar设置时间
 * @author Administrator
 *
 */
public class CalendarDemo3 {
	public static void main(String[] args) {
		Calendar calendar
			= Calendar.getInstance();
		/*
		 * 希望表示 2008-08-30 10:22:33
		 */
		calendar.set(Calendar.YEAR, 2008);
		/*
		 *  月份的值可以使用常量
		 *  也可以直接给定值，需要注意:月份从0开始
		 *  即:0表示1月
		 */
		calendar.set(Calendar.MONTH, 7);
		/*
		 * Calendar.DATE与Calendar.DAY_OF_MONTH
		 * 等价
		 */
		calendar.set(Calendar.DAY_OF_MONTH,30);
		calendar.set(Calendar.HOUR_OF_DAY, 10);
		calendar.set(Calendar.MINUTE, 22);
		calendar.set(Calendar.SECOND, 33);
		
		Date date = calendar.getTime();
		System.out.println(date);
		
	}
}





