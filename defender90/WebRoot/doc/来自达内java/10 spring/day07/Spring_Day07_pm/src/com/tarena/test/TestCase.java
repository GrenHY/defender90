package com.tarena.test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tarena.dao.EmpDao;
import com.tarena.entity.Emp;

public class TestCase {
	//@Test
	public void testDataSource()
		throws Exception{
		String cfg = "spring-mvc.xml";
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(cfg);
		DataSource dbcp = ctx.getBean(
				"dataSource", DataSource.class);
		DataSource c3p0 = ctx.getBean(
				"dataSource1", DataSource.class);
		Connection c1 = dbcp.getConnection();
		Connection c2 = c3p0.getConnection();
		System.out.println(c1);
		System.out.println(c2);
		c1.close();
		c2.close();
	}
	//@Test
	public void testJdbcTemplate()
		throws Exception{
		String cfg = "spring-mvc.xml";
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(cfg);
		JdbcTemplate template = ctx.getBean(
				"jdbcTemplate", JdbcTemplate.class);
		String sql = "select 1 as A from dual";
		//简洁的SQL执行支持
		Integer num = template.queryForObject(
				sql, Integer.class);
		System.out.println(num);//1
	}
	//@Test
	public void testAddEmp()
		throws Exception{
		String cfg = "spring-mvc.xml";
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(cfg);
		EmpDao dao = ctx.getBean( 
				"empDao", EmpDao.class);
		dao.add(new Emp("Tom", 1,
				new Date(System.currentTimeMillis()),
				255.5, 23.0, 1));
	}
	//@Test
	public void testUpdateEmp()
		throws Exception{
		String cfg = "spring-mvc.xml";
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(cfg);
		EmpDao dao = ctx.getBean( 
				"empDao", EmpDao.class);
		Emp emp = dao.findById(1);
		System.out.println(emp);
		emp.setEname("Jerry");
		dao.update(emp);
		emp = dao.findById(1);
		System.out.println(emp);
		
	}
	@Test
	public void testFind()
		throws Exception{
		String cfg = "spring-mvc.xml";
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(cfg);
		EmpDao dao = ctx.getBean( 
				"empDao", EmpDao.class);
		List<Emp> list1 = dao.findAll();
		List<Emp> list2 = dao.findByDept(1);
		System.out.println(list1);
		System.out.println(list2);
		Emp emp = dao.findById(5);
		System.out.println(emp);
	}
}





