<%@page import="bean.BbsDAO"%>
<%@page import="java.util.List"%>
<%@page import="bean.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>


<%
	int no = Integer.parseInt(request.getParameter("no"));
// 해당 게시물 클릭 시 게시물번호 기준으로 정보를 불러오기때문에 no를 int로 형변환
BbsDAO dao = new BbsDAO(); // 이거는 read dao 생성
BbsVO vo = dao.one(no); // 이것도 read dao 호출

BbsDAO dao1 = new BbsDAO(); // 이게 count 1씩 증가시키는 dao 생성
dao1.count_up(vo); // 호출
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
<script type="text/javascript">
	
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
			<h3 align="center">공지사항</h3>
			<!-- 게시물 내용 -->


			<br>

			<div>
				<table class="table table">
					<thead align="left">

						<tr>
							<td
								style="width: 130px; background-color: whit; font-weight: bold">글번호</td>
							<td id="no"><%=vo.getNo()%></td>
						</tr>

						<tr>
							<td
								style="width: 130px; background-color: whit; font-weight: bold">작성자</td>
							<td><%=vo.getWriter()%></td>
						</tr>
						<tr>
							<td
								style="width: 130px; background-color: whit; font-weight: bold">제목</td>
							<td><%=vo.getTitle()%></td>
						</tr>



						<tr>
							<td
								style="width: 130px; height: 300px; background-color: whit; font-weight: bold; align-content: center;">내용</td>
							<td><%=vo.getContent()%></td>
						</tr>



						<tr>
							<td
								style="width: 130px; background-color: whit; font-weight: bold">작성일</td>
							<td><%=vo.getDay()%></td>
						</tr>

						<tr>
							<td
								style="width: 130px; background-color: whit; font-weight: bold">작성시간</td>
							<td><%=vo.getTime()%></td>
						</tr>

						<tr>
							<td
								style="width: 130px; background-color: whit; font-weight: bold">조회수</td>
							<td><%=vo.getCount()%></td>
						</tr>


					</thead>

				</table>
			</div>
			<div>
				<!-- 하단버튼 -->
				
				<!-- "margin-left: 740px" "margin-left: 540px" -->

				<a href="main-bbs.jsp"><button type="button"
						class="btn btn btn-dark" id="btnList">목록</button></a>


				<!-- 글쓰기버튼 -->
				<%
					//if logined userID라는 변수에 해당 아이디가 담기고 if not null
				if (session.getAttribute("id").equals("admin")) {
				%>

				<button type="button" style="margin-left: 740px"
					class="btn btn btn-dark" id="update"
					onclick="location.href='update-bbs.jsp?no=<%=vo.getNo()%>'">
					수정</button>
				<button type="button" class="btn btn btn-dark" id="delete"
					onclick="location.href='delete-bbs.jsp?no=<%=vo.getNo()%>'">삭제</button>
				<%
					} else {
				%>


				<button type="button" style="margin-left: 740px; display: none"
					class="btn btn btn-dark" id="update"
					onclick="location.href='update-bbs.jsp?no=<%=vo.getNo()%>'">
					수정</button>
				<button type="button" class="btn btn btn-dark" id="delete"
					onclick="location.href='delete-bbs.jsp?no=<%=vo.getNo()%>'"
					style="display: none">삭제</button>

				<%
					}
				%>






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