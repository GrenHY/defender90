package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response) 
	throws ServletException,IOException{
		//依据请求参数名获得参数值
		String uname = request.getParameter("uname");
		//设置content-type消息头
		response.setContentType("text/html");
		//获得一个输出流
		PrintWriter out = response.getWriter();
		//输出处理结果
		out.println("<h1 style='color:red;'>Hello " 
				+ uname + "</h1>");
		out.close();
	}
}
