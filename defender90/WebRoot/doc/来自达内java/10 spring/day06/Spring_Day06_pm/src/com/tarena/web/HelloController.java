package com.tarena.web;

import java.io.Serializable;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/demo")
public class HelloController
	implements Serializable{
	
	@RequestMapping("/hello.form")
	public String execute(
			HttpServletRequest req){
		System.out.println("Hello World!");
		req.setAttribute("msg", "Hello");
		return "hello";//hello.jsp
	}
	
	@RequestMapping("/hi.form")
	public String hi(HttpServletRequest req){
		req.setAttribute("msg", "Hi");
		return "hello";
	}
	
	@RequestMapping("/whoru.form")
	public ModelAndView whoru(
			HttpServletRequest req){	
		ServletContext context = req.getSession()
			.getServletContext();
		//拼接一个重定向的绝对路径
		//可以得到当前应用程序的路径 /spring6
		String path = context.getContextPath();
		path+="/login/login.form";
		// /spring6/login/login.form
		RedirectView view = 
			new RedirectView(path);//会发生重定向
		return new ModelAndView(view);
	}
	
	// 转发是一次请求
	// 重定向是两次请求
	// 使用转发情况：
	//  一个请求 先执行了控制器得到了业务结果
	//    业务结果被保存到 请求中 用于在界面显示
	//    这些数据，要使用：转发！
	//    注意: 一个控制器处理，转发到一个页面结束
	//        不要再次转发！
	// 重定向：一个处理过程（C->V）如果需要关联
	//    到另外的一个请求过程（C->V）必须使用
	//    重定向解决。
	//
	
	@RequestMapping("/whoami.form")
	public String whoami(HttpServletRequest req){
		return "redirect:../login/login.form";
	}
	
	@RequestMapping("/go.form")
	public String hi(ModelMap map){
		map.put("msg", "HI");
		System.out.println("Call hi()"); 
		return "success";
	}
}








