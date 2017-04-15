package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener{

	/**
	 * session����ֻҪ���������÷���
	 * �ͻ�ִ�С�
	 */
	public void sessionCreated(
			HttpSessionEvent arg0) {
		System.out.println("sessionCreated...");
		HttpSession session = arg0.getSession();
		ServletContext sctx = session.getServletContext();
		Integer count =
				(Integer)sctx.getAttribute("count");
		if(count == null){
			//��һ���û�
			count = 1;
		}else{
			count ++;
		}
		sctx.setAttribute("count", count);
	}

	/**
	 * session����һ�������٣��÷���
	 * �ͻ�ִ�С�
	 */
	public void sessionDestroyed(
			HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed...");
		HttpSession session = arg0.getSession();
		ServletContext sctx = session.getServletContext();
		Integer count =
				(Integer)sctx.getAttribute("count");
		if(count == null){
			//��һ���û�
			count = 1;
		}else{
			count --;
		}
		sctx.setAttribute("count", count);
	}

}
