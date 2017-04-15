package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.HandlerMapping;

import com.tarena.web.HelloController;

public class TestCase {
	@Test
	public void testHandlerMapping(){
		String cfg = "spring-mvc.xml";
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(cfg);
		HandlerMapping bean = ctx.getBean(
			"handlerMapping", HandlerMapping.class);
		System.out.println(bean); 
		HelloController h = ctx.getBean(
				"helloController", HelloController.class);
		System.out.println(h);
		
	}
}







