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
				验证码:<input name="number"/>
				<%
					String msg2 = 
					(String)request.getAttribute("number_error");
				 %>
				<span style="color:red;"><%=(msg2 == null ? "" : msg2)%></span>
				<br/>
				<img id="img1" src="checkcode" border="1"/>
		<a href="javascript:;" 
		onclick="document.getElementById('img1').src='checkcode?' + Math.random();">看不清，换一个</a>
				<br/>
				<input type="submit" value="确定"/>
			</fieldset>
		</form>
	</body>
</html>