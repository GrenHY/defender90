package com.tarena.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.CostMapper;
import com.tarena.entity.Cost;

public class TestCostMapper {

	@Test
	public void testFindAll() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		CostMapper mapper = 
			ctx.getBean(CostMapper.class);
		List<Cost> list = mapper.findAll();
		for(Cost c : list) {
			System.out.println(
				c.getCost_id() + " " +
				c.getName() + " " +
				c.getDescr()
			);
		}
	}
	
}
