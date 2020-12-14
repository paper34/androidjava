<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A 게시판</title>
</head>
<!-- boottrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<link href="resources/css/myprofileCSS.css" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.5.1.js" />"></script>

<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".clickable-row").click(function() {
			window.location = $(this).data("href");

		});
	});
</script>
<body>

	<!-- 태그 사이에 내용(contents)이 비어있음. 빈태그 -->
	<sql:setDataSource url="jdbc:mysql://localhost:3366/project03"
		driver="com.mysql.jdbc.Driver" user="root" password="1234"
		scope="application" var="db" />

	<!-- 리스트불러오기 -->
	<sql:query var="list" dataSource="${db}">
		select * from question where user_id= '${user_id}'
	</sql:query>

	<h1 style="font-weight: bold;" align="center">Q&A게시판</h1>
	
	<table class="table table-hover text-center"
		style="width: 1200px; margin-top: 50px; margin-right: 60px;">
		<!-- table head -->
		<thead>
			<tr class="table-warning">
				<th width="10%">No.</th>
				<th width="10%">신고사유</th>
				<th width="30%">제목</th>
				<th width="10%">등록일</th>
				<th width="5%" align="center">조회수</th>
				<th width="15%">처리결과</th>
			</tr>
		</thead>

		<c:forEach items="${list.rows}" var="vo" varStatus="status">

			
			<!-- table body - 게시글-->
			<tbody style="font-size: 15px">
				<tr class='clickable-row' data-href="question_detail.jsp?qa_no=<c:out value="${vo.qa_no}"/>">
					<!-- 번호 -->
					<th>${status.index + 1}</th>
					<!-- 신고사유 -->
					
					<c:choose>
					
					<c:when test="${vo.qa_service == '1'}">
						<c:set var="service" value="유저신고"></c:set>
					</c:when>
					
					<c:otherwise>
						<c:set var="service" value="문의"></c:set>
					</c:otherwise>
					
					</c:choose>
					
					<c:choose>
					
					<c:when test="${vo.qa_status == '0'}">
						<c:set var="status" value="N"></c:set>
					</c:when>
					
					<c:otherwise>
						<c:set var="status" value="Y"></c:set>
					</c:otherwise>
					
					</c:choose>
					
					<th>${service}</th>
					<!-- 제목 -->
					<th>${vo.qa_content}</th>
					<!-- 등록일 -->
					<th>${vo.qa_date}</th>
					<%-- ${vo.product_date} --%>
					<th>${vo.qa_count}</th>
					<%-- ${vo.product_date} --%>
					<!-- 삭제 -->
					<th>${status}</th>
			</tbody>

		</c:forEach>

	</table>
</body>
</html>