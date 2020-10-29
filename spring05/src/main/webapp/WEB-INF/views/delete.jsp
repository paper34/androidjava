<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>나는 삭제하는 페이지</h1>
<!-- webapp아래로 자동으로 페이지 넘김 -->
<%-- <% response.sendRedirect("index.jsp");%> --%>

<!-- viewss아래의 파일로 자동으로 페이지 넘김 -->
<jsp:forward page="home.jsp"></jsp:forward>
<a href="index">첫페이지로</a>
</body>
</html>