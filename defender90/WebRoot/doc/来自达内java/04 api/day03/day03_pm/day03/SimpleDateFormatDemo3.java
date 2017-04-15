package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 计算生命值
 * @author Administrator
 *
 */
public class SimpleDateFormatDemo3 {
	public static void main(String[] args) throws ParseException {
		/*
		 *	需求:
		 *   输入一个生日，输出到今天为止一共活了
		 *   多少天
		 *  思路:
		 *   1:将生日字符串转换为Date 
		 *   2:创建一个Date表示系统时间(今天)
		 *   3:获取今天的毫秒值
		 *   4:获取生日的毫秒值
		 *   5:用今天的毫秒值-生日的毫秒值
		 *   6:已经计算活了多少毫秒了
		 *     将该值除以一天的毫秒值就能得出一共
		 *     活了多少天
		 *   7:输出该天数完成功能  
		 */
		System.out.println(
			"请输入您的生日:(格式为 yyyy-MM-dd)");
		Scanner scanner 
					= new Scanner(System.in);
		String birthday = scanner.nextLine();
		
		/*
		 * 可以进行必要的判断，检查用户输入的是否为
		 * 一个日期格式
		 */
		String dateRegex 
			= "\\d{4}-\\d{2}-\\d{2}";
		if(!birthday.matches(dateRegex)){
			System.out.println("您输入的不是日期格式!");
			return;
		}
		
		SimpleDateFormat sdf
			= new SimpleDateFormat("yyyy-MM-dd");
		Date birDate = sdf.parse(birthday);
		System.out.println(birDate);
		
		
		//获取当前系统时间
		Date now = new Date();
		
		long birlong = birDate.getTime();
		long nowlong = now.getTime();
		
		long agelong = nowlong-birlong;
		long days = agelong/(24*60*60*1000);
		System.out.println(
				"恭喜您已经活了:"+days+"天");
		System.out.println(
				"距您诞辰100周年还有:"+(36500-days)+"天");
	}
}



