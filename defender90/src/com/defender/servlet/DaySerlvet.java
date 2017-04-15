package com.defender.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.defender.common.DataUtil;
import com.defender.common.FileTools;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DaySerlvet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DaySerlvet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = FileTools.PATH_JSON+DataUtil.obtainDayTaskName("event", "")+".json";
		JSONArray j = FileTools.getAsJson(path);
		
		String id = request.getParameter("id");
	
		if ("1".equals(id)) {
			
		} else if ("2".equals(id)) {
			//删除
			String title = request.getParameter("title");
			String start =request.getParameter("start");
			String end =request.getParameter("end");
			
			for (int i =0;i<j.size();i++) {
				JSONObject jsonObject = j.getJSONObject(i);
				if (title.equals(jsonObject.optString("title")) 
						&& start.equals(jsonObject.optString("start"))) {
					j.remove(i);
					break;
				}
			}
			FileTools.saveAsJson(j, path);
			System.out.println("----->");
			
			
		}else {
			String title = request.getParameter("title");
			String contents =request.getParameter("contents");
			String start =request.getParameter("start");
			String end =request.getParameter("end");
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
//			
			JSONObject json = new JSONObject();
			json.put("title",title);
			json.put("contents",contents);
			json.put("start",start);
			json.put("end",end);
//			
			j.add(json);
			
			FileTools.saveAsJson(j, path);
		}
		
		/**
		 * 出现排序错乱情况
		 */
		PrintWriter out = response.getWriter();
		out.println(j.toString());
		
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
