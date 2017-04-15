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
	 * ����ID��ѯԱ��
	 */
	@Test
	public void test1() {
		//����Session
		Session session = 
			HibernateUtil.getSession();
		//ִ�в�ѯ
		Emp e = (Emp) session.get(Emp.class, 1);
		System.out.println(
			e.getId() + " " +
			e.getName() + " " +
			e.getSalary()
		);
		//�ر�Session
		session.close();
	}
	
	/**
	 * ����Ա��
	 */
	@Test
	public void test2() {
		//ģ��������Ա������
		Emp e = new Emp();
		e.setName("�����");
		e.setAge(30);
		e.setSalary(9000.0);
		e.setMarry(false);
		e.setBirthday(
			Date.valueOf("1984-05-06"));
		e.setLastLoginTime(
			new Timestamp(System.currentTimeMillis()));
		
		Session session = 
			HibernateUtil.getSession();
		//��������
		Transaction ts = 
			session.beginTransaction();
		//ִ�в���
		try {
			session.save(e);
			//�ύ����
			ts.commit();
		} catch (HibernateException e1) {
			e1.printStackTrace();
			//�ع�����
			ts.rollback();
		} finally {
			session.close();
		}
	}
	
	/**
	 * �޸�Ա��
	 */
	@Test
	public void test3() {
		Session session = 
			HibernateUtil.getSession();
		//��ѯ��Ҫ�޸ĵ�����
		Emp e = (Emp) session.get(Emp.class, 141);
		//ģ���޸�Ա������
		e.setName("��ɮ");
		e.setSalary(16000.0);
		
		Transaction ts = 
			session.beginTransaction();
		try {
			//ִ���޸�
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
		//Ҫɾ����Ա������
		Emp e = new Emp();
		e.setId(141);
		
		Session session = 
			HibernateUtil.getSession();
		Transaction ts = 
			session.beginTransaction();
		try {
			//ִ��ɾ��
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
	 * ��ѯȫ��Ա��
	 */
	@Test
	public void test5() {
		//hql�п��԰��������ͷ����������ܰ�����������
		//��������hql�������������ģ��Ǵ�Сд���еġ�
		String hql = "from Emp";
		Session session = HibernateUtil.getSession();
		//����hql��������ѯ����
		Query query = session.createQuery(hql);
		//ִ�в�ѯ
		List<Emp> list = query.list();
		for(Emp e : list) {
			System.out.println(
				e.getId() + " " + e.getName());
		}
		session.close();
	}

}
