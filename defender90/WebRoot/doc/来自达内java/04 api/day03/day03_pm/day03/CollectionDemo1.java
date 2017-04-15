package day03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合--用于保存一组数据
 * @author Administrator
 *
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		Collection c = new ArrayList();		
		Cell cell = new Cell(1,2);
		Cell cell2 = new Cell(3,4);
		/*
		 * 集合保存的是元素的引用
		 */
		c.add(cell);
		c.add(cell2);		
		System.out.println(c);
		//在外界改变该元素的内容
		cell.x = 2;
		//集合中该元素的内容也跟着发生了改变
		System.out.println(c);
		
	}
}



