package com.tarena.web;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/** Spring必须实现Controller接口 */
public class HelloController 
	implements Controller, Serializable{
	/** 控制器方法 */
	public ModelAndView handleRequest(
			HttpServletRequest req,
			HttpServletResponse res) 
		throws Exception {
		//在Tomcat控制台上输出消息：证明控制器被调用了
		System.out.println("Hello Controller");
		//给用户回馈的消息
		req.setAttribute("msg", "Hello");
		//返回结果转发到 hello.jsp 显示给用户
		return new ModelAndView("hello");
	}
}





