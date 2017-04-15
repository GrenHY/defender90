package com.tarena.test;

import org.hibernate.Session;
import org.junit.Test;

import com.tarena.entity.Emp;
import com.tarena.util.HibernateUtil;

/**
 *	测试一级缓存
 */
public class TestFirstCache {

	/**
	 * 测试存在一级缓存：
	 * 使用同一个Session查询同一条数据2次，
	 * 如果第2次查询没有打印SQL，则说明存在
	 * 一级缓存。
	 */
	@Test
	public void test1() {
		Session session = 
			HibernateUtil.getSession();
		//第一次查询id=1的员工
		Emp e1 = (Emp) session.get(Emp.class, 1);
		System.out.println(e1.getName());
		
		System.out.println("---------------");
		
//		session.evict(e1);
		session.clear();
		
		//第二次查询id=1的员工
		Emp e2 = (Emp) session.get(Emp.class, 1);
		System.out.println(e2.getName());
		
		session.close();
	}
	
	/**
	 * 测试一级缓存是Session独享的：
	 * 使用2个Session分别查询id=1的员工，
	 * 如果第2个Session查询时打印了SQL，
	 * 则说明第2次查询没从缓存中取数，即
	 * 证明了一级缓存是Session独享的。
	 */
	@Test
	public void test2() {
		//使用第一个Session查询id=1的员工
		Session session1 = 
			HibernateUtil.getSession();
		Emp e1 = (Emp) session1.get(Emp.class, 1);
		System.out.println(e1.getName());
		
		System.out.println("--------------");
		
		//使用第二个Session查询id=1的员工
		Session session2 = 
			HibernateUtil.getSession();
		Emp e2 = (Emp) session2.get(Emp.class, 1);
		System.out.println(e2.getName());
		
		session1.close();
		session2.close();
	}
	
}
