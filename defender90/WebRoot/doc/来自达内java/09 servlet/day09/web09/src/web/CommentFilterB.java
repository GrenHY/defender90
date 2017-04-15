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

public class CommentFilterB implements Filter{
	public CommentFilterB(){
		System.out.println("FilterB's constructor...");
	}
	public void destroy() {
		System.out.println("FilterB's destroy...");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("FilterB's doFilter begin...");
		HttpServletRequest request = 
			(HttpServletRequest)arg0;
		HttpServletResponse response =
			(HttpServletResponse)arg1;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String content = request.getParameter("content");
		if(content.length() > 20){
			out.println("评论字数过多");
		}else{
			//容器继续向后调用
			arg2.doFilter(arg0, arg1);
		}
		System.out.println("FilterB's doFilter end.");
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("FilterB's init...");
	}

}
