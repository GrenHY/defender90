package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.entity.User;
import com.tarena.entity.UserService;

public class TestCase {
	//@Test
	public void testDemo(){
		String cfg = "applicationContext.xml";
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(cfg);
		DemoBean b1 = ctx.getBean(
				"demo", DemoBean.class);
		DemoBean b2 = ctx.getBean(
				"demo", DemoBean.class);
		System.out.println(b1==b2);//false
		System.out.println(b1); 
	}
	@Test
	public void testUserService()
		throws Exception{
		String cfg = "applicationContext.xml";
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(cfg);
		UserService service = ctx.getBean(
				"userService", UserService.class);
		User user = service.login("tom", "123");
		System.out.println(user);
	}
}





