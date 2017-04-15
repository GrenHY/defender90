package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class ModifyEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response) 
	throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");
		//服务器端要检查客户端传递过来的参数
		//值的合法性。
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//修改数据库中员工的信息
		EmployeeDAO dao = new EmployeeDAO();
		Employee e = new Employee();
		e.setName(name);
		e.setSalary(Double.parseDouble(salary));
		e.setAge(Integer.parseInt(age));
		e.setId(id);
		try {
			dao.modify(e);
			response.sendRedirect("list");
		} catch (Exception e1) {
			e1.printStackTrace();
			out.println("稍后重试");
		}
	}
}
