package com.tarena.web;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller, Serializable {
	public ModelAndView handleRequest(
			HttpServletRequest req,
			HttpServletResponse res)
		throws Exception {
		System.out.println("Hello World!");
		req.setAttribute("msg", "Hello");
		return new ModelAndView("hello");
	}
}



