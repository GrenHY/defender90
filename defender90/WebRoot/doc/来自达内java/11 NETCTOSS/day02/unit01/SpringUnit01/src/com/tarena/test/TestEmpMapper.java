package com.tarena.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.EmpMapper;
import com.tarena.entity.Emp;

public class TestEmpMapper {

	@Test
	public void testFindAll() {
		//创建Spring容器
		//容器会读取applicationContext.xml，
		//并实例化配置文件中声明的bean，然后
		//根据bean中的设置，自动扫描指定路径下
		//的mapper.xml，自动扫描指定路径下的
		//带有注解的接口/类，此处的接口是我们
		//自定义的接口。
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		//由容器创建Mapper
		EmpMapper mapper = 
			ctx.getBean(EmpMapper.class);
		List<Emp> list = mapper.findAll();
		for(Emp e : list) {
			System.out.println(
				e.getEmpno() + " " +
				e.getEname() + " " +
				e.getDeptno()
			);
		}
	}
	
}
