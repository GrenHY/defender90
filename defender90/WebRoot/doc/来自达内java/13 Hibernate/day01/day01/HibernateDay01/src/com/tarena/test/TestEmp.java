package com.tarena.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.tarena.entity.Emp;
import com.tarena.util.HibernateUtil;

public class TestEmp {
	
	/**
	 * 根据ID查询员工
	 */
	@Test
	public void test1() {
		//创建Session
		Session session = 
			HibernateUtil.getSession();
		//执行查询
		Emp e = (Emp) session.get(Emp.class, 1);
		System.out.println(
			e.getId() + " " +
			e.getName() + " " +
			e.getSalary()
		);
		//关闭Session
		session.close();
	}
	
	/**
	 * 新增员工
	 */
	@Test
	public void test2() {
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
		//开启事务
		Transaction ts = 
			session.beginTransaction();
		//执行插入
		try {
			session.save(e);
			//提交事务
			ts.commit();
		} catch (HibernateException e1) {
			e1.printStackTrace();
			//回滚事务
			ts.rollback();
		} finally {
			session.close();
		}
	}
	
	/**
	 * 修改员工
	 */
	@Test
	public void test3() {
		Session session = 
			HibernateUtil.getSession();
		//查询出要修改的数据
		Emp e = (Emp) session.get(Emp.class, 141);
		//模拟修改员工数据
		e.setName("唐僧");
		e.setSalary(16000.0);
		
		Transaction ts = 
			session.beginTransaction();
		try {
			//执行修改
			session.update(e);
			ts.commit();
		} catch (HibernateException e1) {
			e1.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test4() {
		//要删除的员工对象
		Emp e = new Emp();
		e.setId(141);
		
		Session session = 
			HibernateUtil.getSession();
		Transaction ts = 
			session.beginTransaction();
		try {
			//执行删除
			session.delete(e);
			ts.commit();
		} catch (HibernateException e1) {
			e1.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}
	}
	
	/**
	 * 查询全部员工
	 */
	@Test
	public void test5() {
		//hql中可以包含类名和方法名，不能包含表名和字
		//段名，即hql本身是面向对象的，是大小写敏感的。
		String hql = "from Emp";
		Session session = HibernateUtil.getSession();
		//编译hql，创建查询对象
		Query query = session.createQuery(hql);
		//执行查询
		List<Emp> list = query.list();
		for(Emp e : list) {
			System.out.println(
				e.getId() + " " + e.getName());
		}
		session.close();
	}

}
