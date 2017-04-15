package com.tarena.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	// 当前控制任何一个控制器方法出现异常时候
	// 会自动执行这个异常处理方法
	// Exception e 是出现异常方法抛出的异常
	@ExceptionHandler
	public String execute(
			HttpServletRequest req,
			Exception e) throws Exception{
		if(e instanceof NullPointerException){
			req.setAttribute("error", "空指针");
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







