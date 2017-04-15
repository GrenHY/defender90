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

public class LoadEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response) 
	throws ServletException,IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(
				request.getParameter("id"));
		//�������ݿ⣬���ָ��idֵ��Ա������Ϣ
		try {
			EmployeeDAO dao = new EmployeeDAO();
			Employee e = dao.findById(id);
			//ת����updateEmp.jsp����ʾ
			request.setAttribute("e", e);
			request.getRequestDispatcher("updateEmp.jsp")
			.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			out.println("�Ժ�����");
		}
	}
}
