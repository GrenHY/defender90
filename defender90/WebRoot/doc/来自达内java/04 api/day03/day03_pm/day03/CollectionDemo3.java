package day03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 集合的其他方法
 * @author Administrator
 *
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		/*
		 * int size()
		 * 获取集合的元素个数
		 */
		int s = c.size();
		System.out.println("size:"+s);
		/*
		 * boolean isEmpty()
		 * 查看集合中是否不含有任何元素
		 */
		boolean e = c.isEmpty();
		System.out.println("不含有元素:"+e);
		
		c.add("1");
		c.add(new Date());
		
		System.out.println("size:"+c.size());//2
		System.out.println("不含有元素:"+c.isEmpty());//false
		
		/*
		 * 清空集合
		 */
		c.clear();
		
		System.out.println("size:"+c.size());//0
		System.out.println("不含有元素:"+c.isEmpty());//true
		
	}
}




