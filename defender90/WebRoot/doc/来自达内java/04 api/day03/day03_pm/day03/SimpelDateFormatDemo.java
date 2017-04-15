package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat可以根据给定的日期格式字符串
 * 使得可以在Date与String之间相互转换
 * @author Administrator
 *
 */
public class SimpelDateFormatDemo {
	public static void main(String[] args) {
		//表示当前系统时间
		Date date = new Date();
		//输出Date默认的toString方法的返回值
		System.out.println(date);
		/*
		 * 希望输出的格式是:2014-09-24 10:41:22
		 */
		String dateformat
			= "yyyy-MM-dd HH:mm:ss E a";
		/*
		 * java.text.SimleDateFormat
		 * 创建时需要制定日期格式，该类会根据
		 * 给定的格式进行转换工作
		 */
		SimpleDateFormat sdf
			= new SimpleDateFormat(dateformat);
		/*
		 * String format(Date date)
		 * 将给定的Date按照SimpleDateFormat指定的
		 * 日期格式转换为字符串
		 */
		String str = sdf.format(date);
		System.out.println(str);
	}
}








