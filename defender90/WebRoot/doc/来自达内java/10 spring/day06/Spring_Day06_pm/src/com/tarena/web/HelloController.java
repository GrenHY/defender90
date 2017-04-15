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
		//ƴ��һ���ض���ľ���·��
		//���Եõ���ǰӦ�ó����·�� /spring6
		String path = context.getContextPath();
		path+="/login/login.form";
		// /spring6/login/login.form
		RedirectView view = 
			new RedirectView(path);//�ᷢ���ض���
		return new ModelAndView(view);
	}
	
	// ת����һ������
	// �ض�������������
	// ʹ��ת�������
	//  һ������ ��ִ���˿������õ���ҵ����
	//    ҵ���������浽 ������ �����ڽ�����ʾ
	//    ��Щ���ݣ�Ҫʹ�ã�ת����
	//    ע��: һ������������ת����һ��ҳ�����
	//        ��Ҫ�ٴ�ת����
	// �ض���һ��������̣�C->V�������Ҫ����
	//    �������һ��������̣�C->V������ʹ��
	//    �ض�������
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








