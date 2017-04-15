<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" 
isErrorPage="true"%>
<html>
	<head></head>
	<body style="font-size:30px;font-style:italic;">
		发生了异常:<%=exception.getMessage()%>
	</body>
</html>