<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="resources/js/out.css">
<script type="text/javascript" src="resources/js/jquery-3.5.1.js"></script>

<script type="text/javascript">
	// 제이쿼리 쓸때는 functuon을 열어주고 그안에 코드 - 펑션 준비
	// $(document).ready 같은거 

	$(function() {
		//alert("환영합니다");
		$('#b1').click(function() {
			replyValue = $('#reply').val();
			$.ajax({
				url : "reply.do",
				data : {
					reply : replyValue
				},
				success : function(result) {
					alert(result)
					$('#d1').append(result);
				}
			})
			
			
		})
		
		$('#b2').click(function() {
			idValue = $('#id').val();
			$.ajax({
				url : "id.do",
				data : {
					id : idValue
				},
				success : function(id) {
					//alert(result)
					
					$('#d1').empty();
					$('#d1').append(id);
					
					
					
					
				}
			})
			
			
		})
		
		
		
	})
</script>
<title>Insert title here</title>
</head>
<body>
	${ param.movie}
	<!-- 값을 이전페이지에서 가져오기 -->
	<form action="movie.do">
		영화제목 <select name="title" id="title">
			<option id="t1">터넷</option>
			<option id="t2">아이어맨</option>
			<option id="">짱구 극장판</option>
		</select> 가격입력: <input name="price" type="text">
		<button type="submit">확인</button>
	</form>

	<hr color="red">
	댓글:
	<input type="text" id="reply">

	
	<button id="b1">댓글달기</button>

	<hr color="blue">
	
	
	id <input type="text" id="id"> <button id="b2">확인</button>
	
	<div id="d1"></div>
</body>
</html>