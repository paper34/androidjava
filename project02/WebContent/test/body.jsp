<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- boottrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- css -->
<link rel="stylesheet" type="text/css" href="main.css" />


<!-- 스크립 -->
<script type="text/javascript">

function goTop(){
	$('html').scrollTop(0);
}

</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	
	<jsp:include page="head.jsp"></jsp:include>


	<!-- left 레이아웃 사용x -->
	<div class="row">
		<div class="column side">
			<h2></h2>
		</div>



	    <!-- 여기 밑에 div colimn middle에 자신이 한 코드 붙이기 -->
		<!-- 메인 컨텐츠 -->
		<div class="column middle">


		




		</div>






		<!--  right 레이아웃 사용x -->
		<div class="column side">
			<h2></h2>
		</div>
	</div>

	
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>