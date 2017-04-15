<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@page import="bean.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c"  %>
<html>
	<head></head>
	<body style="font-size:30px;font-style:italic;">
		<%
			User user = new User();
			user.setGender("x");
			request.setAttribute("user",user);
		 %>
		 性别:${user.gender}
		 <c:if test="${user.gender == 'm'}">男</c:if>
		 <c:if test="${user.gender != 'm'}">女</c:if>
		 <br/>
		 <c:if test="${user.gender =='m'}" var="rs" 
		 scope="page">男</c:if>
		 <c:if test="${!rs}">女</c:if>
		 
		 
	</body>
</html>