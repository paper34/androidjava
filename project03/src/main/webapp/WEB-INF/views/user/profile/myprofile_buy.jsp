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
<title>구매한 상품</title>
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
		
		<ul style="list-style: none; margin-top: 20px">

			<li style="font-weight: bold; margin-top: 10px"><a href="<c:url value="/user/profile/myprofile_onSale.jsp" />" class="fas fa-caret-right"> 판매 중인 상품</a></li>
			<li style="font-weight: bold; margin-top: 10px"><a href="javascript:location.reload()"  class="fas fa-caret-right"> 구매한 상품</a></li>
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
	&nbsp;&nbsp;&nbsp;<h3 class="fas fa-chevron-circle-right" style="color: #9ad3bc;"> 구매한 상품</h3><br>
	
	<table class="table table-bordered text-center"  style="width: 1200px; position: relative; left: 150px ">
		<thead>
			<tr class="table-info" style="height: 50px; font-size: 20px; color: white">
				<th width="25%">상품명</th>
				<th width="8%">판매가</th>
				<th width="10%">등록일</th>
				<th width="15%">배송상태</th>
				<th width="8%">매너평가</th>
			</tr>
		</thead>

			<tbody style="font-size: 15px">
		<c:forEach items="${list}" var="vo">

				<tr style="height: 30px; font-size: 14px;"class="table-light" >
					<!-- 제목 -->
					<th>${vo.product_title}</th>
					<!-- 판매가 -->
					<th>${vo.payment_price}원</th>
					<!-- 작성일 -->
					<th>${vo.payment_date}</th>
					<!-- 카테고리 -->

					<c:choose>

						<c:when test="${vo.payment_delivery == '1'}">
							<c:set var="service" value="배송완료"></c:set>
						</c:when>

						<c:otherwise>
							<c:set var="service" value="배송중"></c:set>
						</c:otherwise>

					</c:choose>

					<th>${service}</th>
					
					<th>
						<a href="<c:url value="/user/profile/myprofile_estimate.do?payment_id=${vo.payment_id}" />">
							<button class="btn btn-dark btn-sm">매너평가</button>
						</a>
					</th>
		</c:forEach>
		</tbody>


	</table>
</body>
</html>