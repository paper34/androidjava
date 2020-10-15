<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웰컴제주</title>

</head>
<body>


<header id="header" class="fixed-top">

<%if(session.getAttribute("id")!=null) {%> <!-- 세션이 있다 로그인 상태 -->
	<div class="header">
		<!-- 기본 레이아웃 -->
		<font style="font-size: 15px; font-weight: bold; color: white; position: relative; left: 400px">
		<%if(session.getAttribute("kakao")!=null) {%>
		<%= session.getAttribute("kakao") %>
		<%}else{ %>
		<%= session.getAttribute("id") %>
		<%} %>
		</font>
		<a
			style="font-size: 15px; text-decoration: none; color: white; position: relative; left: 400px"
			href="../join/logout.jsp">　│　로그아웃　</a>	
			
	</div>

		
<%}else{ %>
		<div class="header">

	<a
			style="font-size: 15px; text-decoration: none; color: white; position: relative; left: 400px"
			href="../join/login.jsp">　로그인</a>
		
		<a
			style="font-size: 15px; text-decoration: none; color: white; position: relative; left: 400px"
			href="../join/join.jsp">　│　회원가입　</a>	
			
	</div>
	
<%} %>

	<!-- 상단 네비 메뉴 버튼-->
	<nav class="navbar navbar-expand bg-white navbar-white"
		style="border-bottom: 1px solid lightgray;">
		<!-- Brand -->
		<!-- left: 350px" -->
		<a class="navbar-brand" href="#"
			style="position: relative; left: 480px"><img alt="메인홈"
			src="../img/home.png" href="../index.jsp"></a>

		<!-- Links -->
		<ul class="navbar-nav"
			style="width: 100%; position: relative; list-style: none; left: 23%;">

			<!-- Dropdown -->
			<!-- left: 120px;" -->
			<li class="nav-item dropdown"
				style="position: relative; left: 150px;"><a
				class="nav-link dropdown-toggle" href="#" id="navbardrop"
				style="color: black; font-weight: bold; font-size: 18px"
				data-toggle="dropdown"> 관광지 </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="../main/index.jsp">전체</a>
				</div></li>


			<!-- Dropdown -->
			<!-- left: 120px;" -->
			<li class="nav-item dropdown"
				style="position: relative; left: 270px;"><a
				class="nav-link dropdown-toggle" href="#" id="navbardrop"
				style="color: black; font-weight: bold; font-size: 18px"
				data-toggle="dropdown"> 여행필수정보 </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="../bbs/main-bbs.jsp">공지</a>
						
				</div></li>


		<!-- 로그인시 접근 가능한 메뉴 -->
			<!-- left: 120px;" -->
			<li class="nav-item dropdown"
				style="position: relative; left: 390px;"><a
				class="nav-link dropdown-toggle" href="#" id="navbardrop"
				style="color: black; font-weight: bold; font-size: 18px"
				data-toggle="dropdown"> 나의여행 </a> 
				<div class="dropdown-menu">
					<%if(session.getAttribute("id")!=null) {%> <!-- 세션이 있다 로그인 상태 -->
					<a class="dropdown-item" href="../myinfo/myinfo.jsp">정보수정</a> 
					<a class="dropdown-item" href="../myinfo/myjeju.jsp">찜한여행지</a>
					<a class="dropdown-item" href="../purchase/cart.jsp">장바구니</a>
					<%}else{ %> <!-- 세션끊김 로그아웃 상태 --> 
					<a class="dropdown-item" href="../join/login.jsp" onclick="alert('로그인이 필요한 페이지 입니다')">정보수정</a> 
					<a class="dropdown-item" href="../join/login.jsp" onclick="alert('로그인이 필요한 페이지 입니다')">찜한여행지</a>
					<a class="dropdown-item" href="../purchase/cart.jsp">장바구니</a>
					<%} %>
				</div></li>



		
		</ul>
	</nav>

	<!-- 아이콘 -->
	</header>
	
	
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
</body>
</html>