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
<link rel="stylesheet" type="text/css" href="../css/join.css">
	
<script type="text/javascript">

function goTop(){
	$('html').scrollTop(0);
}

</script>

<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>


	
	<jsp:include page="../layout/head.jsp"></jsp:include>


	<!-- left 레이아웃 사용x -->

		<div class="column side">
			<h2></h2>
		</div>



	    <!-- 여기 밑에 div colimn middle에 자신이 한 코드 붙이기 -->
		<!-- 메인 컨텐츠 -->
<!-- <div class="column middle"> -->
    <div class="container" id="wrap">
	  <div class="row">
        <div class="col-md-6 col-md-offset-3">
        <form action="loginCheck.jsp" method="post" accept-charset="utf-8" class="form" role="form"> 
        <% if (request.getParameter("error") == null) { %>
        <legend>Login</legend> 
        <% } else { %>
        <legend>Login Failed</legend><font color=red>로그인 정보를 다시 확인해주세요!</font><br>
       
        <% } %>	
        <br>
        <label>아이디</label> 
        <input type="text" maxlength="20" id="id" name="id" value="" class="form-control input-lg" placeholder="ID" autocomplete="off" > 
        <div id=idChk></div> <br>                  
        <label>비밀번호</label> 
        <input type="password" maxlength="16" id="pw" name="pw" value="" class="form-control input-lg" placeholder="Password" autocomplete="off"  >
        <div id=pwChk></div><br>
        <button id="login" class="btn btn-lg btn-primary btn-block signup-btn" type="submit">로그인</button>

        </form>
        <div>       
        </div>
<hr>
<!-- 소셜로그인 -->
<script src = "//developers.kakao.com/sdk/js/kakao.min.js"></script>
<center><a id="kakao-login-btn"></a></center>

<a href="http://developers.kakao.com/logout"></a>
<script type='text/javascript'>
Kakao.init('f822616c9b24d40abe902cf7bbe9c144'); //아까 카카오개발자홈페이지에서 발급받은 자바스크립트 키를 입력함

//카카오 로그인 버튼을 생성합니다. 
 
Kakao.Auth.createLoginButton({ 
    container: '#kakao-login-btn', 
    success: function(authObj) { 
           Kakao.API.request({
 
               url: '/v2/user/me',
               
               success: function(res) {
            	    console.log(res.id);
                    console.log(res.properties['nickname']);//<---- 콘솔 로그에 닉네임 출력(properties에 있는 nickname 접근 
                    var kakaoid = res.id
                    var kakaonickname = res.properties.nickname//으로도 접근 가능 
                    var token = authObj.access_token
          			console.log(kakaonickname)      
                    console.log(authObj.access_token);//<---- 콘솔 로그에 토큰값 출력
                    //$('#kakaoNickName').text(res.properties.nickname)
                    
          //window.location.replace("http://" + window.location.hostname + ( (location.port==""||location.port==undefined)?"":":" + location.port) + "/kakaoCheck.jsp?id="+kakaonickname);
 window.location.replace("kakaoCheck.jsp?id="+kakaonickname+"&kakaoid="+kakaoid); //로그인 성공시 이동페이지
 // 마이페이지 기능을 사용하기 위해서는 db연동이 필요함???
		 
 
 //window.location.replace("loginCheck.jsp?id="+kakaonickname+"token="+token);
                   }
                 })
               },
               fail: function(error) {
                 alert(JSON.stringify(error));                
               }
             });
             // SDK 초기화 여부를 판단합니다.
             console.log(Kakao.isInitialized());
</script>

     </div>
        
        
        </div>
        


</div> <!--wrap  -->

<%--  <div>카카오 아이디 : <span id="kakaoIdentity"></span></div>

    <div>닉네임 : <span id="kakaoNickName"></span></div>
<h1><%= session.getAttribute("id") %>님을 환영합니다.</h1>
    <div>프로필 이미지 : <img id="kakaoProfileImg" src=""/></div>

    <div>썸네일 이미지 : <img id="kakaoThumbnailImg" src=""/></div>

    <br/>

    <a id="kakao-login-btn"></a>


 --%>
<!-- </div>  --><!--center 레이아웃 끝  -->




		<!--  right 레이아웃 사용x -->
		<div class="column side"></div>
		
		
		
		
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<jsp:include page="../layout/foot.jsp"></jsp:include>
</body>
</html>