package day03;

import java.util.Calendar;
import java.util.Date;

/**
 * ʹ��Calendar����ʱ��
 * @author Administrator
 *
 */
public class CalendarDemo3 {
	public static void main(String[] args) {
		Calendar calendar
			= Calendar.getInstance();
		/*
		 * ϣ����ʾ 2008-08-30 10:22:33
		 */
		calendar.set(Calendar.YEAR, 2008);
		/*
		 *  �·ݵ�ֵ����ʹ�ó���
		 *  Ҳ����ֱ�Ӹ���ֵ����Ҫע��:�·ݴ�0��ʼ
		 *  ��:0��ʾ1��
		 */
		calendar.set(Calendar.MONTH, 7);
		/*
		 * Calendar.DATE��Calendar.DAY_OF_MONTH
		 * �ȼ�
		 */
		calendar.set(Calendar.DAY_OF_MONTH,30);
		calendar.set(Calendar.HOUR_OF_DAY, 10);
		calendar.set(Calendar.MINUTE, 22);
		calendar.set(Calendar.SECOND, 33);
		
		Date date = calendar.getTime();
		System.out.println(date);
		
	}
}





