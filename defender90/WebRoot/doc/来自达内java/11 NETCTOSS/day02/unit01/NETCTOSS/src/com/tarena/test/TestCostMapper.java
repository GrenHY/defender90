package com.tarena.test;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.CostMapper;
import com.tarena.entity.Cost;

public class TestCostMapper {

	@Test
	public void testUpdate() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		CostMapper mapper = 
			ctx.getBean(CostMapper.class);
		Cost cost = mapper.findById(103);
		cost.setName("xxx");
		cost.setDescr("xxx");
		cost.setBase_duration(50);
		mapper.update(cost);
	}
	
	@Test
	public void testFindById() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		CostMapper mapper = 
			ctx.getBean(CostMapper.class);
		Cost cost = mapper.findById(1);
		System.out.println(
			cost.getCost_id() + " " +
			cost.getName() + " " +
			cost.getDescr()
		);
	}
	
	@Test
	public void testSave() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		CostMapper mapper = 
			ctx.getBean(CostMapper.class);	
		//测试代码中没有页面，因此模拟一个数据
		Cost c = new Cost();
		c.setName("1408套餐");
		c.setBase_duration(80);
		c.setBase_cost(8.0);
		c.setUnit_cost(0.8);
		c.setStatus("0");
		
		mapper.save(c);
	}
	
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
