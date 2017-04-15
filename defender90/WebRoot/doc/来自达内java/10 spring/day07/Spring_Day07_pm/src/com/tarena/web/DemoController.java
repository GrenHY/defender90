package com.tarena.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	// ��ǰ�����κ�һ�����������������쳣ʱ��
	// ���Զ�ִ������쳣������
	// Exception e �ǳ����쳣�����׳����쳣
	@ExceptionHandler
	public String execute(
			HttpServletRequest req,
			Exception e) throws Exception{
		if(e instanceof NullPointerException){
			req.setAttribute("error", "��ָ��");
			return "message";
		}
		throw e;
	}
	
	@RequestMapping("/demo.form")
	public String demo(){
		String s ="abc";
		char c = s.charAt(10);
		return "success";
	}
	
	@RequestMapping("/hi.form")
	public String hi(){
		String s = null;
		s.charAt(0);
		return "success";
	}
}







