package com.tarena.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sun.rmi.transport.proxy.HttpReceiveSocket;

import com.tarena.entity.User;
import com.tarena.service.EmptyParamException;
import com.tarena.service.NameOrPwdException;
import com.tarena.service.UserService;
@Controller
@RequestMapping("/login")
public class LoginController 
	implements Serializable{
	
	@Resource
	private UserService userService;
	
	//�������: /login/login.form ֱ��ת��
	// �� login.jsp, ��ʾ login.jsp
	@RequestMapping("/login.form")
	public String loginFrom(){
		return "login";
	}
	// /login/login-action1.form
	//���¿������������ڴ��� ��½���ύ������
	@RequestMapping("/login-action1.form")
	public String loginAction1(
			HttpServletRequest req,
			HttpServletResponse res){
		// ��½�������̣������˿�����������
		// �������ǽ����ҵ���֮���������
		//���ձ��ύ�����ݣ�name pwd��
		// ��������ݣ���������� ת����login
		//���� ҵ������ userService ��login����
		//�����ؽ��
		// 1) ���� User ���󣬵�½�ɹ���ת����
		//    success ҳ�棬��ʾ��ӭ XXX ����
		// 2) �쳣�����ת���� login ҳ��
		//    ��ʾ������Ϣ
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		//���������
		boolean pass = true;
		if(name==null || name.trim().equals("")){
			req.setAttribute("nameMsg1", "���ܿ�");
			pass=false;
		}
		if(pwd==null || pwd.trim().equals("")){
			req.setAttribute("pwdMsg1", "���ܿ�");
			pass=false;
		}
		if(! pass){
			return "login";
		}
		//����ҵ��㷽��
		try{
			User user=userService.login(name, pwd);
			//����½�û�״̬���ֵ�session!
			req.getSession().setAttribute(
					"loginUser", user);
			req.setAttribute("msg", 
					user.getName()+"�����ڻ����ˣ�");
			return "success";
		}catch(NameOrPwdException e){
			e.printStackTrace();
			req.setAttribute("msg1", e.getMessage());
			return "login";
		}catch(EmptyParamException e){
			e.printStackTrace();
			req.setAttribute("msg1", e.getMessage());
			return "login";
		}
	}
	
	@RequestMapping("/login-action2.form")
	public String loginAction2(
			String name, 
			@RequestParam("pwd") String password,
			HttpServletRequest req){
		//���������
		boolean pass = true;
		if(name==null || name.trim().equals("")){
			req.setAttribute("nameMsg2", "���ܿ�");
			pass=false;
		}
		if(password==null || password.trim().equals("")){
			req.setAttribute("pwdMsg2", "���ܿ�");
			pass=false;
		}
		if(! pass){
			return "login";
		}
		//����ҵ��㷽��
		try{
			User user=userService.login(name, password);
			//����½�û�״̬���ֵ�session!
			req.getSession().setAttribute(
					"loginUser", user);
			req.setAttribute("msg", 
					user.getName()+"�����ڻ����ˣ�");
			return "success";
		}catch(NameOrPwdException e){
			e.printStackTrace();
			req.setAttribute("msg2", e.getMessage());
			return "login";
		}catch(EmptyParamException e){
			e.printStackTrace();
			req.setAttribute("msg2", e.getMessage());
			return "login";
		}
	}
	
	@RequestMapping("/login-action3.form")
	public String loginAction3(
			LoginFormVO vo,
			HttpServletRequest req){
		String ip = req.getRemoteAddr();
		
		String name=vo.getName();
		String pwd =vo.getPwd();
		//���������
		boolean pass = true;
		if(name==null || name.trim().equals("")){
			req.setAttribute("nameMsg3", "���ܿ�");
			pass=false;
		}
		if(pwd==null || pwd.trim().equals("")){
			req.setAttribute("pwdMsg3", "���ܿ�");
			pass=false;
		}
		if(! pass){
			return "login";
		}
		//����ҵ��㷽��
		try{
			User user=userService.login(name, pwd);
			//����½�û�״̬���ֵ�session!
			req.getSession().setAttribute(
					"loginUser", user);
			req.setAttribute("msg", 
					user.getName()+"�����ڻ����ˣ�");
			return "success";
		}catch(NameOrPwdException e){
			e.printStackTrace();
			req.setAttribute("msg3", e.getMessage());
			return "login";
		}catch(EmptyParamException e){
			e.printStackTrace();
			req.setAttribute("msg3", e.getMessage());
			return "login";
		}
	}
	
	/** ����ModelAndView ����洫ֵ */
	@RequestMapping("/hello.form")
	public ModelAndView hello(){
		//����Ҫ���ݵ�ֵ�����Map����
		Map<String, Object> data = 
			new HashMap<String, Object>();
		data.put("msg", "Hello");
		data.put("userName", "Andy");
		//����Spring ��messageҳ������ʾ data����
		//����key���ǰ�ֵ����������${userName}
		ModelAndView mv = 
			new ModelAndView("message", data);
		return mv;
	}
	
	@RequestMapping("/login-action4.form")
	public ModelAndView loginAction4(
			String name,
			String pwd,
			HttpServletRequest req){
		Map<String, Object> map = 
			new HashMap<String, Object>();
		boolean pass = true;
		if(name==null||name.trim().equals("")){
			map.put("nameMsg4", "���ܿ�");
			pass=false;
		}
		if(pwd==null||pwd.trim().equals("")){
			map.put("pwdMsg4", "���ܿ�");
			pass=false;
		}
		if(! pass){
			return new ModelAndView("login", map);
		}
		try {
			User user = userService.login(name, pwd);
			req.getSession().setAttribute(
					"loginUser", user);
			map.put("msg", "��ӭ"+user.getName());
			return new ModelAndView("success", map);
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			map.put("msg4", e.getMessage());
			return new ModelAndView("login", map);
		} catch (EmptyParamException e) {
			e.printStackTrace();
			map.put("msg4", e.getMessage());
			return new ModelAndView("login", map);
		}
	}
	/** Spring �ṩ���ռ�����ֵ��Map ����*/
	@RequestMapping("/login-action5.form")
	public String loginAction5(
			String name,
			String pwd,
			ModelMap map,
			HttpServletRequest req){
		//���ô���Map�����ˣ�ʡ��
		boolean pass = true;
		map.put("name", name);
		if(name==null||name.trim().equals("")){
			map.addAttribute("nameMsg5", "���ܿ�");
			pass=false;
		}
		if(pwd==null||pwd.trim().equals("")){
			map.put("pwdMsg5", "���ܿ�");
			pass=false;
		}
		if(! pass){
			return "login";
		}
		try {
			User user = userService.login(name, pwd);
			req.getSession().setAttribute(
					"loginUser", user);
			map.put("msg", "��ӭ"+user.getName());
			return "success";
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			map.put("msg5", e.getMessage());
			return "login";
		} catch (EmptyParamException e) {
			e.printStackTrace();
			map.put("msg5", e.getMessage());
			return "login";
		}
	}
	@RequestMapping("/login-action6.form")
	public String loginAction6(
			@ModelAttribute("name6") String name6,
			String pwd,
			ModelMap map,
			HttpServletRequest req){
		//map.put("name6", name6);
		boolean pass = true;
		if(name6==null||name6.trim().equals("")){
			map.addAttribute("nameMsg6", "���ܿ�");
			pass=false;
		}
		if(pwd==null||pwd.trim().equals("")){
			map.put("pwdMsg6", "���ܿ�");
			pass=false;
		}
		if(! pass){
			return "login";
		}
		try {
			User user = userService.login(name6, pwd);
			req.getSession().setAttribute(
					"loginUser", user);
			map.put("msg", "��ӭ"+user.getName());
			return "success";
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			map.put("msg6", e.getMessage());
			return "login";
		} catch (EmptyParamException e) {
			e.printStackTrace();
			map.put("msg6", e.getMessage());
			return "login";
		}
	}
	//�κ�����/login/* ������������ҳ�洫��ֵ 
	//"adv"ֵValue�� getAdv()�����Ľ����Bean���ԣ�
	@ModelAttribute("adv")
	public String getAdv(){
		return "����������ɢ��!";
	}
}























