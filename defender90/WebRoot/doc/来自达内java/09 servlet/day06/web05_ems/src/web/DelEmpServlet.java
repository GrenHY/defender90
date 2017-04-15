package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;

public class DelEmpServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 将员工信息插入到数据库
		try {
			EmployeeDAO dao = new EmployeeDAO();
			dao.delete(id);
			response.sendRedirect("list");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("稍后重试");
		}
	}
}
