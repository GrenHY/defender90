<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head></head>
	<body style="font-size:30px;font-style:italic;">
		<%
			//session验证 
			Object obj = session.getAttribute("user");
			if(obj == null){
				//没有登录，或者session超时
				//跳转到登录页面
				response.sendRedirect("login.jsp");
				return;
			}
		 %>
		主功能页面...<br/>
		<%
			System.out.println("重定向之后的语句...");
		 %>
	</body>
</html>