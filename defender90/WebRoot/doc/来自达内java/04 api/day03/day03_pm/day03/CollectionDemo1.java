package day03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ����--���ڱ���һ������
 * @author Administrator
 *
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		Collection c = new ArrayList();		
		Cell cell = new Cell(1,2);
		Cell cell2 = new Cell(3,4);
		/*
		 * ���ϱ������Ԫ�ص�����
		 */
		c.add(cell);
		c.add(cell2);		
		System.out.println(c);
		//�����ı��Ԫ�ص�����
		cell.x = 2;
		//�����и�Ԫ�ص�����Ҳ���ŷ����˸ı�
		System.out.println(c);
		
	}
}



