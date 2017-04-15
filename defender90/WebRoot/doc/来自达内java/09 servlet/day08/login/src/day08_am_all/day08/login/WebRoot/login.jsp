<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head></head>
	<body style="font-size:30px;font-style:italic;">
		<form action="login.do" method="post">
			<fieldset>
				<legend>登录</legend>
				用户名:<input name="username"/>
				<%
					String msg = 
					(String)request.getAttribute("login_failed");
				 %>
				<span style="color:red;"><%=(msg == null ? "" : msg)%></span>
				<br/>
				密码:<input name="pwd"/><br/>
				<input type="submit" value="确定"/>
			</fieldset>
		</form>
	</body>
</html>