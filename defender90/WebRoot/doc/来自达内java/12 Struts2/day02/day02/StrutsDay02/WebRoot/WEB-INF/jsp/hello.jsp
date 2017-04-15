<%@page pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body>
	
	<h1>演示ValueStack</h1>
	<h1>1.观察ValueStack</h1>
	<h1></h1>
	<h1>2.输出栈顶</h1>
	<h1><s:property/></h1>
	<h1>3.从Map中取值</h1>
	<h1>
		<s:property value="#action.realName"/>
	</h1>
	<h1>4.迭代集合</h1>
	<h1>
		<s:iterator value="users">
			<s:property value="userName"/>
		</s:iterator>
	</h1>
	<h1>5.按数字迭代</h1>
	<h1>
		<s:iterator begin="1" end="totalPage" var="p">
			<s:debug/>
			<s:if test="#p==currentPage">
				<font style="color:red;">
					<s:property />
				</font>
			</s:if>
			<s:else>
				<s:property />
			</s:else>
		</s:iterator>
		<s:debug/>
	</h1>
	
	
	<br/><br/><br/><br/><br/>
	
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
	<h1>3.访问数组、集合</h1>
	<h1>
		数组：<s:property value="langs[1]"/>
	</h1>
	<h1>
		集合：<s:property value="cities[2]"/>
	</h1>
	<h1>4.访问Map</h1>
	<h1>
		Map:<s:property value="empMap.lisi"/>
	</h1>
	<h1>5.访问时进行运算</h1>
	<h1>
		ID+10:<s:property value="id+10"/>
	</h1>
	<h1>
		介绍：<s:property value="'My name is '+realName"/>
	</h1>
	<h1>6.访问时调用方法</h1>
	<h1>
		REALNAME:<s:property value="realName.toUpperCase()"/>
	</h1>
	<h1>7.创建集合</h1>
	<h1>
		集合:<s:property value="{'a','b','c'}"/>
	</h1>
	<h1>
		类型:<s:property value="{'a','b','c'}.getClass().getName()"/>
	</h1>
	<h1>8.创建Map</h1>
	<h1>
		Map:<s:property value="#{'M':'男','F':'女'}"/>
	</h1>
	<h1>
		类型:<s:property value="#{'M':'男','F':'女'}.getClass().getName()"/>
	</h1>
	
</body>
</html>