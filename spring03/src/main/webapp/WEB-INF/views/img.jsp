<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 리소스 아래에 파일 지정 -->
	
	${param.color}색 자동차!!
	
	<a href="img.jsp?color=red">
	<img src="resources/img/bluecar.jpg">빨간자동차로 이동.! </a>
</body>
</html>