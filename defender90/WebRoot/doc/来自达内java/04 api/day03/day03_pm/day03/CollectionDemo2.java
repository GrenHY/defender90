package day03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * �鿴�������Ƿ����������Ԫ��
 * @author Administrator
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection c 
			= new ArrayList();
		Cell c1 = new Cell(1,2);
		Cell c2 = new Cell(2,3);
		Cell c3 = new Cell(3,4);
		c.add(c1);
		c.add(c2);
		c.add(c3);		
		Cell c4 = new Cell(3,4);
		/*
		 * boolean contains(Object o)
		 * �鿴��ǰ�������Ƿ����������Ԫ��o
		 * 
		 * ����ȡ���ڼ����е�Ԫ���Ƿ��������Ԫ��
		 * equals�Ƚ�Ϊtrue�ġ�
		 */
		if(c.contains(c4)){
			System.out.println("����");
		}else{
			System.out.println("������");
		}
		
	}
}
