<%@ page   pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" 
	uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>上载文件</title>
  </head>
  <body>
   	<h1>发布你的作品</h1>
   	<h2>${message}</h2>
   	<c:url var="url" value="/upload/save.form"/>
   	<form method="post"	action="${url}"
   		enctype="multipart/form-data">
   		<p>图片：<input type="file" 
   			name="image"></p>
   		<p>作者：<input type="text"
   			name="author"></p>
		<div><input type="submit"></div>   			
   	</form>
  </body>
</html>



