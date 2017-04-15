package com.tarena.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.tarena.dao.AdminDao;
import com.tarena.dao.AdminDaoImpl;
import com.tarena.entity.Admin;

/**
 *	登录校验
 */
public class CheckLoginAction {

	//input
	private String adminCode;
	private String password;
	private String userCode;
	//output
	private String errorMsg;
	
	public String execute() {
		HttpSession session = 
			ServletActionContext.getRequest().getSession();		
		//校验验证码
		String imageCode = (String) 
			session.getAttribute("imageCode");
		if(userCode == null
				|| !userCode.equalsIgnoreCase(imageCode)) {
			errorMsg = "验证码有误.";
			return "fail";
		}
		//查询管理员
		AdminDao dao = new AdminDaoImpl();
		Admin admin = 
			dao.findByCode(adminCode);
		//校验管理员
		if(admin==null) {
			//账号不存在
			errorMsg = "账号不存在.";
			return "fail";
		} else if (!admin.getPassword().equals(password)) {
			//密码错误
			errorMsg = "密码错误.";
			return "fail";
		} else {
			//登录成功，将登录信息存入session
			session.setAttribute("admin", admin);
			return "success";
		}
	}
	
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
