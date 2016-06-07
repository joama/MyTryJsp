<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*,domain.*,service.imp.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>社區主頁</title>
</head>
<body>
<jsp:useBean id="infoService" class="service.imp.Infoservice" scope="session"></jsp:useBean>
<%

	List<Information> list = infoService.getAllInfo();

%>
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
				<li><a href="#">控制台</a></li>
				<li><a href="logout.jsp">退出</a></li>
			</ul>
		<div id="date"></div>
		</div>
		<div id="primarycontent">
		
			<!-- orimary content start -->
			<div class="post">
				<div class="header">
					<h3>日誌</h3>
					<div class="date"></div>
				</div>
				<%
				
				for(Information info:list){
					if(info.getType().equals("日誌")){
				%>
				<div class="content">
				
					<p><a href="detail.jsp?Id=<%=info.getId()%>"><%=info.getTitle() %></a>&nbsp;&nbsp;<%=info.getPublishingtime() %></p>
				</div>
				<%
					}
				}
				%>
			</div>
			<!-- primary content end -->			
		</div>
		<div id="secondarycontent">
			<!-- secondary content start -->
			
			<h3><%=((User)session.getAttribute("user")).getUserName() %></h3>
			
			<div class="content">
				<p><a href="addInformation.jsp">發布資訊</a></p>
			</div>
			<!-- secondary content end -->
		</div>
		<div id="footer">
			&copy; 社區小組 . All rights reserved. Design by 社區小組.
		</div>
	</div>
</div>
</body>
</html>