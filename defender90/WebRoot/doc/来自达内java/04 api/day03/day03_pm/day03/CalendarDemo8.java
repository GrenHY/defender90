package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 输入一个日期，输出3年，3个月，3天后的当周的周三的日期
 * @author Administrator
 *
 */
public class CalendarDemo8 {
	public static void main(String[] args) throws ParseException {
		/*
		 * 1:创建Scanner
		 * 2:获取用户输入的日期
		 * 3:创建SimpleDateFormat
		 * 4:将字符串转换为Date
		 * 5:将Date转换为Calendar
		 * 6:计算时间
		 * 7:将Calendar转换为Date
		 * 8:将Date转换为字符串
		 * 9:输出
		 */
		Scanner scanner 
			= new Scanner(System.in);
		System.out.println("请输入一个日期:(格式为yyyy-MM-dd)");
		String dateStr = scanner.nextLine();
		SimpleDateFormat sdf
			= new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		Calendar calendar
			= Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, 3);
		calendar.add(Calendar.MONTH, 3);
		calendar.add(Calendar.DAY_OF_YEAR, 3);
		calendar.set(Calendar.DAY_OF_WEEK, 4);
		date = calendar.getTime();
		dateStr = sdf.format(date);
		System.out.println(dateStr);
		
	}
}






