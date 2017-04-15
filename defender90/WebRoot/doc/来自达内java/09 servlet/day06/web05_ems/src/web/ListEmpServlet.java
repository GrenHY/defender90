package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class ListEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response) 
	throws ServletException,IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//访问数据库，获得所有员工的信息
		try {
				EmployeeDAO dao = new EmployeeDAO();
				List<Employee> employees = 
					dao.findAll();
				//转发给listEmp3.jsp来显示
				request.setAttribute("employees", employees);
				RequestDispatcher rd = 
					request.getRequestDispatcher("listEmp.jsp");
				rd.forward(request, response);
				} catch (Exception e) {
			e.printStackTrace();
			//绑订错误提示
			request.setAttribute(
					"error_msg", "系统繁忙，稍后重试");
			//转发给错误提示页面
			request.getRequestDispatcher("error.jsp")
			.forward(request, response);
		}
	}
}
