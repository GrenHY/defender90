package com.tarena.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.tarena.dao.AdminDao;
import com.tarena.dao.AdminDaoImpl;
import com.tarena.entity.Admin;

/**
 *	��¼У��
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
		//У����֤��
		String imageCode = (String) 
			session.getAttribute("imageCode");
		if(userCode == null
				|| !userCode.equalsIgnoreCase(imageCode)) {
			errorMsg = "��֤������.";
			return "fail";
		}
		//��ѯ����Ա
		AdminDao dao = new AdminDaoImpl();
		Admin admin = 
			dao.findByCode(adminCode);
		//У�����Ա
		if(admin==null) {
			//�˺Ų�����
			errorMsg = "�˺Ų�����.";
			return "fail";
		} else if (!admin.getPassword().equals(password)) {
			//�������
			errorMsg = "�������.";
			return "fail";
		} else {
			//��¼�ɹ�������¼��Ϣ����session
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
