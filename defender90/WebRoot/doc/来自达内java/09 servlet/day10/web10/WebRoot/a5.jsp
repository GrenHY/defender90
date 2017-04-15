<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head></head>
	<body style="font-size:30px;font-style:italic;">
		<%
			pageContext.setAttribute("uname","King");
		 %>
		 <%=pageContext.getAttribute("uname") %>
	</body>
</html>