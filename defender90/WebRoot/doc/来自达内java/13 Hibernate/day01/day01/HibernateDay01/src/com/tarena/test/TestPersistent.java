package com.tarena.test;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.tarena.entity.Emp;
import com.tarena.util.HibernateUtil;

/**
 *	测试对象持久性
 */
public class TestPersistent {

	/**
	 * 测试持久态对象存在于一级缓存中：
	 * 新增一条员工，则新增后的员工对象是持久态的，
	 * 此时若查询这条数据，发现没有打印查询SQL，
	 * 则可以证明持久态对象存在于一级缓存中。
	 */
	@Test
	public void test1() {
		//模拟新增的员工数据
		Emp e = new Emp();
		e.setName("孙悟空");
		e.setAge(30);
		e.setSalary(9000.0);
		e.setMarry(false);
		e.setBirthday(
			Date.valueOf("1984-05-06"));
		e.setLastLoginTime(
			new Timestamp(System.currentTimeMillis()));
		
		Session session = 
			HibernateUtil.getSession();
		Transaction ts = 
			session.beginTransaction();
		try {
			System.out.println("1---------");
			//save方法只是将临时态对象变为持久态，
			//并没有提交插入SQL，但是会产生id值。
			session.save(e);
			System.out.println("2---------");
			//此时对象已经是持久态了，查询这个对象,
			//会从缓存中取数。
			Emp emp = (Emp) session.get(
					Emp.class, e.getId());
			System.out.println(emp.getName());
			System.out.println("3---------");
			//commit方法会触发提交SQL，是调用
			//session.flush()实现的，并且提交事务。
			ts.commit();
		} catch (HibernateException e1) {
			e1.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}		
	}
	
	/**
	 * 测试持久态对象可以自动更新至数据库：
	 * 新增一条员工数据，新增后员工对象是持久态，
	 * 直接修改这个对象的值，再提交事务，看最终
	 * 保存的结果如何。
	 */
	@Test
	public void test2() {
		//模拟新增的员工数据
		Emp e = new Emp();
		e.setName("唐僧");
		e.setAge(30);
		e.setSalary(16000.0);
		e.setMarry(false);
		e.setBirthday(
			Date.valueOf("1984-05-06"));
		e.setLastLoginTime(
			new Timestamp(System.currentTimeMillis()));
		
		Session session = 
			HibernateUtil.getSession();
		Transaction ts = 
			session.beginTransaction();
		try {
			//将对象变为持久态
			session.save(e);
			//修改对象的值
			e.setName("猪八戒");
			e.setSalary(12000.0);
			//提交SQL及事务
			ts.commit();
		} catch (HibernateException e1) {
			e1.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}			
	}
	
	/**
	 * 测试自动更新的时机是session.flush()：
	 * 查询一条员工数据，则查询到的对象是持久态的，
	 * 修改这个对象的值，然后调用session.flush()
	 * 看控制台打印的sql。
	 */
	@Test
	public void test3() {
		Session session = 
			HibernateUtil.getSession();
		Emp e = (Emp) 
			session.get(Emp.class, 143);
		//修改员工对象的值
		e.setName("唐僧");
		e.setSalary(16000.0);
		//触发执行更新sql
		session.flush();
		session.close();
	}
	
}
