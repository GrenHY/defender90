package com.tarena.action;

import com.tarena.entity.User;

public class HelloAction {
	
	//��������
	private String realName;
	private int age;
	
	//��ģ��
	private User user;

	public HelloAction() {
		System.out.println("ʵ����HelloAction");
	}
	
	/**
	 * Actionҵ�񷽷���Ҫ��
	 * 1�����е�
	 * 2������String
	 * 3��û�в���
	 */
	public String sayHello() {
		//�����������
		System.out.println(
			"����:" + realName);
		System.out.println(
			"����:" + age);
		//�����ģ��
		System.out.println(
			"�˺�:" + user.getUserName());
		System.out.println(
			"����:" + user.getPassword());
		
		/*
		 * ���ص��������ַ���������ƥ��ҳ�档
		 * filter���Զ��������ҵ�񷽷���
		 * �������䷵�ص��ַ�������struts.xml
		 * ���ҵ������Ӧ��ҳ�档
		 * */
		return "ok";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		System.out.println("ע��user");
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
		System.out.println("ע��realName");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
