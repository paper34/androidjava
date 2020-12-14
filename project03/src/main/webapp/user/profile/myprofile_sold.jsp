<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<!-- boottrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link href="<c:url value="/resources/css/myprofileCSS9.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.5.1.js" />"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//menu left toggle

		$('.toggle-nav').click(function() {
			// alert('done');
			$this = $(this);
			$nav = $('.nice-nav');
			//$nav.fadeToggle("fast", function() {
			//  $nav.slideLeft('250');
			//  });

			$nav.toggleClass('open');

		});
		$('.body-part').click(function() {
			$nav.addClass('open');
		});
		//  $nav.addClass('open');

		//drop down menu
		$submenu = $('.child-menu-ul');
		$('.child-menu .toggle-right').on('click', function(e) {
			e.preventDefault();
			$this = $(this);
			$parent = $this.parent().next();
			// $parent.addClass('active');
			$tar = $('.child-menu-ul');
			if (!$parent.hasClass('active')) {
				$tar.removeClass('active').slideUp('fast');
				$parent.addClass('active').slideDown('fast');

			} else {
				$parent.removeClass('active').slideUp('fast');
			}

		});

	});
</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<jsp:include page="../../layout.jsp"></jsp:include>
	
	<div class="nice-nav" style="width: 200px">
		<div class="user-info clear" style="border-bottom: 1px solid white;">
			<div class="user-name">
				<h5 style="color: white; margin-left:5px ;font-weight: bold; font-size: 20px;" class="fas fa-user-alt">
				 My Profile</h5>
			</div>
		</div>
		<div class="clear"></div>
		<ul style="list-style: none; margin-top: 20px">
			<!-- 좌측 링크이동 -->
			<li style="font-weight: bold; margin-top: 10px"><a href="myprofile_onSale.jsp" class="fas fa-caret-right"> 판매 중인 상품</a></li>
			<li style="font-weight: bold; margin-top: 10px"><a href="<c:url value="/user/profile/myprofile_buy.do?user_id=${user_id}"/>" class="fas fa-caret-right"> 구매한 상품</a></li>
			<li style="font-weight: bold; margin-top: 10px"><a href="myprofile_sold.jsp" class="fas fa-caret-right"> 판매한 상품</a></li>
			<li style="font-weight: bold; margin-top: 10px"><a href="<c:url value="/user/profile/myprofile_zzim.do?user_id=${user_id}" />" class="fas fa-caret-right"> 내가 찜한 상품</a></li>
			<li style="font-weight: bold; margin-top: 10px"><a href="<c:url value="/user/profile/myprofile_review.do?user_id=${user_id}" />" class="fas fa-caret-right"> 내 매너평가</a></li>
			<li style="font-weight: bold; margin-top: 10px"><a href="../q&a/question_report.jsp" onClick="window.open(this.href, '', 'width=620, height=620'); return false;" class="fas fa-caret-right"> 신고/문의</a></li>
			<li style="font-weight: bold; margin-top: 10px"><a href="../q&a/question_bbs.jsp" onClick="window.open(this.href, '', 'width=1200, height=1000'); return false;" class="fas fa-caret-right"> Q&A게시판</a></li>
		</ul>
	</div>
	<div class="body-part"></div>
	
	<!-- 판매가 완료된 판매상품테이블 -->
	&nbsp;&nbsp;&nbsp;<h3 class="fas fa-chevron-circle-right" style="color: #9ad3bc;"> 판매한 상품</h3><br>
	<!-- 태그 사이에 내용(contents)이 비어있음. 빈태그 -->
	<sql:setDataSource url="jdbc:mysql://localhost:3366/project03"
	driver="com.mysql.jdbc.Driver" user="root" password="1234"
	scope="application" var="db" />
		
	<!-- 리스트불러오기 -->
	<!-- product_status가 0이면 판매중인상품 1이면 판매완료 상품 -->
	<sql:query var="list" dataSource="${db}">
		select * from product where user_id= '${user_id}' and product_status = '1'
	</sql:query>
	
	<table class="table table-bordered text-center"
		style="width: 900px; margin-top: 100px; display: inline; margin-left: 200px">
		<thead>
			<tr class="table-info" style="height: 50px; font-size: 20px; color: white">
				<th width="35%">상품명</th>
				<th width="8%">판매가</th>
				<th width="10%">등록일</th>
				<th width="15%">카테고리</th>
				<th width="10%">조회수</th>
			</tr>
		</thead>
	
	<c:forEach items="${list.rows}" var="vo">
	
	<%-- <fmt:parseDate value="${vo.product_date}" var="parseDate" pattern="yyyy-MM-dd HH:mm"    />
	<fmt:formatDate value="${parseDate}" pattern="yyyy-MM-dd HH:mm" var="formatDate"/> --%>
		<!-- table body - 게시글-->
		<tbody style="font-size: 15px">

			<tr style="height: 30px; font-size: 14px;"class="table-light">
				<!-- 제목 -->
				<th>${vo.product_title}</th>
				<!-- 판매가 -->
				<th>${vo.product_price}원</th>
				<!-- 작성일 -->
				<th>${vo.product_date}</th> <%-- ${vo.product_date} --%>
				<!-- 카테고리 -->
				<th>${vo.product_category}</th>
				<!-- 조회수 -->
				<th>${vo.product_count}</th>
		</tbody>
		
	</c:forEach>	

	</table>
</body>
</html>