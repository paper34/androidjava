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

<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<!-- css -->
<link rel="stylesheet" type="text/css" href="../css/main.css" />
	
<script type="text/javascript">

function goTop(){
	$('html').scrollTop(0);
}

</script>

<meta charset="UTF-8">
<title>웰컴제주</title>
</head>
<body>


	
	<jsp:include page="../layout/head.jsp"></jsp:include>


	<!-- left 레이아웃 사용x -->

		<div class="column side">
			<h2></h2>
		</div>



	    
<!-- 메인 컨텐츠 
<div class="column middle">-->
<!-- 여기 밑에 div colimn middle에 자신이 한 코드 붙이기 -->
메인컨텐츠



<!--</div> column middle 끝  -->




		<!--  right 레이아웃 사용x -->
<div class="column side"></div>

<jsp:include page="../layout/foot.jsp"></jsp:include>
</body>
</html>