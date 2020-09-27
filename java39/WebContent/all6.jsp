<%@page import="bean.BbsDAO"%>
<%@page import="java.util.List"%>
<%@page import="bean.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- DAO를 이용해서 결과를 ArrayList로 받아온 후, html을 만든다. -->

<%
	String content = request.getParameter("content");
	BbsDAO dao = new BbsDAO();
	List<BbsVO> list = dao.all2(content);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
table {
	border-collapse: collapse;
}

td {
	width: 100px;
	text-align: center;
}

.td {
	background: pink;
}
</style>
</head>
<body>
	<h3>
		검색결과의 개수
		<%=list.size()%>
		개
	</h3>

	<table border="1">
		<tr>
			<th class="td">번호</th>
			<th class="td">작성자</th>
			<th class="td">제목</th>
			<th class="td">내용</th>
		</tr>
		<%
			for (int i = 0; i < list.size(); i++) {
			BbsVO vo = list.get(i);
		%>
		<tr>
			<td><%=vo.getNo()%></td>
			<td><%=vo.getWriter()%></td>
			<td><%=vo.getTitle()%></td>
			<td><%=vo.getContent()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>