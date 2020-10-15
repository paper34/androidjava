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
<link rel="stylesheet" type="text/css" href="main-bbs.css" />


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


	<div class="header">
	<!-- 기본 레이아웃 -->
	
		<a
			style="font-size: 20px; text-decoration: none; color: white; position: relative; left: 400px"
			href="login.jsp">로그인</a>
	</div>


	<!-- 상단 네비 메뉴 버튼-->
	<nav class="navbar navbar-expand bg-white navbar-white"
		style="border-bottom: 1px solid lightgray;">
		<!-- Brand -->
		<!-- left: 350px" -->
		<a class="navbar-brand" href="#"
			style="position: relative; left: 480px"><img alt="메인홈"
			src="../../img/home.png"></a>

		<!-- Links -->
		<ul class="navbar-nav"
			style="width: 100%; position: relative; list-style: none; left: 23%;">

			<!-- Dropdown -->
			<!-- left: 120px;" -->
			<li class="nav-item dropdown"
				style="position: relative; left: 120px;"><a
				class="nav-link dropdown-toggle" href="#" id="navbardrop"
				style="color: black; font-weight: bold; font-size: 18px"
				data-toggle="dropdown"> 관광지 </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">Link 1</a> <a
						class="dropdown-item" href="#">Link 2</a> <a class="dropdown-item"
						href="#">Link 3</a>
				</div></li>

			<!-- Dropdown -->
			<!-- left: 120px;" -->
			<li class="nav-item dropdown"
				style="position: relative; left: 200px;"><a
				class="nav-link dropdown-toggle" href="#" id="navbardrop"
				style="color: black; font-weight: bold; font-size: 18px"
				data-toggle="dropdown"> 관광지 </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">Link 1</a> <a
						class="dropdown-item" href="#">Link 2</a> <a class="dropdown-item"
						href="#">Link 3</a>
				</div></li>

			<!-- Dropdown -->
			<!-- left: 120px;" -->
			<li class="nav-item dropdown"
				style="position: relative; left: 280px;"><a
				class="nav-link dropdown-toggle" href="#" id="navbardrop"
				style="color: black; font-weight: bold; font-size: 18px"
				data-toggle="dropdown"> 관광지 </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">Link 1</a> <a
						class="dropdown-item" href="#">Link 2</a> <a class="dropdown-item"
						href="#">Link 3</a>
				</div></li>

			<!-- Dropdown -->
			<!-- left: 120px;" -->
			<li class="nav-item dropdown"
				style="position: relative; left: 360px;"><a
				class="nav-link dropdown-toggle" href="#" id="navbardrop"
				style="color: black; font-weight: bold; font-size: 18px"
				data-toggle="dropdown"> 관광지 </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">Link 1</a> <a
						class="dropdown-item" href="#">Link 2</a> <a class="dropdown-item"
						href="#">Link 3</a>
				</div></li>
		</ul>
	</nav>


	<!-- 아이콘 -->
	<div class="icon"></div>



</body>
</html>