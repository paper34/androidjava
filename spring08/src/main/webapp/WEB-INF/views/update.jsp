<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>수정완료</h3>
	<hr color="red">
	상품번호: ${productVO.no} <br> 
	상품이름: ${productVO.name} <br> 
	상품설명: ${productVO.content} <br> 
	*** 수정된 상품가격: ${productVO.price} <br> 
</body>
</html>