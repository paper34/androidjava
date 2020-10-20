<%@page import="book.BookDAO"%>
<%@page import="book.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>

<jsp:useBean id="vo" class="book.BookDTO"></jsp:useBean>
<jsp:setProperty property="*" name="vo" />

<%
	request.setCharacterEncoding("UTF-8");
%>

<%
	BookDAO dao = new BookDAO();
	boolean result =  dao.create(vo);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%= result %></h1>
</body>
</html>