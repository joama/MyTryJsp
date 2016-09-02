<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/default.css" />
<title>成員登陸</title>
</head>
<body>
<form action="login" methos="post" name="login">
	<table align="center" border="0" cellpadding="0" cellspacing="7" width="234">
		<tbody>
			<tr>
				<td align="left" valign="middle">
					<s:a href="register_input.action">註冊為新成員</s:a>
				</td>
			</tr>
		</tbody>
	</table>
	<table align="center" border="0" cellpadding="0" cellspacing="7" width="234">
		<tbody>
			<tr>
				<td align="center" valign="middle" width="148">
					<input type="text" name="user.userName"/>
				</td>
			</tr>
		</tbody>
	</table>
	<table align="center" border="0" cellpadding="0" cellspacing="7" width="234">
		<tbody>
			<tr>
				<td align="center" valign="middle" width="148">
					<input type="password" name="user.password"/>
				</td>
			</tr>
		</tbody>
	</table>
	<table align="center" border="0" cellpadding="0" cellspacing="5" width="232">
		<tbody>
			<tr>
				<td align="left">
					<input type="submit" value="進入"/>
				</td>
			</tr>
		</tbody>
	</table>
</form>
</body>
</html>