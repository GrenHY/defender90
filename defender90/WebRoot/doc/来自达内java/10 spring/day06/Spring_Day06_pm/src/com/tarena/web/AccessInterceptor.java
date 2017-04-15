package com.tarena.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tarena.entity.User;

public class AccessInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	public boolean preHandle(
			HttpServletRequest req, 
			HttpServletResponse res,
			Object handle) throws Exception {
		User user = (User)req.getSession()
			.getAttribute("loginUser");
		if(user==null){//Ã»ÓÐµÇÂ¼
			String path = req.getContextPath();
			path+="/login/login.form";
			res.sendRedirect(path);
			return false;
		}
		return true;
	}

}





