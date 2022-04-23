<%@page import="com.laptrinhjavawed.service.impl.UserService"%>
<%@page import="com.laptrinhjavawed.service.IUserService"%>
<%@page import="javax.inject.Inject"%>
<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.lang.String" %>	
<%
	 IUserService userService = new UserService();
	String userName=request.getParameter("userName");
	if(userService.findOneByUserName(userName)!=null){
		%>
			<i class="fa-solid fa-exclamation"></i>
		<%
	}else{
		%>
			<i class="fa-solid fa-circle-check"></i>
		<%
	}
%>