package day03;

import java.util.Calendar;
import java.util.Date;

/**
 * ������
 * ���ڲ���ʱ�����
 * @author Administrator
 *
 */
public class CalendarDemo {
	public static void main(String[] args) {
		/*
		 * Ĭ�ϴ�����Calendar��ʾ��ǰϵͳʱ��
		 */
		Calendar calendar 
				= Calendar.getInstance();
		System.out.println(calendar);
		/*
		 * Date getTime()
		 * �÷������ڻ�ȡһ��Date���󣬸ö����ʾ
		 * ��ʱ����ǵ�ǰCalendar����ʾ��ʱ��
		 */
		Date date = calendar.getTime();
		System.out.println(date);
		
	}
}








