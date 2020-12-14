<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<!-- Custom fonts for this template-->

<!-- Custom styles for this template-->
<
 <!-- bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> 

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css"> 
	<style type="text/css">
	#adminmenubox{
	position : absolute;
	width : 460px;
	height : 300px;
	text-align : center;
	top : 42%;
	left : 50%;
	transform : translate(-50%, -50%);
	}
	.menu {
	height : 140px;
	width : 140px;
	border-radius : 20%;
	background-color : #888888;
	opacity : 1;
	transition : 0.3s;
	}
	.menu:hover {
	opacity : 0.6;
	}
	.title-menu {
	text-align : center;
	line-height : 140px;
	color : black;
	font-size : large;
	font-weight : bold;
	}
	.title-menu:hover {
	text-decoration : none;
	color : black;
	}
	.container-fluid img {
	position : absolute; top:0; left:0;
	width : 100%;
	height : 780px;
	opacity : 0.75;
	}
	</style>
</head>

<body>
	<!-- <nav class="navbar navbar-inverse navbar-fixed-top">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</nav> -->
<div class="container-fluid" style="min-height: 730px; width:100%; float:none; margin:0 auto">
	<img src="../resources/images/bedalimage.jpg" height="733px" width="100%">
	<div id="adminmenubox" class="text-center">
		<div>
		<a class="title-menu" href="../admin/admin_user.do"><div class="menu" style="float:left">관리자 회원<span class="glyphicon glyphicon-user"></span></div></a>
		<a class="title-menu" href="../admin/admin_question.do"><div class="menu" style="float:left; margin-left:20px">관리자 Q/A<span class="glyphicon glyphicon-pencil"></span></div></a>
		<a class="title-menu" href="../admin/admin_bedal.do"><div class="menu" style="float:left; margin-left:20px">배달내역관리<span class="glyphicon glyphicon-ok"></span></div></a>
		</div>
		<div>
		<a class="title-menu" href="../admin/admin_report.do"><div class="menu" style="float:left; margin-left:80px; margin-top:20px; width:150px">관리자 신고내역<span class="glyphicon glyphicon-question-sign"></span></div></a>
		<a class="title-menu" href="../user/login/user_login.jsp"><div class="menu" style="float:left; margin-left:20px; margin-top:20px">홈<span class="glyphicon glyphicon-home"></span></div></a>
		</div>
	</div>
</div>
	<!-- <div class="footer">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div> -->


<!-- Bootstrap core JavaScript-->
			<script src="../resources/bootstrap/vendor/jquery/jquery.min.js"></script>
			<script src="../resources/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

			<!-- Core plugin JavaScript -->
			<script src="../resources/bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>

			<!-- Custom scripts for all pages -->
			<script src="../resources/bootstrap/js/sb-admin-2.min.js"></script>

			<!-- Page level plugins -->
			<script src="../resources/bootstrap/vendor/chart.js/Chart.min.js"></script> 

			<!-- Page level custom scripts -->
			<script src="../resources/bootstrap/js/demo/chart-area-demo.js"></script>
			<script src="../resources/bootstrap/js/demo/chart-pie-demo.js"></script> 




</body>
</html>