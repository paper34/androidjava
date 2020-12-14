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
	
	<jsp:include page="../../../../layout.jsp"></jsp:include>
	
	<div class="nice-nav" style="width: 200px">
		<div class="user-info clear" style="border-bottom: 1px solid white;">
			<div class="user-name" >
				<h5 style="color: white; margin-left:5px ;font-weight: bold; font-size: 20px;" class="fas fa-user-alt">
				 My Profile</h5>
			</div>
		</div>
		<div class="clear"></div>
		
		<ul style="list-style: none; ; margin-top: 20px">
			<li style="font-weight: bold; margin-top: 10px"><a href="<c:url value="/user/profile/myprofile_onSale.jsp" />" class="fas fa-caret-right"> 판매 중인 상품</a></li>
			<li style="font-weight: bold; margin-top: 10px"><a href="<c:url value="/user/profile/myprofile_buy.do?user_id=${user_id}"/>" class="fas fa-caret-right"> 구매한 상품</a></li>
			<li style="font-weight: bold; margin-top: 10px"><a href="<c:url value="/user/profile/myprofile_sold.jsp" />" class="fas fa-caret-right"> 판매한 상품</a></li>
			<li style="font-weight: bold; margin-top: 10px"><a href="<c:url value="/user/profile/myprofile_zzim.do?user_id=${user_id}" />" class="fas fa-caret-right"> 내가 찜한 상품</a></li>
			<li style="font-weight: bold; margin-top: 10px"><a href="<c:url value="/user/profile/myprofile_review.do?user_id=${user_id}" />" class="fas fa-caret-right"> 내 매너평가</a></li>
			<li style="font-weight: bold; margin-top: 10px"><a href="<c:url value="/user/q&a/question_report.jsp " />"
				onClick="window.open(this.href, '', 'width=620, height=620'); return false;" class="fas fa-caret-right"> 신고/문의</a></li>
			<li style="font-weight: bold; margin-top: 10px"><a href="<c:url value="/user/q&a/question_bbs.jsp " />"
				onClick="window.open(this.href, '', 'width=1200, height=1000'); return false;" class="fas fa-caret-right"> Q&A게시판</a></li>
		</ul>
	</div>
	<div class="body-part"></div>
	
	<!-- 판매중인상품 db연결 테이블 -->
	&nbsp;&nbsp;&nbsp;<h3 class="fas fa-chevron-circle-right" style="color: #9ad3bc;"> 내가 찜한 상품</h3><br>
	
	
	
	<table class="table table-bordered text-center"
		style="width: 1200px; margin-top: 50px; margin-left: 300px" >
		<!-- table head -->
		<thead>
			<tr  class="table-info" style="height: 50px; font-size: 20px; color: white">
				<th width="35%">상품명</th>
				<th width="8%">판매가</th>
				<th width="15%">카테고리</th>
			</tr>
		</thead>
	
	<c:forEach items="${zzim}" var="vo">
		<tbody style="font-size: 15px">
			<tr style="height: 30px; font-size: 14px;"class="table-light" >
				<!-- 제목 -->
				<th>${vo.product_title}</th>
				<!-- 판매가 -->
				<th>${vo.product_price}원</th>
				<!-- 카테고리 -->
				<th>${vo.product_category}</th>
		</tbody>
	</c:forEach>	
	</table>

	
	<h4 style="margin-top: 100px; font-weight: bold; color: black" align="center">${user_id}님 찜한목록의 상품추천입니다.</h4><br>

	
	<c:forEach items="${algolist}" var="algo" end="8">
		<div style="float: left; width: 172px; height: 260px ;margin-left: 150px; margin-top: 10px" >
			<img src="<c:url value="/resources/img/${algo.product_image}"/> " width="170px" height="170px" style="display: inline;" >  <br>
			<p style="color: black; font-weight: bold;">${algo.product_title}</p>
			<p style="color: black; font-weight: bold;">${algo.product_price}원</p>
			<p style="color: black; font-weight: bold;">${algo.product_category}</p>
		</div>
	</c:forEach>
	
	
	
</body>
</html>