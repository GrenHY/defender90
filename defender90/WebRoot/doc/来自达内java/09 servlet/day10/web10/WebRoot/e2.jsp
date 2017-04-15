<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@page import="java.util.*" %>
<html>
	<head></head>
	<body style="font-size:30px;font-style:italic;">
		算术运算:<br/>
		${1 + 1}<br/>
		${1 % 2 + 1}<br/>
		${"1" + "1"}
		<hr/>
		关系运算<br/>
		${ 1 < 2 }
		<%
			request.setAttribute("str1","abc");
		 %>
		${str1 == "abc"}
		<hr/>
		逻辑运算<br/>
		${ 1 < 2 &&  3 > 2 }
		<hr/>
		empty运算<br/>
		<%
			request.setAttribute("str2","");
			List list1 = new ArrayList();
			list1.add("a");
			request.setAttribute("list1",list1);
		 %>
		空字符串 : ${empty str2}
		空的集合:  ${empty list1}
		null值:			${empty null}
		找不到值:  ${empty aaa}
		
		
	</body>
</html>