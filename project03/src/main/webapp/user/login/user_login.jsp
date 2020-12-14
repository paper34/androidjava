<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="<c:url value="/resources/js/jquery-3.5.1.js" />"></script>
<script type="text/javascript">
	$(function() {

		$('#login').click(function() {

			$.ajax({
				url : "../../user/login/logincheck.do",
				data : {
					user_id : $('#user_id').val(),
					user_pw : $('#user_pw').val()

				},
				success : function(result) {
                    
					if (result == 1) {
						location.href = "../../web_product/index2.jsp"
						return false;
					}  else {
						alert("해당유저는 블랙당했습니다. 블랙해제 전까지 서비스 이용에 제한됩니다.")
					}

				}

			})

		})
	})
</script>

<meta charset="UTF-8">
<title>이조박켓-로그인</title>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>로그인</title>

<!-- Custom fonts for this template-->
<link href="<c:url value="/resources/bootstrap/vendor/fontawesome-free/css/all.min.css" />" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="<c:url value="/resources/bootstrap/css/sb-admin-2.min.css" />" rel="stylesheet">
</head>

<body class="bg-gradient-primary">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-10 col-lg-12 col-md-9">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<!-- Nested Row within Card Body -->
						<div class="row">
							<div><img alt="" src="../../resources/img/login.jpg" style="width: 450px" height="500px" ></div>
							<div class="col-lg-6">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-4">Login</h1>
									</div>

										<!-- 아이디 입력 -->
										<div class="form-group">
											<input type="text" class="form-control form-control-user" id="user_id"
											 name="user_id" aria-describedby="emailHelp" placeholder="Enter ID">
										</div>
										
										<!-- 비밀번호 입력 -->
										<div class="form-group">
											<input type="password" class="form-control form-control-user"
											 id="user_pw" name="user_pw" placeholder="Password">
										</div>

										<button type="button" class="btn btn-primary btn-user btn-block" id="login">Login</button>

									<hr>
									
									<!-- 하단 링크 이동 -->
									<div>
										<a href="user_join.jsp" class="btn btn-google btn-user btn-block">
											<i class="fa fa-edit"></i> Join up
										</a>
										
										<a href="../../web_product/index2.jsp" class="btn btn-facebook btn-user btn-block">
											<i class="fa fa-home"></i> MainHome
										</a>
									</div>

									<hr>
									<div class="text-center"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<script src="<c:url value="/resources/bootstrap/vendor/jquery/jquery.min.js" />"></script>
	
	<script src="<c:url value="/resources/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>

	<script src="<c:url value="/resources/bootstrap/vendor/jquery-easing/jquery.easing.min.js" />"></script>

	<script src="<c:url value="/resources/bootstrap/js/sb-admin-2.min.js" />"></script>

</body>
</html>