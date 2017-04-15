package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Find_AddCookieServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = 
			request.getCookies();
		if(cookies != null){
			boolean flag = false;
			for(int i = 0 ;i < cookies.length;i ++){
				Cookie c = cookies[i];
				if(c.getName().equals("uid")){
					out.println(c.getValue());
					flag = true;
				}
			}
			if(!flag){
				//没有找到名称为"uid"的cookie,需要添加
				Cookie c = new Cookie("uid","abc");
				response.addCookie(c);
			}
		}else{
			//没有找到任何cookie,需要添加
			Cookie c = new Cookie("uid","abc");
			response.addCookie(c);
		}
		out.close();
	}

}
