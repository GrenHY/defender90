package day03;

import java.util.Calendar;

/**
 * ʹ��Calendar����ʱ��
 * @author Administrator
 */
public class CalendarDemo5 {
	public static void main(String[] args) {
		Calendar calendar
			= Calendar.getInstance();
		/*
		 * void add(int field,int n)
		 * Ϊ��ǰCalendarָ��ʱ��������ۼӸ���ֵ
		 * ��������Ǹ����������ۼ�
		 */
		calendar.add(Calendar.DAY_OF_YEAR, 15);
		
		System.out.println(calendar.getTime());
		
	}
}



