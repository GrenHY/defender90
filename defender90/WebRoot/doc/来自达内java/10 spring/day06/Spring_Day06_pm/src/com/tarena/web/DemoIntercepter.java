package com.tarena.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoIntercepter 
	implements HandlerInterceptor {
	public boolean preHandle(
			HttpServletRequest req, 
			HttpServletResponse res,
			Object handle) throws Exception {
		System.out.println("preHandle()");
		return true;//?
	}
	public void postHandle(
			HttpServletRequest req,
			HttpServletResponse res,
			Object handle, 
			ModelAndView mv) throws Exception {
		System.out.println("postHandle()");
	}

	public void afterCompletion(
			HttpServletRequest req,
			HttpServletResponse res, 
			Object handle, 
			Exception e) throws Exception {
		System.out.println("afterCompletion()");
	}

}
