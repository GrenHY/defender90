package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * ����һ�����ڣ����3�꣬3���£�3���ĵ��ܵ�����������
 * @author Administrator
 *
 */
public class CalendarDemo8 {
	public static void main(String[] args) throws ParseException {
		/*
		 * 1:����Scanner
		 * 2:��ȡ�û����������
		 * 3:����SimpleDateFormat
		 * 4:���ַ���ת��ΪDate
		 * 5:��Dateת��ΪCalendar
		 * 6:����ʱ��
		 * 7:��Calendarת��ΪDate
		 * 8:��Dateת��Ϊ�ַ���
		 * 9:���
		 */
		Scanner scanner 
			= new Scanner(System.in);
		System.out.println("������һ������:(��ʽΪyyyy-MM-dd)");
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






