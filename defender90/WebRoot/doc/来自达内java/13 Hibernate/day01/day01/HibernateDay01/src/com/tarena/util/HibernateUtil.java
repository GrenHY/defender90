package com.tarena.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sf;
	
	static {
		//����Configuration
		Configuration conf = new Configuration();
		//���������ļ�
		conf.configure("hibernate.cfg.xml");
		//����SessionFactory
		sf = conf.buildSessionFactory();		
	}
	
	/**
	 * ����Session
	 */
	public static Session getSession() {
		//����Session
		return sf.openSession();
	}

}
