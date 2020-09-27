<%@page import="bean.BbsDAO"%>
<%@page import="bean.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 1. id값 받아와야 함. -->
<!-- 2. dao와 연동하여 결과 받아와야함. -->
<!-- 3. html로 만들어서 전송해야함 -->
<%
	String no = request.getParameter("no");
	BbsDAO dao = new BbsDAO();
	BbsVO vo = dao.one(Integer.parseInt(no));
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시판 번호 <%=vo.getNo()%>의 게시글입니다.
	</h3>
	<hr color="red">
	<form action="update2-bbs.jsp">
		<table>
			<tr align="center">
				<td width="100" bgcolor="yellow">번호</td>
				<td width="200" bgcolor="pink"><%=vo.getNo()%> <input
					type="hidden" name="no" value="<%=vo.getNo()%>" readonly="readonly">
				</td>
			</tr>
			<tr align="center">
				<td width="100" bgcolor="yellow">제목</td>
				<td width="200" bgcolor="pink"><input type="text" name="title"
					value="<%=vo.getTitle()%>"></td>
			</tr>
			<tr align="center">
				<td width="100" bgcolor="yellow">내용</td>
				<td width="200" bgcolor="pink"><input type="text" name="content"
					value="<%=vo.getContent()%>"></td>
			</tr>
			<tr align="center">
				<td width="100" bgcolor="yellow">작성자</td>
				<td width="200" bgcolor="pink"><input type="text" name="writer"
					value="<%=vo.getWriter()%>"></td>
			</tr>

			<tr align="center">
				<td colspan="2" width="300">
					<button type="submit"
						style="width: 300px; background: red; color: white">게시글
						수정</button>
				</td>
			</tr>
		</table>
	</form>

	<hr color="green">
	<a href="index.html">
		<button style="background: red">처음페이지로</button>
	</a>
	<a href="one.jsp?id=<%=vo.getNo()%>">
		<button style="background: orange">검색</button>
	</a>
	<a href="delete.jsp?id=<%=vo.getNo()%>">
		<button style="background: yellow">삭제</button>
	</a>

</body>
</html>