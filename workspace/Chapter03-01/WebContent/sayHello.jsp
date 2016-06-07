<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!String name = "Garfield";%>
	<%
	name+="! Have a nice day!";
	for(int a=0;a<5;a++)
	{
	%>
	<font color = "blue" size="10pt"><%=name %></font><br>
	<%
	}
	%>
</body>
</html>