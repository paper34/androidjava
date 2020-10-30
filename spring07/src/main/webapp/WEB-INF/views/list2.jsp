<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>전체회원 검색 정보</h3>
	<hr color="red">
	<c:forEach var="vo" items="${list}">
	회원 id: ${vo.id}, 
	회원 pw: ${vo.pw}, 
	회원 name: ${vo.name}, 
	회원 tel: ${vo.tel}<br>
	</c:forEach>
</body>
</html>