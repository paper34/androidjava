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
		Cookie c1 = new Cookie("subject", "스프링");
		response.addCookie(c1);
		
		Cookie c2 = new Cookie("place", "709호");
		response.addCookie(c2);
		
		Cookie c3 = new Cookie("count", "100명");
		response.addCookie(c3);
		c3.setMaxAge(0);
		response.addCookie(c3);
	%>
	<h1>브라우저에 쿠기를 심었음</h1>
	<a href="test1가져오기.jsp">브라우저에서쿠기가져오기</a>
</body>
</html>