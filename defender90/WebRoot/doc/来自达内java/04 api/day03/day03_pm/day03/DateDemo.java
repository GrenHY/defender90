package day03;

import java.util.Date;

/**
 * java.util.Date
 * �����ÿһ��ʵ�����ڱ�ʾһ��ʱ��
 * @author Administrator
 *
 */
public class DateDemo {
	public static void main(String[] args) {
		/*
		 * Ĭ�ϱ�ʾ��ǰϵͳʱ��
		 */
		Date date = new Date();
		System.out.println(date);
		
		/*
		 * ��ȡ��Date�ڲ�ά����longֵ
		 * ��ʾ��1970-1-1 00:00:00����һ��
		 * �ĺ���ֵ
		 */
		long time = date.getTime();
		System.out.println(time);
		
		/*
		 * �õ�ǰdate��ʾ������������ʾ��ʱ��
		 */
		date.setTime(time + 24 *60 * 60 * 1000);
		System.out.println(date);
		
		
	}
}




