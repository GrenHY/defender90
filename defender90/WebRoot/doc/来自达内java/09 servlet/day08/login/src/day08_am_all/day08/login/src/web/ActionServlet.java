package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

public class ActionServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String action = 
			uri.substring(uri.lastIndexOf("/"),
					uri.lastIndexOf("."));
		if(action.equals("/login")){
			String username = 
				request.getParameter("username");
			String pwd = 
				request.getParameter("pwd");
			//一定要检查参数的合法性,此处暂时略去
			UserDAO dao = new UserDAO();
			try {
				User user = dao.findByUsername(username);
				if(user != null && user.getPwd().equals(pwd) ){
					//登录成功，绑订一些数据到session对象上
					HttpSession session = 
						request.getSession();
					session.setAttribute("user", user);
					//跳转到主功能页面
					response.sendRedirect("main.jsp");
					System.out.println("hello hello");
				}else{
					//登录失败，提示用户
					request.setAttribute("login_failed", 
							"用户名或密码错误");
					request.getRequestDispatcher("login.jsp")
					.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		
	}

}
