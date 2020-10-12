<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie c1 = new Cookie("name", "홍길동");
		c1.setMaxAge(0); // 쿠기 시간지정하고 끄기
		response.addCookie(c1);

	%>
	<h1>브라우저에 쿠기를 심었음</h1>
	<a href="브라우저에서쿠기가져오기.jsp">브라우저에서쿠기가져오기</a>
</body>
</html>