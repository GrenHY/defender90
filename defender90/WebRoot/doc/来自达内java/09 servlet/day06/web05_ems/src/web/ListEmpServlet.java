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
		//�������ݿ⣬�������Ա������Ϣ
		try {
				EmployeeDAO dao = new EmployeeDAO();
				List<Employee> employees = 
					dao.findAll();
				//ת����listEmp3.jsp����ʾ
				request.setAttribute("employees", employees);
				RequestDispatcher rd = 
					request.getRequestDispatcher("listEmp.jsp");
				rd.forward(request, response);
				} catch (Exception e) {
			e.printStackTrace();
			//�󶩴�����ʾ
			request.setAttribute(
					"error_msg", "ϵͳ��æ���Ժ�����");
			//ת����������ʾҳ��
			request.getRequestDispatcher("error.jsp")
			.forward(request, response);
		}
	}
}
