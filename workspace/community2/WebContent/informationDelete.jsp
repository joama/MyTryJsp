<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@page import="chap4.info.business.InfoService"%>
<%request.setCharacterEncoding("utf-8");%>
<%
	//獲得要刪除的信息的id
	String id = request.getParameter("id");
	InfoService infoService = new InfoService();
	//根據信息id刪除信息
	infoService.deleteInfoById(id);
	//跳轉到信息列表頁面
	response.sendRedirect("informationList.jsp");
%>
