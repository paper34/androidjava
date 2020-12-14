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

	&nbsp;&nbsp;&nbsp;<h3 class="fas fa-chevron-circle-right" style="color: #9ad3bc;"> 내 매너평가</h3><br>
	<br>


<c:forEach items="${user}" var="vo">
		<h4 class="far fa-grin-alt" style="margin-left: 600px; color: black" > &nbsp;받은 매너 칭찬</h4>
		<div style=" width: 500px; height: 560px; margin-left: 650px; background-color: white">

		<div style="border-bottom: 1px solid lightgray; margin-top: 20px; height: 70px">
			<h5 style="display: inline; font-size: 15px; margin-left: 40px; position: relative; top: 30px; font-weight: bold;">
			시간 약속을 잘지켜요</h5> <h4  class="fas fa-users" style="display: inline; margin-left: 430px; font-weight: bold;">
			 ${vo.review1_count}</h4>
		</div>

		<div style="border-bottom: 1px solid lightgray; margin-top: 20px; height: 50px;  ">
			<h5 style="display: inline; font-size: 15px; margin-left: 40px; font-weight: bold; position: relative; top: 10px;">
			친절하고 좋아요</h5> <h4  class="fas fa-users" style="display: inline; margin-left: 430px; font-weight: bold; position: relative; top: -20px;">
			 ${vo.review2_count}</h4>
		</div>
		
		<div style="border-bottom: 1px solid lightgray; margin-top: 20px; height: 50px">
			<h5 style="display: inline; font-size: 15px; margin-left: 40px; font-weight: bold; position: relative; top: 10px;">
			응답이 빨라요</h5> <h4  class="fas fa-users" style="display: inline; margin-left: 430px; font-weight: bold; position: relative; top: -20px;">
			 ${vo.review3_count}</h4>

		</div>

		<div style="border-bottom: 1px solid lightgray; margin-top: 20px; height: 50px">
			<h5 style="display: inline; font-size: 15px; margin-left: 40px; font-weight: bold; position: relative; top: 10px;">
			제가 있는 곳까지 와서 거래했어요</h5> <h4 class="fas fa-users"  style="display: inline; margin-left: 430px; font-weight: bold; position: relative; top: -20px;">
			 ${vo.review4_count}</h4>
		</div>

		<div style="border-bottom: 1px solid lightgray; margin-top: 20px; height: 50px">
			<h5 style="display: inline; font-size: 15px; margin-left: 40px; font-weight: bold; position: relative; top: 10px;">
			상품설명이 자세해요</h5> <h4  class="fas fa-users" style="display: inline; margin-left: 430px; font-weight: bold; position: relative; top: -20px;">
			 ${vo.review5_count}</h4>
		</div>
		
		<div style="border-bottom: 1px solid lightgray; margin-top: 20px; height: 50px">
			<h5 style="display: inline; font-size: 15px; margin-left: 40px; font-weight: bold; position: relative; top: 10px;">
			상품상태가 설명한 것과 같아요</h5> <h4  class="fas fa-users" style="display: inline; margin-left: 430px; font-weight: bold; position: relative; top: -20px;">
			 ${vo.review6_count}</h4>
		</div>

		<div style="border-bottom: 1px solid lightgray; margin-top: 20px; height: 50px">
			<h5 style="display: inline; font-size: 15px; margin-left: 40px; font-weight: bold; position: relative; top: 10px;">
			좋은 상품을 저렴하게 판매해요</h5> <h4  class="fas fa-users" style="display: inline; margin-left: 430px; font-weight: bold; position: relative; top: -20px;">
			 ${vo.review7_count}</h4>
		</div>

		<div style="border-bottom: 1px solid lightgray; margin-top: 20px; height: 50px">
			<h5 style="display: inline; font-size: 15px; margin-left: 40px; font-weight: bold; position: relative; top: 10px;">
			무료로 나눠주셨어요</h5> <h4 style="display: inline; margin-left: 430px; font-weight: bold; position: relative; top: -20px;" class="fas fa-users">
			 ${vo.review8_count}</h4>
		</div>

	</div>
</c:forEach>
</body>
</html>