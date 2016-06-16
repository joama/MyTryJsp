<%@ page language="java" contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="chap4.info.business.InfoService"%>
<%@page import="chap4.info.persistence.Information"%>
<%@page import="chap4.info.persistence.User"%>
<%request.setCharacterEncoding("utf-8");%>
<html>
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
<h3>發布資訊</h3>
<div class="date"></div>
</div>
<div class="content">
<form action="informationUpdate.jsp" method="post">
<%
	User user = (User) session.getAttribute("user");
	InfoService infoService = new InfoService();
	String id = request.getParameter("id");
	Information information = infoService.getInfoByID(id);
%> 
<input type="hidden" name="id" value="<%=id%>"> 
標題：<input type="text"
	name="title" id="title" style="width: 400px;" value="<%=information.getTitle() %>"><br>
內容：<textarea name="content" id="content"
	style="width: 400px; height: 100px;"><%=information.getContent() %></textarea><br>
<input type="submit" value="發布"></form>
</div>
<br>
<div class="footer">
<ul>
	<li class="readmore"><a href="javascript:history.back(-1);">返回</a></li>
</ul>
</div>
</div>
<!-- primary content end --></div>


<div id="secondarycontent"><!-- secondary content start -->
<h3><%=user.getUserName() %></h3>
<!-- secondary content end --></div>

<div id="footer">&copy; 社區小組. All rights reserved. Design by 社區小組.
</div>

</div>
</div>
</body>
</html>

