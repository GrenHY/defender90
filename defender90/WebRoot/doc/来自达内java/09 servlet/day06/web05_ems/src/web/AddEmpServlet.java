package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class AddEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response) 
	throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");
		//服务器端要检查客户端传递过来的参数
		//值的合法性。
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//将员工信息插入到数据库
		try {
			EmployeeDAO dao = new EmployeeDAO();
			Employee e = new Employee();
			e.setName(name);
			e.setSalary(Double.parseDouble(salary));
			e.setAge(Integer.parseInt(age));
			dao.save(e);
			response.sendRedirect("list");
		} catch (Exception e) {
			//step1,记日志
			e.printStackTrace();
			//step2,看异常是否能够恢复，如果不
			//能够恢复(比如，数据库服务暂停,网络
			//中断,即发生了系统异常),则提示用户
			//稍后重试。
			out.println("稍后重试");
		}
		out.close();
	}
}
