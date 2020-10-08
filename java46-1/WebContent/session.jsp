<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% session.setAttribute("id", "park"); //session: 클라이언트인 브라우저와 서버와의 연결연결하는 동안 지속적으로 다양한 곳에서 사용할 데이터를 지정한 후 사용 가능
 session.setAttribute("name", "박길동"); 
application.setAttribute("count", 100); //application: 사이트가 down될 때까지 유지시키고자 하는 데이터를 지정한 후 사용 가능
%>
<a href="세션보기.jsp">세션보기</a>
<a href="세션보기2.jsp">세션보기</a>
</body>
</html>