<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@page import="chap4.info.persistence.User"%>
<%@page import="java.util.Date"%>
<%@page import="chap4.info.business.InfoService"%>
<%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="information" scope="request"
	class="chap4.info.persistence.Information" />
<jsp:setProperty name="information" property="*" />
<%

       //獲得登錄用戶資訊
	User user = (User) session.getAttribute("user");

	//設置資訊發布時間為當前時間
	information.setPublishingTime(new Date());
	//設置資訊發布者為當前用戶
	information.setPublishingUser(user);
	InfoService infoService = new InfoService();
	//保存資訊
	infoService.addOrUpdateInfo(information);
	//跳轉到主頁面
	response.sendRedirect("main.jsp");
%>
