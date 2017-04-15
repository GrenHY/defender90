package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilterA implements Filter{
	private FilterConfig config;
	public CommentFilterA(){
		System.out.println("FilterA's constructor...");
	}
	/**
	 * ������ɾ��������ʵ��֮ǰ�������
	 * �÷�����
	 */
	public void destroy() {
		System.out.println("FilterA's destroy...");
	}

	/**
	 * ���������doFilter��������������
	 * �����ڵ��ø÷���ʱ���Ὣ���ȴ����õ�
	 * request,response��Ϊ�������ݽ�����
	 * FilterChain(��������):
	 * 	���������FilterChain��doFilter����,����
	 * ����������ã����û�е��ø÷�����
	 * ������ֹͣ�����ã����ش�������
	 */
	public void doFilter(ServletRequest arg0, 
			ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("FilterA's doFilter begin...");
		HttpServletRequest request = 
			(HttpServletRequest)arg0;
		HttpServletResponse response =
			(HttpServletResponse)arg1;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String content = request.getParameter("content");
		//��ȡ��ʼ������
		String illegalStr = 
			config.getInitParameter("illegalStr");
		if(content.indexOf(illegalStr) != -1){
			out.println("�Ƿ�����");
		}else{
			//��������������
			arg2.doFilter(arg0, arg1);
		}
		System.out.println("FilterA's doFilter end.");
	}
	
	/**
	 * ��������֮�󣬻���������������ʵ����
	 * ����������������ù�������init������
	 * ���������ȴ�����FilterConfig���󣬲���
	 * �ö�����Ϊ�������ݽ���������ʹ�ø�
	 * ���������ʹ������ĳ�ʼ��������
	 */
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("FilterA's init...");
		//���������ݹ�����FilterConfig����
		//��������
		config = arg0;
	}

}
