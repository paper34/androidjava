<%@page import="bean.BbsDAO"%>
<%@page import="bean.BbsVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
<title>공지/이벤트</title>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".clickable-row").click(function() {
			window.location = $(this).data("href");

		});
	});

	function goTop() {
		$('html').scrollTop(0);
	}
</script>
</head>
<body>


	<jsp:include page="../layout/head.jsp"></jsp:include>

	<%
		int pageNumber = 1;
	if (request.getParameter("pageNumber") != null) {
		pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
	}
	%>




	<div class="row">
		<!-- left 사이드 레이아웃 일단 사용x -->
		<div class="column side">
			<h2></h2>
		</div>


		<!-- 메인 공지사항 게시판 영역 -->
		<div class="column middle">
			<h3 align="center" style="font-weight: bold;">공지사항</h3>
			<br>
			<p align="center">제주웰컴 관광정보 사이트 공지사항 입니다. </p>
			<br>
			<table class="table table-hover text-center" id="click">
				<!-- table head -->
				<thead>
					<tr>
						<th width="10%">글번호</th>
						<th width="55%">제목</th>
						<th width="10%">작성자</th>
						<th width="15%">작성일</th>
						<th width="10%">조회수</th>
					</tr>
				</thead>

				<!-- table body - 게시글-->
				<tbody style="font-size: 15px">
					<!-- db에서 테이블 목록을 가져옴 -->
					<%
					BbsDAO d = new BbsDAO();
					BbsVO vo = new BbsVO();
					ArrayList<BbsVO> list = d.getList(pageNumber);
					for (int i = 1; i < list.size(); i++) {
					%>

					<tr class='clickable-row'
						data-href='./read-bbs.jsp?no=<%=list.get(i).getNo()%>'>
						<!-- 글번호 -->
						<th><input type="hidden" name="no" id="no" class="no"
							value="<%=list.get(i).getNo()%>"><%=list.get(i).getNo()%></th>
						<!-- 제목 -->
						<th style="text-align: left"><%=list.get(i).getTitle()%></th>
						<!-- 작성자 -->
						<th><%=list.get(i).getWriter()%></th>
						<!-- 작성일 -->
						<th><%=list.get(i).getDay()%></th>
						<!-- 조회수 -->
						<th><input type="hidden" name="count" id="count"
							class="count" value="<%=list.get(i).getCount()%>"><%=list.get(i).getCount()%></th>
					</tr>
					<%
						}
					%>

				</tbody>
			</table>

			<div>
			<!-- 하단 버튼 분리 -->
			<hr>

			<!-- 글쓰기버튼 -->
			<%
				//if logined userID라는 변수에 해당 아이디가 담기고 if not null
				if(session.getAttribute("id") != null) {
					if (session.getAttribute("id").equals("admin") ) {
				
			%>
			
			<!--  <button type="button" onclick="location.href='write-bbs.jsp'" class="btn btn-dark content-right">글쓰기</button>-->
			  <a class="btn btn-dark content-right" href="write-bbs.jsp">글쓰기</a>

			<%
					} else   {
			%>
			  <button type="button" onclick="location.href='write-bbs.jsp'" class="btn btn-dark content-right"
			  style="display: none"
			  >글쓰기</button>
			<%
					}
				}
			%>


			
			</div>



			<!-- 페이지이동 -->
			<div class="text-center">
				<%
					if (pageNumber != 0) {
				%>
				<ul class="pagination justify-content-center" style="margin: 20px 0">
					<li class="page-item"><a class="page-link"
						href="main-bbs.jsp?pageNumber=<%=pageNumber - 1%>">이전</a></li>
					<%
						}
					if (d.nextPage(pageNumber + 1)) {
					%>
					<li class="page-item"><a class="page-link"
						href="main-bbs.jsp?pageNumber=<%=pageNumber + 1%>">다음</a></li>
				</ul>
				<%
					}
				%>
			</div>

			<!-- 게시물 검색 -->
			<!-- "margin-left: 210px"  "margin-left: 280px" -->
			<div class="input-group mb-3">
				<form class="form-inline" action="search-bbs.jsp">
					<input class="from-control" type="text=title" placeholder="검색어"
						size=45 autocomplete="off" maxlength="16"
						style="margin-left: 280px" id="titleinput" name="title">
					<button class="btn btn-dark	" type="submit">검색</button>
				</form>
			</div>
		</div>




		<!-- right 사이드 레이아웃 일단 사용x -->
		<div class="column side">
			<h2></h2>
		</div>
	</div>


	<jsp:include page="../layout/foot.jsp"></jsp:include>





</body>
</html>