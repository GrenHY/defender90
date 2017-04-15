package com.tarena.web;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}






