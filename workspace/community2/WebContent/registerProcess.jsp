<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@page import="chap4.info.business.UserService"%>
<%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="user" scope="request"
	class="chap4.info.persistence.User" />
<jsp:setProperty name="user" property="*" />
<%
	UserService service = new UserService();
	
    //如果用戶添加失敗，則跳轉到錯誤頁面
    boolean b=service.addUser(user);
	if(b){
		//將用戶信息保存在session中備用
		session.setAttribute("user", user);
		//跳轉到主頁面
		response.sendRedirect("main.jsp");
	}else {
		response.sendRedirect("error.jsp?errorCode=1");
	}
	%>
