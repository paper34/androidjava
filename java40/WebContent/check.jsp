<%@page import="bean.MemberDAO"%>
<%@page import="bean.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String id = request.getParameter("id");
	MemberDAO dao = new MemberDAO();
	int result = dao.read(id);

	String check = "중복된 아이디";
	if (result == 0) {
	check = "사용가능한 아이디";
	}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><%=id%>는
		<%=check%>입니다
	</h3>
	<hr color="red">
	<hr color="orange">
	<hr color="yellow">
	<hr color="green">
	<hr color="blue">
	<a href="js07.html">
		<button style="background: white;">회원가입 페이지로</button>
	</a>


</body>
</html>