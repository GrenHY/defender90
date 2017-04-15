package com.tarena.action;

import com.tarena.entity.User;

public class HelloAction {
	
	//基本属性
	private String realName;
	private int age;
	
	//域模型
	private User user;

	public HelloAction() {
		System.out.println("实例化HelloAction");
	}
	
	/**
	 * Action业务方法的要求：
	 * 1、公有的
	 * 2、返回String
	 * 3、没有参数
	 */
	public String sayHello() {
		//输出基本属性
		System.out.println(
			"姓名:" + realName);
		System.out.println(
			"年龄:" + age);
		//输出域模型
		System.out.println(
			"账号:" + user.getUserName());
		System.out.println(
			"密码:" + user.getPassword());
		
		/*
		 * 返回的是特征字符串，用来匹配页面。
		 * filter在自动调用完该业务方法后，
		 * 会利用其返回的字符串，在struts.xml
		 * 中找到与其对应的页面。
		 * */
		return "ok";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		System.out.println("注入user");
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
		System.out.println("注入realName");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
