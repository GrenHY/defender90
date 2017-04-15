<%@page pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
	<table>
		<c:forEach items="${emps}" var="e">
		<tr>
			<td>${e.empno }</td>
			<td>${e.ename }</td>
			<td>${e.sal }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>