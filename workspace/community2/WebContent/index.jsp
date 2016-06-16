<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%
request.setCharacterEncoding("utf-8");
String errorCode=(String)request.getParameter("errorCode");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/default.css" />
<title>成員登錄</title>
</head>
<body>
<%
if(errorCode!=null&&errorCode.equals("err")){
%>	
<font size="7">用戶名或密碼錯誤！</font>

<%}%>

<form action="loginProcess.jsp" method="post">
	<table align="center" border="0" cellpadding="0" cellspacing="7"
		height="170" width="234">
		<tbody>
			<tr>
				<td align="left" valign="middle">&nbsp;</td>
			</tr>
		</tbody>
	</table>
	<table align="center" border="0" cellpadding="0" cellspacing="7"
		width="234">
		<tbody>
			<tr>
				<td align="left" valign="middle">
					<a class="more-link" href="register.jsp">註冊為新成員</a>
				</td>
			</tr>
		</tbody>
	</table>
	<table align="center" border="0" cellpadding="0" cellspacing="7"
		width="234">
		<tbody>
			<tr>
				<td align="left" valign="middle" width="26">
					<img src="css/images/jiantou3.jpg" width="11" height="10">
				</td>
				<td align="center" valign="middle" width="60">
					<img src="css/images/user.jpg" width="46" height="15">
				</td>
				<td align="center" valign="middle" width="148">
					<input type="text" name="userName" id="userName">
				</td>
			</tr>
		</tbody>
	</table>
	<table align="center" border="0" cellpadding="0" cellspacing="7"
		width="234">
		<tbody>
			<tr>
				<td align="left" valign="middle" width="26">
					<img src="css/images/jiantou3.jpg" width="11" height="10">
				</td>
				<td align="center" valign="middle" width="60">
					<img src="css/images/pass.jpg" width="47" height="15">
				</td>
				<td align="center" valign="middle" width="148">
					<input type="password" name="password" id="password">
				</td>
			</tr>
		</tbody>
	</table>
	<table align="center" border="0" cellpadding="0" cellspacing="5"
		width="232">
		<tbody>
			<tr>
				<td align="left"><input type="submit" value="進入"></td>
			</tr>
		</tbody>
	</table>
</form>
</body>
</html>
