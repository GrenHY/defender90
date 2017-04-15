<%@ page   pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" 
	uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>登陆页面</title>
    <style type="text/css">
    h1,h2,h3,h4,h5,p{margin: 0; padding: 0}
    form{ border: 5px solid #eee; 
      width: 280px}
    h2, h3{background: #000; color:#fff;
      text-align: center; }
    h2 {padding: 6px}
    h3, form span{color: red;}
    form p {padding: 6px; background: #ddd;}
    form p input{width: 120px}
    form div{padding: 6px; background: gray;}
    form {float:left}
    </style>
  </head>
  <body>
  	<c:url var="url" 
  		value="/login/login-action1.form"/>
   	<form method="post"
   		action="${url}">
   		<h2>登陆action1</h2>
   		<h3>${msg1}</h3>
   		<p>用户:<input type="text" 
   		    name="name"><span>${nameMsg1}</span></p>
   		<p>密码:<input type="password" 
   			name="pwd"><span>${pwdMsg1}</span></p>
   		<div><input type="submit"
   		  value="Login"></div>
   	</form>

  	<c:url var="url" 
  		value="/login/login-action2.form"/>
   	<form method="post"
   		action="${url}">
   		<h2>登陆action2</h2>
   		<h3>${msg2}</h3>
   		<p>用户:<input type="text" 
   		    name="name"><span>${nameMsg2}</span></p>
   		<p>密码:<input type="password" 
   			name="pwd"><span>${pwdMsg2}</span></p>
   		<div><input type="submit"
   		  value="Login"></div>
   	</form>

   	<c:url var="url" 
  		value="/login/login-action3.form"/>
   	<form method="post"
   		action="${url}">
   		<h2>登陆action3</h2>
   		<h3>${msg3}</h3>
   		<p>用户:<input type="text" 
   		    name="name"><span>${nameMsg3}</span></p>
   		<p>密码:<input type="password" 
   			name="pwd"><span>${pwdMsg3}</span></p>
   		<div><input type="submit"
   		  value="Login"></div>
   	</form>
   	<c:url var="url" 
  		value="/login/login-action4.form"/>
   	<form method="post"
   		action="${url}">
   		<h2>登陆action4</h2>
   		<h3>${msg4}</h3>
   		<p>用户:<input type="text" 
   		    name="name"><span>${nameMsg4}</span></p>
   		<p>密码:<input type="password" 
   			name="pwd"><span>${pwdMsg4}</span></p>
   		<div><input type="submit"
   		  value="Login"></div>
   	</form>
   	<c:url var="url" 
  		value="/login/login-action5.form"/>
   	<form method="post"
   		action="${url}">
   		<h2>登陆action5</h2>
   		<h3>${msg5}</h3>
   		<p>用户:<input type="text" 
   		    value="${name}"
   		    name="name"><span>${nameMsg5}</span></p>
   		<p>密码:<input type="password" 
   			name="pwd"><span>${pwdMsg5}</span></p>
   		<div><input type="submit"
   		  value="Login"></div>
   	</form>
  	<c:url var="url" 
  		value="/login/login-action6.form"/>
   	<form method="post"
   		action="${url}">
   		<h2>登陆action6</h2>
   		<h3>${msg6}</h3>
   		<p>用户:<input type="text" 
   		    value="${name6}"
   		    name="name6"><span>${nameMsg6}</span></p>
   		<p>密码:<input type="password" 
   			name="pwd"><span>${pwdMsg6}</span></p>
   		<div><input type="submit"
   		  value="Login"></div>
   	</form>

  </body>
</html>






