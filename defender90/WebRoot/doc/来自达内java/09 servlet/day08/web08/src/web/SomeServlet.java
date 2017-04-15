package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SomeServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = 
			request.getSession();
		//session.setMaxInactiveInterval(35);
		//获得sessionId
		String sessionId = session.getId();
		System.out.println("sessionId:" + sessionId);
		Integer count = 
			(Integer)session.getAttribute("count");
		if(count == null){
			//是第1次访问
			count = 1;
		}else{
			//不是第1次访问
			count ++;
		}
		session.setAttribute("count", count);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("你是第:" + count + "次 访问");
//		session.invalidate();
	}

}
