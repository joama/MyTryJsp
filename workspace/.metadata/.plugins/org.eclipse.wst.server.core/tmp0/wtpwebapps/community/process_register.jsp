<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="service.imp.UserService"%>
<%@ page import="domain.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	
	String realName = request.getParameter("realName");
	
	String gender = request.getParameter("gender");
	
	String age = request.getParameter("age");
	
	String personalSignature = request.getParameter("personalSignature");
	
	User user = new User();
	
	
	user.setUserName(userName);
	user.setPassword(password);
	user.setRealName(realName);
	user.setGender(gender);
	user.setAge(Integer.parseInt(age));
	user.setPersonalSignature(personalSignature);
	
	try{
		
		userService.addUser(user);
%>
		<jsp:forward page="login.jsp"></jsp:forward>
<%
	}catch(Exception ex){
		ex.printStackTrace();
		
%>
		<jsp:forward page="register.jsp"></jsp:forward>
<%
	}
%>
</body>
</html>