<%@page import="bean.BbsDAO"%>
<%@page import="bean.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	BbsVO vo = new BbsVO();
	String no = request.getParameter("no");
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	vo.setNo(Integer.parseInt(no));
	vo.setWriter(writer);
	vo.setTitle(title);
	vo.setContent(content);
	
	BbsDAO dao = new BbsDAO();
	boolean result = dao.create(vo);
	
	String check = "글쓰기 실패!!!";
	if(result) {
		check = "글쓰기 성공!!";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시판 쓰기 <%=check %></h3>
	<a href="bbs.html">게시판 글쓰기페이지</a>
</body>
</html>