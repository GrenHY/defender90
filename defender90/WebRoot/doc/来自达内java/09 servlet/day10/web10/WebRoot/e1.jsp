<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@page import="bean.*" %>
<html>
	<head></head>
	<body style="font-size:30px;font-style:italic;">
		<%
			User user = new User();
			user.setName("Tom");
			user.setAge(22);
			user.setInterest(new String[]{"snooker","football"});
			request.setAttribute("user",user);
			User user2 = new User();
			user2.setName("King");
			user2.setAge(22);
			session.setAttribute("user",user2);
		 %>
		 name:<%
		 	//User user1 =
		 	// (User)request.getAttribute("user1");
		 	//out.println(user1.getName());
		  %><br/>
		  name:${user.name}<br/>
		  name:${sessionScope.user.name}
		  <br/>
		  name:${user["name"]}<br/>
		  <%
		  	request.setAttribute("str","age");
		   %>
		  ${user[str]}<br/>
		  ${user.interest[0]}
		  
	</body>
</html>