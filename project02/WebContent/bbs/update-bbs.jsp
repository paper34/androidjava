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

BbsDAO dao = new BbsDAO();
BbsVO vo = dao.one(no);
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
<script type="text/javascript">
function goTop(){
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
			<h3 align="center">공지사항</h3>
			<!-- 게시물 내용 -->


			<br>

			<form action="update-bbs2.jsp">
				<div>
					<table class="table table-bordered">
						<thead align="left">

							<tr>
								<td
									style="width: 130px; background-color: whit; font-weight: bold">글번호</td>
								<td><%=vo.getNo()%> <input type="hidden" name="no" id="no"
									class="no" value="<%=vo.getNo()%>" readonly="readonly"></td>
							</tr>

							<tr>
								<td
									style="width: 130px; background-color: whit; font-weight: bold">작성자</td>
								<td><%=vo.getWriter()%> <input type="hidden" name="writer"
									value="<%=vo.getWriter()%>" readonly="readonly"></td>
							</tr>

							<tr>
								<td
									style="width: 130px; background-color: whit; font-weight: bold">제목</td>
								<td><textarea class="form-control" rows="5" name="title"
										style="width: 600px; height: 38px; resize: none;" id="title"
										placeholder="제목을 입력해 주세요"> <%=vo.getTitle()%></textarea></td>
							</tr>


							<tr>
								<td
									style="width: 130px; height: 300px; background-color: whit; font-weight: bold; align-content: center;">내용</td>
								<td><textarea class="form-control" rows="5" name="content"
										style="width: 600px; height: 400px; resize: none;"
										id="content" placeholder="내용을 입력해 주세요"> <%=vo.getContent()%></textarea></td>
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
					<!-- style="margin-left: 630px" "margin-left: 825px" -->
					<button type="submit" style="margin-left: 825px"
						class="btn btn btn-dark" id="update">저장</button>
					<button type="button" class="btn btn btn-dark" id="delete"
						onClick="history.back()">취소</button>

				</div>
			</form>





		</div>





		<!-- right 사이드 레이아웃 일단 사용x -->
		<div class="column side">
			<h2></h2>
		</div>
	</div>
	
	<jsp:include page="../layout/foot.jsp"></jsp:include>

</body>
</html>