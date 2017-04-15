package com.tarena.web;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/** Spring����ʵ��Controller�ӿ� */
public class HelloController 
	implements Controller, Serializable{
	/** ���������� */
	public ModelAndView handleRequest(
			HttpServletRequest req,
			HttpServletResponse res) 
		throws Exception {
		//��Tomcat����̨�������Ϣ��֤����������������
		System.out.println("Hello Controller");
		//���û���������Ϣ
		req.setAttribute("msg", "Hello");
		//���ؽ��ת���� hello.jsp ��ʾ���û�
		return new ModelAndView("hello");
	}
}





