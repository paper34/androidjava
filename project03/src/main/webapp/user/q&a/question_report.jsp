<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="<c:url value="/resources/js/jquery-3.5.1.js" />"></script>
<script type="text/javascript">
	function doOpenCheck(chk) {
		var obj = document.getElementsByName("qa_service");
		for (var i = 0; i < obj.length; i++) {
			if (obj[i] != chk) {
				obj[i].checked = false;
			}
		}
	}

	
	$(function() {

		//닉네임임체크
		function titlecheck() {
			if ($('#qa_title').val().length == 0)
				return false;
			else
				return true;
		}

		//닉네임임체크
		function contentcheck() {
			if ($('#qa_content').val().length == 0)
				return false;
			else
				return true;
		}

		$('#qa_service1').change(function() {
			
			$('#d1').html(" 신고 유저ID: <input type='text' name='report_id' id='report_id' placeholder='User ID'>")
			
			
		})
		
		
		$('#qa_service').change(function() {
			
			$('#d1').html(" ")
			
			
		})
		
		
		
		$('#report').click(function() {

			if (titlecheck() && contentcheck() == true) {
				document.form.submit();
				return false;
			}

		})
		
		
	})
</script>
<meta charset="UTF-8">
<title>신고 / 문의</title>

</head>
<body>


	${user_id}

	<form action="<c:url value="/user/q&a/report_success.do"/>" name="form" id="form" role="form"
		method="post">

		<input type="hidden" value="${user_id}" name="user_id" placeholder="">
		
		<input type="hidden" value="${qa_no}">
		
		<div
			style="border: 1px solid gray; width: 200px; padding: 20px 30px; text-align: center; float: left; margin-left: 30px">
			<input type="checkbox" id="qa_service1" name="qa_service"
				onclick="doOpenCheck(this);" value="1">유저신고<br>
			<p style="font-size: 10px">사이트 오류, 상품/판매상품 신고 접수</p>
		</div>
		
		
		
		<div
			style="border: 1px solid gray; width: 200px; padding: 20px 30px; text-align: center; float: left;">
			<input type="checkbox" id="qa_service" name="qa_service"
				onclick="doOpenCheck(this);" value="0">문의<br>
			<p style="font-size: 10px">서비스 이용 문의</p>
		</div>
		<br>
		<br>
		<br>
		<br>
		<h6 style="color: blue">*사이트 오류, 상품/판매점 신고 접수를 받습니다.</h6>

		
		<div id="d1">
		
		
		</div>
		
		<div id="d2"></div><br>
		
		
		<div>
			<p>제목</p>
			<input type="text" id="qa_title" name="qa_title"
				placeholder="제목을 작성해주세요" style="width: 560px; height: 20px">
		</div>

		<br>
		<div>
			<p>내용 (필수)</p>
			<textarea id="qa_content" name="qa_content" placeholder="내용을 작성해주세요"
				style="width: 560px; height: 150px; resize: none"></textarea>
		</div>
		<br>
		<button type="button" id="report" style="margin-left: 270px"
			onsubmit="return false">접수하기</button>
		<br>
		<br>
	</form>

	<button onClick='window.close()' style="margin-left: 500px" >취소</button>
</body>
</html>