package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ʹ��SimpleDateFormat
 * ���ַ���ת��ΪDate
 * @author Administrator
 *
 */
public class SimpleDateFormatDemo2 {
	public static void main(String[] args) throws ParseException {
		String str = "2008-08-08 20:08:08";
		String dateFormat = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf
			= new SimpleDateFormat(dateFormat);
		/*
		 * Date parse(String str)
		 * ���������ַ�������SimpleDateFormatָ��
		 * �����ڸ�ʽ������ת��ΪDate���󷵻�
		 */
		Date date = sdf.parse(str);
		
		System.out.println(date);
		
	}
}




