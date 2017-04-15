<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head></head>
	<body>
		hello<br/>
		<img id="img1" src="checkcode" border="1"/>
		<a href="javascript:;" 
		onclick="document.getElementById('img1').src='checkcode?' + Math.random();">看不清，换一个</a>
	</body>
</html>