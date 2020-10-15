<%@page import="bean.BbsDAO"%>
<%@page import="java.util.List"%>
<%@page import="bean.BbsVO"%>
<jsp:useBean id="vo" class="bean.BbsVO"></jsp:useBean>
<!-- useBean액션태그: new를 가지고 객체생성, import역할 -->
<jsp:setProperty property="*" name="vo" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>


<%
	int no = Integer.parseInt(request.getParameter("no"));
BbsDAO dao = new BbsDAO();
boolean result = dao.delete(no);
%>


<!DOCTYPE html>
<html>
<head>
<!-- jQeury -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- css -->
<link href="../css/main.css" rel="stylesheet" type="text/css">
<!-- boottrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function goTop() {
		$('html').scrollTop(0);
	}
</script>

<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>2차-6조 게시판</title>




</head>
<body>


	<jsp:include page="../layout/head.jsp"></jsp:include>


	<div class="row">
		<!-- left 사이드 레이아웃 일단 사용x -->
		<div class="column side">
			<h2></h2>
		</div>

		<!-- 메인 공지사항 게시판 영역 -->
		<div class="column middle">
			<article>

				<div class="container" role="main">

					<h3 align="center">게시판</h3>
					<table class="table text-center">
						<!-- table head -->
						<thead>

							<tr>
								<th>삭제가 완료되었습니다.</th>

							</tr>
						</thead>
					</table>
					<br>
					<div align="center">

						<a href="main-bbs.jsp"><button type="button"
								class="btn btn btn-dark">게시글목록</button></a> <a href="write-bbs.jsp"><button
								type="button" class="btn btn btn-dark">글쓰기</button></a>

					</div>
				</div>

			</article>
		</div>





		<!-- right 사이드 레이아웃 일단 사용x -->
		<div class="column side">
			<h2></h2>
		</div>
	</div>

	<jsp:include page="../layout/foot.jsp"></jsp:include>


</body>
</html>