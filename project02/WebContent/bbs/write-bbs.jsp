<%@page import="bean.BbsDAO"%>
<%@page import="java.util.List"%>
<%@page import="bean.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
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
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>2차-6조 게시판</title>

<!-- 자바스크립트 -->
<script type="text/javascript">
	function goTop() {
		$('html').scrollTop(0);
	}
</script>


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

					<h2 align="center" style="font-weight: bold;">게시글 작성</h2>
					<br>
					
					<form name="form" id="form" role="form" method="post"
						action="write-bbs2.jsp" autocomplete="off">

						<div class="mb-3">

							<label for="title">제목</label> <input type="text"
								class="form-control" name="title" id="title"
								placeholder="제목을 입력해 주세요">

						</div>



						<div class="mb-3">

							<!-- <label for="reg_id">작성자</label>  --><input type="hidden"
								class="form-control" name="writer" id="writer" value="<%=session.getAttribute("id") %>"
								placeholder="이름을 입력해 주세요"> 

						</div>



						<div class="mb-3">

							<label for="content">내용</label>

							<textarea class="form-control" rows="5" name="content" style="height:500px; resize: none"
								id="content" placeholder="내용을 입력해 주세요"></textarea>

						</div>


						<div>

							<button type="submit" class="btn btn btn-dark" id="btnSave"
								onclick="check()">저장</button>

							<a href="main-bbs.jsp"><button type="button"
									class="btn btn btn-dark" id="btnList">취소</button></a>

						</div>
					</form>

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