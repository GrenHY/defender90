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
	
	//如果请求: /login/login.form 直接转发
	// 到 login.jsp, 显示 login.jsp
	@RequestMapping("/login.form")
	public String loginFrom(){
		return "login";
	}
	// /login/login-action1.form
	//如下控制器方法用于处理 登陆表单提交的请求
	@RequestMapping("/login-action1.form")
	public String loginAction1(
			HttpServletRequest req,
			HttpServletResponse res){
		// 登陆控制流程：体现了控制器的作用
		// 控制器是界面和业务层之间的适配器
		//接收表单提交的数据（name pwd）
		// 检验表单数据，如果有问题 转发到login
		//调用 业务层对象 userService 的login方法
		//处理返回结果
		// 1) 返回 User 对象，登陆成功，转发到
		//    success 页面，显示欢迎 XXX 回来
		// 2) 异常结果：转发到 login 页面
		//    显示错误消息
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		//检验表单数据
		boolean pass = true;
		if(name==null || name.trim().equals("")){
			req.setAttribute("nameMsg1", "不能空");
			pass=false;
		}
		if(pwd==null || pwd.trim().equals("")){
			req.setAttribute("pwdMsg1", "不能空");
			pass=false;
		}
		if(! pass){
			return "login";
		}
		//调用业务层方法
		try{
			User user=userService.login(name, pwd);
			//将登陆用户状态保持到session!
			req.getSession().setAttribute(
					"loginUser", user);
			req.setAttribute("msg", 
					user.getName()+"你终于回来了！");
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
		//检验表单数据
		boolean pass = true;
		if(name==null || name.trim().equals("")){
			req.setAttribute("nameMsg2", "不能空");
			pass=false;
		}
		if(password==null || password.trim().equals("")){
			req.setAttribute("pwdMsg2", "不能空");
			pass=false;
		}
		if(! pass){
			return "login";
		}
		//调用业务层方法
		try{
			User user=userService.login(name, password);
			//将登陆用户状态保持到session!
			req.getSession().setAttribute(
					"loginUser", user);
			req.setAttribute("msg", 
					user.getName()+"你终于回来了！");
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
		//检验表单数据
		boolean pass = true;
		if(name==null || name.trim().equals("")){
			req.setAttribute("nameMsg3", "不能空");
			pass=false;
		}
		if(pwd==null || pwd.trim().equals("")){
			req.setAttribute("pwdMsg3", "不能空");
			pass=false;
		}
		if(! pass){
			return "login";
		}
		//调用业务层方法
		try{
			User user=userService.login(name, pwd);
			//将登陆用户状态保持到session!
			req.getSession().setAttribute(
					"loginUser", user);
			req.setAttribute("msg", 
					user.getName()+"你终于回来了！");
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
	
	/** 利用ModelAndView 向界面传值 */
	@RequestMapping("/hello.form")
	public ModelAndView hello(){
		//将需要传递的值打包到Map集合
		Map<String, Object> data = 
			new HashMap<String, Object>();
		data.put("msg", "Hello");
		data.put("userName", "Andy");
		//高数Spring 在message页面上显示 data数据
		//其中key就是绑定值的属性名：${userName}
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
			map.put("nameMsg4", "不能空");
			pass=false;
		}
		if(pwd==null||pwd.trim().equals("")){
			map.put("pwdMsg4", "不能空");
			pass=false;
		}
		if(! pass){
			return new ModelAndView("login", map);
		}
		try {
			User user = userService.login(name, pwd);
			req.getSession().setAttribute(
					"loginUser", user);
			map.put("msg", "欢迎"+user.getName());
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
	/** Spring 提供了收集界面值的Map 对象*/
	@RequestMapping("/login-action5.form")
	public String loginAction5(
			String name,
			String pwd,
			ModelMap map,
			HttpServletRequest req){
		//不用创建Map对象了，省了
		boolean pass = true;
		map.put("name", name);
		if(name==null||name.trim().equals("")){
			map.addAttribute("nameMsg5", "不能空");
			pass=false;
		}
		if(pwd==null||pwd.trim().equals("")){
			map.put("pwdMsg5", "不能空");
			pass=false;
		}
		if(! pass){
			return "login";
		}
		try {
			User user = userService.login(name, pwd);
			req.getSession().setAttribute(
					"loginUser", user);
			map.put("msg", "欢迎"+user.getName());
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
			map.addAttribute("nameMsg6", "不能空");
			pass=false;
		}
		if(pwd==null||pwd.trim().equals("")){
			map.put("pwdMsg6", "不能空");
			pass=false;
		}
		if(! pass){
			return "login";
		}
		try {
			User user = userService.login(name6, pwd);
			req.getSession().setAttribute(
					"loginUser", user);
			map.put("msg", "欢迎"+user.getName());
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
	//任何请求/login/* 控制器都会向页面传递值 
	//"adv"值Value是 getAdv()方法的结果（Bean属性）
	@ModelAttribute("adv")
	public String getAdv(){
		return "今天雾霾消散了!";
	}
}























