package day03;

import java.util.Calendar;

/**
 * ��ȡĳ��ʱ���������������ֵ
 * @author Administrator
 *
 */
public class CalendarDemo7 {
	public static void main(String[] args) {
		Calendar calendar
			= Calendar.getInstance();
		/*
		 * ��ȡ�����ܹ�������
		 */
		int days = calendar.getActualMaximum(
						Calendar.DAY_OF_MONTH);
		System.out.println(days);
	}
}	








