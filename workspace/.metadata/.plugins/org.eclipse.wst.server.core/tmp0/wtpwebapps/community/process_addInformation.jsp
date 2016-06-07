<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="domain.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="domain.Information" %>

<%@ page import="service.imp.Infoservice" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="infoService" scope="session" class=service.imp.Infoservice></jsp:useBean>
<%

	String title = request.getParameter("title");

	String content = request.getParameter("content");
	
	String type = request.getParameter("type");
	
	String userName = ((User)session.getAttribute("user")).getUserName();
	
	Information information = new Information();
	information.setTitle(title);
	information.setContent(content);
	information.setType(type);
	SimpleDateFormat dateFormat=new SimpleDateFormat("yy/MM/dd HH:mm");
    information.setPublishingtime(dateFormat.format(new Date()));
    
    information.setPublishiuser(userName);
    
    infoService.addInfo(information);

%>

	<jsp:forward page="main.jsp"></jsp:forward>
</body>
</html>