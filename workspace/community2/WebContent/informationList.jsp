<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="chap4.info.persistence.User"%>
<%@page import="chap4.info.business.InfoService"%>
<%@page import="java.util.List"%>
<%@page import="chap4.info.persistence.Information"%>
<%@page import="java.text.SimpleDateFormat"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/default.css" />
<title>社區主頁</title>
</head>
<body>
<div id="outer">
<div id="upbg"></div>
<div id="inner">
<div id="header">
<h1><span>簡易社區</span></h1>
<h2>by 社區小組</h2>
</div>
<div id="splash"></div>
<div id="menu">
<ul>
	<li class="first"><a href="main.jsp">資訊瀏覽</a></li>
</ul>
<div id="date"></div>
</div>

<div id="primarycontent"><!-- primary content start -->
<div class="post">
<div class="header">
<h3>資訊</h3>
<div class="date"></div>
</div>
<div class="content">
<%
User user = (User) session.getAttribute("user");
InfoService infoService = new InfoService();
List<Information> list = infoService.getAllInfo();
SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
for(Information information : list)
{
%>

<p><a class= "more-link" href="informationDetail.jsp?id=<%=information.getId() %>"><%=information.getTitle() %></a>
&nbsp;&nbsp;<%=dateFormat.format(information.getPublishingTime()) %>
&nbsp;&nbsp; 
<%
	if(information.getPublishingUser().getId().equals(user.getId()))
	{
%> 
		<a class= "more-link" href="editInformation.jsp?id=<%=information.getId() %>">修改</a>
		<a class= "more-link" href="informationDelete.jsp?id=<%=information.getId() %>">刪除</a> 
<%
	}
}
%>
</p>

</div>
<div class="footer">
</div>
</div>
<!-- primary content end --></div>

<div id="secondarycontent"><!-- secondary content start -->
<h3><%=user.getUserName() %></h3>

<div class="content">
<p><a class= "more-link" href="addInformation.jsp">發布資訊</a></p>
</div>
<!-- secondary content end --></div>

<div id="footer">&copy; 社區小組. All rights reserved. Design by 社區小組.
</div>

</div>
</div>
</body>
</html>
