package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * ��������ֵ
 * @author Administrator
 *
 */
public class SimpleDateFormatDemo3 {
	public static void main(String[] args) throws ParseException {
		/*
		 *	����:
		 *   ����һ�����գ����������Ϊֹһ������
		 *   ������
		 *  ˼·:
		 *   1:�������ַ���ת��ΪDate 
		 *   2:����һ��Date��ʾϵͳʱ��(����)
		 *   3:��ȡ����ĺ���ֵ
		 *   4:��ȡ���յĺ���ֵ
		 *   5:�ý���ĺ���ֵ-���յĺ���ֵ
		 *   6:�Ѿ�������˶��ٺ�����
		 *     ����ֵ����һ��ĺ���ֵ���ܵó�һ��
		 *     ���˶�����
		 *   7:�����������ɹ���  
		 */
		System.out.println(
			"��������������:(��ʽΪ yyyy-MM-dd)");
		Scanner scanner 
					= new Scanner(System.in);
		String birthday = scanner.nextLine();
		
		/*
		 * ���Խ��б�Ҫ���жϣ�����û�������Ƿ�Ϊ
		 * һ�����ڸ�ʽ
		 */
		String dateRegex 
			= "\\d{4}-\\d{2}-\\d{2}";
		if(!birthday.matches(dateRegex)){
			System.out.println("������Ĳ������ڸ�ʽ!");
			return;
		}
		
		SimpleDateFormat sdf
			= new SimpleDateFormat("yyyy-MM-dd");
		Date birDate = sdf.parse(birthday);
		System.out.println(birDate);
		
		
		//��ȡ��ǰϵͳʱ��
		Date now = new Date();
		
		long birlong = birDate.getTime();
		long nowlong = now.getTime();
		
		long agelong = nowlong-birlong;
		long days = agelong/(24*60*60*1000);
		System.out.println(
				"��ϲ���Ѿ�����:"+days+"��");
		System.out.println(
				"��������100���껹��:"+(36500-days)+"��");
	}
}



