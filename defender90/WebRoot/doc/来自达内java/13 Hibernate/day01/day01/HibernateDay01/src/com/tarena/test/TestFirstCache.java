package com.tarena.test;

import org.hibernate.Session;
import org.junit.Test;

import com.tarena.entity.Emp;
import com.tarena.util.HibernateUtil;

/**
 *	����һ������
 */
public class TestFirstCache {

	/**
	 * ���Դ���һ�����棺
	 * ʹ��ͬһ��Session��ѯͬһ������2�Σ�
	 * �����2�β�ѯû�д�ӡSQL����˵������
	 * һ�����档
	 */
	@Test
	public void test1() {
		Session session = 
			HibernateUtil.getSession();
		//��һ�β�ѯid=1��Ա��
		Emp e1 = (Emp) session.get(Emp.class, 1);
		System.out.println(e1.getName());
		
		System.out.println("---------------");
		
//		session.evict(e1);
		session.clear();
		
		//�ڶ��β�ѯid=1��Ա��
		Emp e2 = (Emp) session.get(Emp.class, 1);
		System.out.println(e2.getName());
		
		session.close();
	}
	
	/**
	 * ����һ��������Session����ģ�
	 * ʹ��2��Session�ֱ��ѯid=1��Ա����
	 * �����2��Session��ѯʱ��ӡ��SQL��
	 * ��˵����2�β�ѯû�ӻ�����ȡ������
	 * ֤����һ��������Session����ġ�
	 */
	@Test
	public void test2() {
		//ʹ�õ�һ��Session��ѯid=1��Ա��
		Session session1 = 
			HibernateUtil.getSession();
		Emp e1 = (Emp) session1.get(Emp.class, 1);
		System.out.println(e1.getName());
		
		System.out.println("--------------");
		
		//ʹ�õڶ���Session��ѯid=1��Ա��
		Session session2 = 
			HibernateUtil.getSession();
		Emp e2 = (Emp) session2.get(Emp.class, 1);
		System.out.println(e2.getName());
		
		session1.close();
		session2.close();
	}
	
}
