<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- boottrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
<body>

	<!-- 태그 사이에 내용(contents)이 비어있음. 빈태그 -->
	<sql:setDataSource url="jdbc:mysql://localhost:3366/project03"
		driver="com.mysql.jdbc.Driver" user="root" password="1234"
		scope="application" var="db" />

	<!-- 리스트불러오기 -->
	<sql:query var="list" dataSource="${db}">
		select * from question where qa_no= ${param.qa_no}
	</sql:query>


	<!-- 메인 공지사항 게시판 영역 -->
	<div class="column middle">
		<h3 align="center" style="font-weight: bold;">신고/문의 내용</h3>
		<!-- 게시물 내용 -->

		<br>

		<div>
			<table class="table table" style="width: 800px; margin-left: 200px">
				<c:forEach items="${list.rows}" var="vo">
					<thead align="left">

						<tr>
							<td style="width: 130px; background-color: whit; font-weight: bold">No.</td>
							<td id="no">${vo.qa_no}</td>
						</tr>

						<c:choose>

							<c:when test="${vo.qa_service == '1'}">
								<c:set var="service" value="유저신고"></c:set>
							</c:when>

							<c:otherwise>
								<c:set var="service" value="문의"></c:set>
							</c:otherwise>

						</c:choose>
						<tr>
							<td
								style="width: 130px; background-color: whit; font-weight: bold">신고사유</td>
							<td>${service}</td>
						</tr>
						<tr>
							<td
								style="width: 130px; background-color: whit; font-weight: bold">제목</td>
							<td>${vo.qa_title}</td>
						</tr>


						<tr>
							<td
								style="width: 130px; height: 200px; background-color: whit; font-weight: bold; align-content: center;">내용</td>
							<td>${vo.qa_content}</td>
						</tr>



						<tr>
							<td
								style="width: 130px; background-color: whit; font-weight: bold">작성일</td>
							<td>${vo.qa_date}</td>
						</tr>

						<tr>
							<td
								style="width: 130px; background-color: whit; font-weight: bold">조회수</td>
							<td>${vo.qa_count}</td>
						</tr>


					</thead>
				</c:forEach>
			</table>
			<br>

			<hr color="black">


			<!-- 태그 사이에 내용(contents)이 비어있음. 빈태그 -->
			<sql:setDataSource url="jdbc:mysql://localhost:3366/project03"
				driver="com.mysql.jdbc.Driver" user="root" password="1234"
				scope="application" var="db" />

			<!-- 리스트불러오기 -->
			<sql:query var="list2" dataSource="${db}">
				select * from admin_question where qa_no= ${param.qa_no}
			</sql:query>

			<sql:update var="update" dataSource="${db}">
				update question set qa_count = qa_count+1 where qa_no = ${param.qa_no}
			</sql:update>

			<table class="table table" style="width: 800px; margin-left: 200px">
				<c:forEach items="${list2.rows}" var="vo2">
			<h3 align="center" style="font-weight: bold;">답변</h3>
					<thead align="left">

						<tr>
							<td
								style="width: 130px; background-color: whit; font-weight: bold">담당인</td>
							<td>관리자 답변</td>
						</tr>
						<tr>
							<td
								style="width: 130px; height: 200px; background-color: whit; font-weight: bold; align-content: center;">답변내용</td>
							<td>${vo2.admin_answer}</td>
						</tr>

						<tr>
							<td
								style="width: 130px; background-color: whit; font-weight: bold"></td>
							<td></td>
						</tr>

					</thead>
				</c:forEach>
			</table>
			<button onClick='window.history.back()' style="margin-left: 1000px"
				class="btn btn-dark">이전</button>
			<button onClick='window.close()' 
				class="btn btn-dark">취소</button>
		</div>
	</div>
</body>
</html>