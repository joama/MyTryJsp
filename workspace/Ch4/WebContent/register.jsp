<%@ page language="java" contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/default.css" />
<title>註冊介面</title>
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
<div id="menu"></div>

<div id="primarycontent"><!-- primary content start -->
<div class="post">
<div class="header">
<h3>個人資料</h3>
<div class="date"></div>
</div>
<div class="content">
<form action="registerProcess.jsp" method="post">
用戶名稱：<input type="text" name="userName" id="userName"><br>
密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;碼：<input type="password" name="password" id="password"><br>
姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="realName" id="realName"><br>
<input type="submit" value="註冊">
</form>
</div>
<br>
<div class="footer">
<ul>
	<li class="readmore"><a href="index.jsp">返回</a></li>
</ul>
</div>
</div>
<!-- primary content end -->
</div>
<div id="footer">&copy; 社區小組. All rights reserved. Design by 社區小組.
</div>
</div>
</div>
</body>
</html>
