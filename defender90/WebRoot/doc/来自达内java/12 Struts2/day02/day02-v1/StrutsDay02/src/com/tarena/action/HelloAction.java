package com.tarena.action;

import com.tarena.entity.User;


public class HelloAction {
	
	//基本属性
	private Integer id = 9;
	private String realName = "Tarena";
	//实体对象
	private User user;

	public String sayHello() {
		//初始化实体对象
		user = new User();
		user.setUserName("zhangsan");
		user.setPassword("123");
		
		return "ok";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
