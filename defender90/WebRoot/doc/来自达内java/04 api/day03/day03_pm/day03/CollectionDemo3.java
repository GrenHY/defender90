package day03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * ���ϵ���������
 * @author Administrator
 *
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		/*
		 * int size()
		 * ��ȡ���ϵ�Ԫ�ظ���
		 */
		int s = c.size();
		System.out.println("size:"+s);
		/*
		 * boolean isEmpty()
		 * �鿴�������Ƿ񲻺����κ�Ԫ��
		 */
		boolean e = c.isEmpty();
		System.out.println("������Ԫ��:"+e);
		
		c.add("1");
		c.add(new Date());
		
		System.out.println("size:"+c.size());//2
		System.out.println("������Ԫ��:"+c.isEmpty());//false
		
		/*
		 * ��ռ���
		 */
		c.clear();
		
		System.out.println("size:"+c.size());//0
		System.out.println("������Ԫ��:"+c.isEmpty());//true
		
	}
}




