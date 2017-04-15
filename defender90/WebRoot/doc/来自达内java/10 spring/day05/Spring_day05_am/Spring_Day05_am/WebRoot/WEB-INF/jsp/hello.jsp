<%@ page   pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" 
	uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title></title>
    <!-- 利用 JSTL 生成 css文件路径 -->
    <c:url var="cssUrl" value="/css/styles.css"/>
    <link type="text/css" rel="stylesheet"
    	href="${cssUrl}">
  </head>
  <body>
   	<h1>${msg} World!</h1>
  </body>
</html>
