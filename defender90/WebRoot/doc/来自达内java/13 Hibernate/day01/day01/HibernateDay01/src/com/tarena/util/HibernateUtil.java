package com.tarena.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sf;
	
	static {
		//创建Configuration
		Configuration conf = new Configuration();
		//加载配置文件
		conf.configure("hibernate.cfg.xml");
		//创建SessionFactory
		sf = conf.buildSessionFactory();		
	}
	
	/**
	 * 创建Session
	 */
	public static Session getSession() {
		//创建Session
		return sf.openSession();
	}

}
