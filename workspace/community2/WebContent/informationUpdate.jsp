<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@page import="chap4.info.business.InfoService"%>
<%@page import="chap4.info.persistence.Information"%>
<%request.setCharacterEncoding("utf-8");%>
<%
	//獲得要修改的信息的id
	String id = request.getParameter("id");
	//獲得修改後的標題
	String title = request.getParameter("title");
	//獲得修改後的內容
	String content = request.getParameter("content");
	InfoService infoService = new InfoService();
	//根據id獲得要修改的信息對象實例
	Information information = infoService.getInfoByID(id);
	information.setTitle(title);
	information.setContent(content);
	//修改信息
	infoService.addOrUpdateInfo(information);
	//跳轉到主頁面
	response.sendRedirect("informationList.jsp");
%>
