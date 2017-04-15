package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//添加cookie
		Cookie c = new Cookie("username","Tom");
		c.setMaxAge(45);
		response.addCookie(c);
		Cookie c2 = new Cookie("city",
				URLEncoder.encode("北京","utf-8"));
		response.addCookie(c2);
		out.println("cookie添加成功");
		out.close();
	}

}
