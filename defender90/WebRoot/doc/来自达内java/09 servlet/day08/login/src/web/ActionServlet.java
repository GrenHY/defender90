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
			//�ȱȽ���֤���Ƿ���ȷ
			String number1 = 
				request.getParameter("number");
			HttpSession session = 
				request.getSession();
			String number2 = 
				(String)session.getAttribute("number");
			if(!number1.equalsIgnoreCase(number2)){
				//��֤�벻��ȷ�����ñȽ��û��������� 
				//�ˣ���ת����¼ҳ�棬����ʾ�û�
				request.setAttribute("number_error",
						"��֤�����");
				request.getRequestDispatcher("login.jsp")
				.forward(request, response);
				return;
			}
			String username = 
				request.getParameter("username");
			String pwd = 
				request.getParameter("pwd");
			//һ��Ҫ�������ĺϷ���,�˴���ʱ��ȥ
			UserDAO dao = new UserDAO();
			try {
				User user = dao.findByUsername(username);
				if(user != null && user.getPwd().equals(pwd) ){
					//��¼�ɹ�����һЩ���ݵ�session������
					session.setAttribute("user", user);
					//��ת��������ҳ��
					response.sendRedirect("main.jsp");
					System.out.println("hello hello");
				}else{
					//��¼ʧ�ܣ���ʾ�û�
					request.setAttribute("login_failed", 
							"�û������������");
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
