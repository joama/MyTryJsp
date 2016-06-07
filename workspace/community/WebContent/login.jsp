<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登入介面</title>
</head>
<body>
	<form action="process_login.jsp" method="post">
		<table align="center" border="0" cellpadding="0" cellspacing="7" width="234">
			<tr>
				<td align="left" valign="middle" width="26">
					<img src="css/images/jiantou3.jpg" width="11" height="10">
				</td>
				<td align="center" valign="middle" width="60">
					<img src="css/images/user.jpg" width="46" height="15">
				</td>
				<td align="center" valign="middle" width="148">
					<input type = "Text" name="userName"/>
				</td>
			</tr>
			<tr>
				<td align="left" valign="middle" width="26">
					<img src="css/images/jiantou3.jpg" width="11" height="10">
				</td>
				<td align="center" valign="middle" width="60">
					<img src="css/images/pass.jpg" width="47" height="15">
				</td>
				<td align="center" valign="middle" width="148">
					<input type = "password" name="password"/>
				</td>
			</tr>
			<tr>
				<td align="left"><input type="submit" value="進入"/></td>
			</tr>
		</table>
	</form>
</body>
</html>