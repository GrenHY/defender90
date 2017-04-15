<%@page pageEncoding="utf-8"  
contentType="text/html;charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
    	这是首页<br/>
    	当前在线人数是:
    	<%=application.getAttribute("count")%>
    	<br/>
    	<a href="logout">退出系统</a>
  </body>
</html>
