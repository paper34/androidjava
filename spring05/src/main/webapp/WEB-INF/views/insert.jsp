<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- boottrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>게시물 등록 정보입니다</h3>
	<table class="table table-hover text-center">
		<thead>
			<tr>
				<th width="10%">글번호</th>
				<th width="55%">글내용</th>
				<th width="10%">제목</th>
				<th width="10%">작성자</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<th width="10%">${bbsVO.no}</th>
				<th width="55%">${bbsVO.content}</th>
				<th width="10%">${bbsVO.title}</th>
				<th width="10%">${bbsVO.writer}</th>
			</tr>
		</tbody>
	</table>
	
	<a href="index.jsp">첫페이지</a>
	<a href="update.do">수정페이지</a>
</body>
</html>