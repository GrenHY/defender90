package day03;

import java.util.Calendar;
import java.util.Date;

/**
 * Date��Calendar��ת��
 * @author Administrator
 *
 */
public class CalendarDemo2 {
	public static void main(String[] args) {
		//����һ��Date����
		Date date = new Date();		
		/*
		 * ϣ��ʹ��Calendar��ʾ��ǰDate����ʾ��
		 * ʱ��
		 */
		Calendar calendar
			= Calendar.getInstance();
		/*
		 * Calendar�ṩһ������
		 * void setTime(Date date)
		 * �÷�������ʹ��ǰCalendar��ʾ������
		 * Date����ʾ��ʱ��
		 */
		calendar.setTime(date);
		
	}
}




