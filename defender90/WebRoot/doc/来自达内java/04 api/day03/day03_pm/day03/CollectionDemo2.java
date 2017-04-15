package day03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 查看集合中是否包含给定的元素
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
		 * 查看当前集合中是否包含给定的元素o
		 * 
		 * 包含取决于集合中的元素是否有与给定元素
		 * equals比较为true的。
		 */
		if(c.contains(c4)){
			System.out.println("包含");
		}else{
			System.out.println("不包含");
		}
		
	}
}
