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
	<h3>전체 상품 검색 정보</h3>
	<hr color="red">
	<c:forEach var="vo" items="${list}">
	상품번호: ${vo.no}, 
	상품명: ${vo.name}, 
	상품설명: ${vo.content}, 
	상품가격: ${vo.price}<br>
	</c:forEach>
</body>
</html>