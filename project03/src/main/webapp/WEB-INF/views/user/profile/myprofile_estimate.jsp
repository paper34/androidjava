<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- boottrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script src="<c:url value="/resources/js/jquery-3.5.1.js" />"></script>
<script type="text/javascript">
	$(function() {
		$("#review1").change(function() {
			if ($("review1").is(":checked")) {
				$("#review1_count").val('0')
			} else {
				$("#review1_count").val('1')
			}
		})
		
		$("#review2").change(function() {
			if ($("review2").is(":checked")) {
				$("#review2_count").val('0')
			} else {
				$("#review2_count").val('1')
			}
		})
		
		$("#review3").change(function() {
			if ($("review3").is(":checked")) {
				$("#review3_count").val('0')
			} else {
				$("#review3_count").val('1')
			}
		})
		
		$("#review4").change(function() {
			if ($("review4").is(":checked")) {
				$("#review4_count").val('0')
			} else {
				$("#review4_count").val('1')
			}
		})
		
		$("#review5").change(function() {
			if ($("review5").is(":checked")) {
				$("#review5_count").val('0')
			} else {
				$("#review5_count").val('1')
			}
		})
		
		$("#review6").change(function() {
			if ($("review6").is(":checked")) {
				$("#review6_count").val('0')
			} else {
				$("#review6_count").val('1')
			}
		})
		
		$("#review7").change(function() {
			if ($("review7").is(":checked")) {
				$("#review7_count").val('0')
			} else {
				$("#review7_count").val('1')
			}
		})
		
		$("#review8").change(function() {
			if ($("review8").is(":checked")) {
				$("#review8_count").val('0')
			} else {
				$("#review8_count").val('1')
			}
		})
		
	})
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="../../../../layout.jsp"></jsp:include>
	
	<h2 style="width: 150px; margin: 0 auto; color: black; font-weight: bold;" >매너 평가</h2>
	
	
			<c:forEach items="${review}" var="vo">
	<form method="post" action= "<c:url value="/user/profile/estimate_update.jsp" />" >
	
	<br>
	
		<div style="border: 1px solid black; width: 500px; margin: auto; height: 550px">
			<input type="hidden" value="${vo.user_id}" name="user_id">
			
			<div style="border-bottom: 1px solid lightgray; margin-top: 20px;">
				<h5 style="display: inline; font-size: 15px; margin-left: 40px; color: black; font-weight: bold;">
				시간 약속을 잘지켜요</h5>
				
				<input type="checkbox" style="margin-left: 460px; position: relative; top: -20px;" name="review1" id="review1">
				<input type="hidden" name="review1_count" id="review1_count">
			</div>
			
			
			<div style="border-bottom: 1px solid lightgray; margin-top: 20px;">
				<h5 style="display: inline; font-size: 15px; margin-left: 40px; color: black; font-weight: bold;">
				친절하고 좋아요</h5>

				<input type="checkbox" style="margin-left: 460px; position: relative; top: -20px" name="review2" id="review2">
				<input type="hidden" name="review2_count" id="review2_count" >
			</div>
			
			
			<div style="border-bottom: 1px solid lightgray; margin-top: 20px;">
				<h5 style="display: inline; font-size: 15px; margin-left: 40px;color: black; font-weight: bold;">
				응답이 빨라요</h5>

				<input type="checkbox" style="margin-left: 460px; position: relative; top: -20px" name="review3" id="review3">
				<input type="hidden" name="review3_count" id="review3_count" >
			</div>
			
			<div style="border-bottom: 1px solid lightgray; margin-top: 20px;">
				<h5 style="display: inline; font-size: 15px; margin-left: 40px; color: black; font-weight: bold;">
				제가 있는 곳까지 와서 거래했어요</h5>

				<input type="checkbox" style="margin-left: 460px; position: relative; top: -20px" name="review4" id="review4">
				<input type="hidden" name="review4_count" id="review4_count" >
			</div>
			
			
			<div style="border-bottom: 1px solid lightgray; margin-top: 20px;">
				<h5 style="display: inline; font-size: 15px; margin-left: 40px; color: black; font-weight: bold;">
				상품설명이 자세해요</h5>

				<input type="checkbox" style="margin-left: 460px; position: relative; top: -20px" name="review5" id="review5">
				<input type="hidden" name="review5_count" id="review5_count">
			</div>
			
			
			<div style="border-bottom: 1px solid lightgray; margin-top: 20px;">
				<h5 style="display: inline; font-size: 15px; margin-left: 40px; color: black; font-weight: bold;">
				상품상태가 설명한 것과 같아요</h5>

				<input type="checkbox" style="margin-left: 460px; position: relative; top: -20px" name="review6" id="review6">
				<input type="hidden" name="review6_count" id="review6_count" >
			</div>
			
			<div style="border-bottom: 1px solid lightgray; margin-top: 20px;">
				<h5 style="display: inline; font-size: 15px; margin-left: 40px; color: black; font-weight: bold;">
				좋은 상품을 저렴하게 판매해요</h5>

				<input type="checkbox" style="margin-left: 460px; position: relative; top: -20px" name="review7" id="review7">
				<input type="hidden" name="review7_count" id="review7_count" >
			</div>
			
			
			<div style="border-bottom: 1px solid lightgray; margin-top: 20px;">
				<h5 style="display: inline; font-size: 15px; margin-left: 40px; color: black; font-weight: bold;">
				무료로 나눠주셨어요</h5>

				<input type="checkbox" style="margin-left: 460px; position: relative; top: -20px" name="review8" id="review8">
				<input type="hidden" name="review8_count" id="review8_count" >
			</div>
			
			
			<input type="submit" value="거래 매너평가 완료" class="btn btn-dark" style="position: relative; left: 100px; height: 40px; width: 300px; top: 25px">
				
				
		</div>
	</form>
		</c:forEach>
	
</body>
</html>