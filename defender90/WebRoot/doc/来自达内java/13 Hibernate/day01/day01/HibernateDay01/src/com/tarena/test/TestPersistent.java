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
 *	���Զ���־���
 */
public class TestPersistent {

	/**
	 * ���Գ־�̬���������һ�������У�
	 * ����һ��Ա�������������Ա�������ǳ־�̬�ģ�
	 * ��ʱ����ѯ�������ݣ�����û�д�ӡ��ѯSQL��
	 * �����֤���־�̬���������һ�������С�
	 */
	@Test
	public void test1() {
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
		Transaction ts = 
			session.beginTransaction();
		try {
			System.out.println("1---------");
			//save����ֻ�ǽ���ʱ̬�����Ϊ�־�̬��
			//��û���ύ����SQL�����ǻ����idֵ��
			session.save(e);
			System.out.println("2---------");
			//��ʱ�����Ѿ��ǳ־�̬�ˣ���ѯ�������,
			//��ӻ�����ȡ����
			Emp emp = (Emp) session.get(
					Emp.class, e.getId());
			System.out.println(emp.getName());
			System.out.println("3---------");
			//commit�����ᴥ���ύSQL���ǵ���
			//session.flush()ʵ�ֵģ������ύ����
			ts.commit();
		} catch (HibernateException e1) {
			e1.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}		
	}
	
	/**
	 * ���Գ־�̬��������Զ����������ݿ⣺
	 * ����һ��Ա�����ݣ�������Ա�������ǳ־�̬��
	 * ֱ���޸���������ֵ�����ύ���񣬿�����
	 * ����Ľ����Ρ�
	 */
	@Test
	public void test2() {
		//ģ��������Ա������
		Emp e = new Emp();
		e.setName("��ɮ");
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
			//�������Ϊ�־�̬
			session.save(e);
			//�޸Ķ����ֵ
			e.setName("��˽�");
			e.setSalary(12000.0);
			//�ύSQL������
			ts.commit();
		} catch (HibernateException e1) {
			e1.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
		}			
	}
	
	/**
	 * �����Զ����µ�ʱ����session.flush()��
	 * ��ѯһ��Ա�����ݣ����ѯ���Ķ����ǳ־�̬�ģ�
	 * �޸���������ֵ��Ȼ�����session.flush()
	 * ������̨��ӡ��sql��
	 */
	@Test
	public void test3() {
		Session session = 
			HibernateUtil.getSession();
		Emp e = (Emp) 
			session.get(Emp.class, 143);
		//�޸�Ա�������ֵ
		e.setName("��ɮ");
		e.setSalary(16000.0);
		//����ִ�и���sql
		session.flush();
		session.close();
	}
	
}
