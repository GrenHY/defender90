package com.tarena.action;

import com.tarena.entity.User;


public class HelloAction {
	
	//��������
	private Integer id = 9;
	private String realName = "Tarena";
	//ʵ�����
	private User user;

	public String sayHello() {
		//��ʼ��ʵ�����
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
