<%@page pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body>
	
	<h1>演示OGNL</h1>
	<h1>1.访问基本属性</h1>
	<h1>
		ID:<s:property value="id"/>
	</h1>
	<h1>
		姓名:<s:property value="realName"/>
	</h1>
	<h1>2.访问实体对象</h1>
	<h1>
		账号:<s:property value="user.userName"/>
	</h1>
	
</body>
</html>