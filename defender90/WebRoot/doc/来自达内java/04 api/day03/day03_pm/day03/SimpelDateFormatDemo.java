package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat���Ը��ݸ��������ڸ�ʽ�ַ���
 * ʹ�ÿ�����Date��String֮���໥ת��
 * @author Administrator
 *
 */
public class SimpelDateFormatDemo {
	public static void main(String[] args) {
		//��ʾ��ǰϵͳʱ��
		Date date = new Date();
		//���DateĬ�ϵ�toString�����ķ���ֵ
		System.out.println(date);
		/*
		 * ϣ������ĸ�ʽ��:2014-09-24 10:41:22
		 */
		String dateformat
			= "yyyy-MM-dd HH:mm:ss E a";
		/*
		 * java.text.SimleDateFormat
		 * ����ʱ��Ҫ�ƶ����ڸ�ʽ����������
		 * �����ĸ�ʽ����ת������
		 */
		SimpleDateFormat sdf
			= new SimpleDateFormat(dateformat);
		/*
		 * String format(Date date)
		 * ��������Date����SimpleDateFormatָ����
		 * ���ڸ�ʽת��Ϊ�ַ���
		 */
		String str = sdf.format(date);
		System.out.println(str);
	}
}








