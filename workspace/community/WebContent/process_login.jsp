<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="service.imp.UserService,domain.User" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="userService" class="service.imp.UserService" scope="session"></jsp:useBean>
<%
	String userName = request.getParameter("userName");
	String password = request.getParameter("password");
	if(userService.validateUser(userName,password) != null){
		
		session.setAttribute("user", userService.validateUser(userName, password));
%>
		<jsp:forward page="main.jsp"></jsp:forward>
<%
	}else{
%>
		<jsp:forward page="login.jsp"></jsp:forward>
<%
	}
%>
</body>
</html>