package day03;

import java.util.Calendar;

/**
 * ��ȡCalendar��ĳ��ʱ�������Ӧ��ֵ
 * @author Administrator
 *
 */
public class CalendarDemo4 {
	public static void main(String[] args) {
		Calendar calendar 
			= Calendar.getInstance();
		
		/*
		 * int get(int field)
		 * ���ݸ�����ʱ�������ȡ��Ӧ��ֵ
		 */
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int date = calendar.get(Calendar.DATE);
		
		calendar.set(Calendar.DAY_OF_MONTH, 28);
		/*
		 * һ�ܵĵ�һ��������
		 */
		int w = calendar.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(year+"-"+month+"-"+date);
		System.out.println("����:"+(w==1?7:w-1));
	}
}






