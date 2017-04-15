package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener{

	/**
	 * session对象只要被创建，该方法
	 * 就会执行。
	 */
	public void sessionCreated(
			HttpSessionEvent arg0) {
		System.out.println("sessionCreated...");
		HttpSession session = arg0.getSession();
		ServletContext sctx = session.getServletContext();
		Integer count =
				(Integer)sctx.getAttribute("count");
		if(count == null){
			//第一个用户
			count = 1;
		}else{
			count ++;
		}
		sctx.setAttribute("count", count);
	}

	/**
	 * session对象一旦被销毁，该方法
	 * 就会执行。
	 */
	public void sessionDestroyed(
			HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed...");
		HttpSession session = arg0.getSession();
		ServletContext sctx = session.getServletContext();
		Integer count =
				(Integer)sctx.getAttribute("count");
		if(count == null){
			//第一个用户
			count = 1;
		}else{
			count --;
		}
		sctx.setAttribute("count", count);
	}

}
