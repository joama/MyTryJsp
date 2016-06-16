<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@page import="chap4.info.business.UserService"%>
<%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="user" scope="request" class="chap4.info.persistence.User"/>
<jsp:setProperty name="user" property="*"/>
<%
UserService userService = new UserService();
//驗證用戶名和密碼是否匹配
if(!userService.validateUser(user.getUserName(), user.getPassword()))
{
	//如果不匹配，則跳轉到index.jsp顯示錯誤信息，並重新登陸
	response.sendRedirect("index.jsp?errorCode=err");
}
else	//如果匹配成功
{	
	String id = userService.getUserIdByName(user.getUserName());
	//將用戶信息保存在session中，在訪問其他頁面的時候驗證用戶是否已經登陸
	session.setAttribute("user", userService.getUserByID(id));
	//跳轉到主頁面
	response.sendRedirect("main.jsp");
}
%>
