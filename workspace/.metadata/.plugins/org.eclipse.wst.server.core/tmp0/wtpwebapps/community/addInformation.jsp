<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="process_addInformation.jsp" method="post">
	<table>
		<tr>
			<td>
				<label>標題</label>
				<input type="text" name="title" />
			</td>
		</tr>
		<tr>
			<td>
				<label>內容</label>
				<textarea rows="3" cols="18" name="content"></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<label>類別型</label>
				<select name="type">
					<option value="日誌">日誌</option>
					<option value="社區資訊">社區資訊</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="發布">
			</td>
		</tr>
	</table>
</form>
</body>
</html>