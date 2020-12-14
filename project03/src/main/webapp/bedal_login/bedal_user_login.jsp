<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$(function() {
		
		$('#login').click(function() {
		
			$.ajax({
				url : "../bedal/bedal_user/logincheck.do",
				data : {
					bedal_id : $('#bedal_id').val(),
					bedal_pw : $('#bedal_pw').val()
					
				},
				success : function(result) {
					
					if (result == 1) {
						location.href="../web_product/index2.jsp";
						
						return false;
						
					} else {

						alert("로그인 실패")
						
					}
					
				}
				
			})
			
		})
		
	})
	
	
</script>

<meta charset="UTF-8">
<title>이조박켓-로그인</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>로그인</title>

<!-- Custom fonts for this template-->
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="../resources/bootstrap/css/sb-admin-2.css" rel="stylesheet" type="text/css">
<link href="../resources/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">




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
              <!-- <div class="col-lg-6 d-none d-lg-block bg-login-image"></div> -->
              <div class="col-lg-6"><img src="../resources/img/bedal_login.png" style="width: 450px; height: 450px"></div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">배달회원 Login</h1>
                  </div>
                  
                  
                  	
                    <div class="form-group">
                      <input type="text" class="form-control form-control-user" id="bedal_id" name="bedal_id" aria-describedby="emailHelp" placeholder="Enter ID">
                    </div>
                    <div class="form-group">	
                      <input type="password" class="form-control form-control-user" id="bedal_pw" name="bedal_pw" placeholder="Password">
                    </div>
                     
                    <button type="submit" class="btn btn-primary btn-user btn-block" id="login">Login</button>

                  	
                    <hr>
                    <div>
                    <a href="bedal_join.jsp" class="btn btn-google btn-user btn-block">
                      <i class="fa fa-edit"></i> 배달 Join up
                    </a>
                    <a href="../web_product/index2.jsp" class="btn btn-facebook btn-user btn-block">
                      <i class="fa fa-home"></i> MainHome
                    </a>
                    </div>
                  
                  
                  
                  <hr>
                  
                  <div class="text-center">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="../resources/bootstrap/vendor/jquery/jquery.min.js"></script>
  <script src="../resources/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="../resources/bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="../resources/bootstrap/js/sb-admin-2.min.js"></script>

</body>
</html>