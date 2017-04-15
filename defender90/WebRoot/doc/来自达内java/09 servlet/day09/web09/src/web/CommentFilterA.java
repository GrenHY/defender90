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
	 * 容器在删除过滤器实例之前，会调用
	 * 该方法。
	 */
	public void destroy() {
		System.out.println("FilterA's destroy...");
	}

	/**
	 * 容器会调用doFilter方法来处理请求。
	 * 容器在调用该方法时，会将事先创建好的
	 * request,response作为参数传递进来。
	 * FilterChain(过滤器链):
	 * 	如果调用了FilterChain的doFilter方法,容器
	 * 会继续向后调用，如果没有调用该方法，
	 * 则容器停止向后调用，返回处理结果。
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
		//读取初始化参数
		String illegalStr = 
			config.getInitParameter("illegalStr");
		if(content.indexOf(illegalStr) != -1){
			out.println("非法评论");
		}else{
			//容器继续向后调用
			arg2.doFilter(arg0, arg1);
		}
		System.out.println("FilterA's doFilter end.");
	}
	
	/**
	 * 容器启动之后，会立即创建过滤器实例。
	 * 接下来，容器会调用过滤器的init方法。
	 * 容器会事先创建好FilterConfig对象，并将
	 * 该对象作为参数传递进来，可以使用该
	 * 对象来访问过滤器的初始化参数。
	 */
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("FilterA's init...");
		//将容器传递过来的FilterConfig对象
		//保存下来
		config = arg0;
	}

}
