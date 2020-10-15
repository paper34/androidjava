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

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<!-- css -->
<link rel="stylesheet" type="text/css" href="../css/main.css" />
<link rel="stylesheet" type="text/css" href="../css/join.css">


<script type="text/javascript">

function goTop(){
	$('html').scrollTop(0);
}

</script>
<script type="text/javascript">
	var idcheckflag = false; //idcheck는 ajax호출하므로 외부에서 함수를 쉽게 부를 수 없어 flag로 구현
		$(function() {
			//ajax로 받아오므로 
			$('#id').keyup(function() {
				$.ajax({
					url:"check.jsp",
					data: {
						id : $('#id').val()
					},
					success : function(result) {
						//0이면, id가 없음
						//1이면, id가 있음.
						if (result == 1) {
							$('#idChk').html('<font color=red>ID중복! 다른 ID를 입력해주세요</font>')
							idcheckflag = false;
						} else {
							//중복이 아닐경우 정규식 검사해줌
							var id = $('#id').val();
	 						var exp = /^[a-z0-9]{5,20}$/;
							if (exp.test(id) == false) { //중복은 아니지만 정규식에 맞지않음
								$('#idChk').html('<font color=red>5~20자의 영문 소문자, 숫자만 사용가능합니다</font>')
								idcheckflag = false;
							}else { //중복도 아니고 정규식도 맞는 사용가능한 아이디
								$('#idChk').html('')
								idcheckflag = true;
							}
						}
					}
				})
			})//id
			
			
			$('#pw').keyup(pwcheck)//pw
			function pwcheck() {
				//비밀번호 : 8~16 자리의 영문, 숫자, 특수문자의 조합
				 var pw = $('#pw').val();
				 var num = pw.search(/[0-9]/g);
				 var eng = pw.search(/[a-z]/ig);
				 var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
				 
				 if(pw.length < 8 || pw.length > 16){
					 $('#pwChk').html('<font color=red>8~16 자리의 영문, 숫자, 특수문자의 조합</font>')
				  return false;
				 }else if(pw.search(/\s/) != -1){
					 $('##pwChk').html('<font color=red>비밀번호는 공백 없이 입력해주세요.</font>')		 
				  return false;
				 }else if(num < 0 || eng < 0 || spe < 0 ){
					 $('#pwChk').html('<font color=red>8~16 자리의 영문, 숫자, 특수문자의 조합</font>')			 
				  return false;
				 }else {
					 $('#pwChk').html('')	
				    return true;
				 }
			}
			
			$('#pwc').keyup(pwccheck)//pwc
			function pwccheck() {
				//비밀번호 재확인(재입력 받아서 동일한지 확인)
				 var pw = $('#pw').val();
		 		 var pwc = $('#pwc').val();
		 		 
		 		 if (pw != pwc) {
		 			$('#pwcChk').html('<font color=red>비밀번호가 일치하지 않습니다.</font>')
		 			return false;
				}else {
					$('#pwcChk').html('')
					return true;
				}
			}
			
			//이름체크
			function namecheck() {
				if($('#name').val().length == 0) return false;
				else return true;
			}
			
			
			//년도체크
			$('#year').keyup(yearcheck)//birth year
			function yearcheck() {
				// 출생년도 : 숫자4자리만 입력가능 1920년도 이후~ 2020년 이전
				var year = $('#year').val();
			 	var exp = /^\d{1,4}$/;
				if (exp.test(year) && year>1920 && year<2020) {
					$('#yearChk').html('')
					return true;
				} else {
					$('#yearChk').html('<font color=red>태어난 년도 4자리를 정확하게 입력하세요.</font>')
					return false;
				}	
			}
			
			//월일체크
			function datecheck() {
				if($('#month > option:selected').val() == "월") {
					$('#dateChk').html('<font color=red>월을 선택해 주세요.</font>')
					return false
				}
				else if($('#day > option:selected').val() == "일") {
					$('#dateChk').html('<font color=red>일을 선택해 주세요.</font>')
					return false
				}
				$('#dateChk').html('');
				return true;
			}
			
			//성별체크
			function gendercheck() {
				if($('input[name=gender]:checked').val() == null) return false;
				else return true;
			}
			
			
			$('#phone').keyup(phonecheck)//phone
			function phonecheck() {
				//숫자 010 으로 시작 - 4자리 숫자 - 4자리숫자
				var exp = /^(010)-\d{4}-\d{4}$/;
				var phone = $('#phone').val();
				if (exp.test(phone)) {
					$('#phoneChk').html('')
					return true;
				} else {
					$('#phoneChk').html('<font color=red>전화번호 형식이 아닙니다!</font>')
					return false;
				}	
			}
			
			$('#email').keyup(mailcheck)//email
			function mailcheck() {
				//이메일 정규식 @와 . 반드시 포함
				var exp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
				var email = $('#email').val();
				if (exp.test(email)) {
					//console.log(exp.test(email));
					//console.log(email.match(exp));
					
					$('#emailChk').html('')
					return true;
				} else {
					//console.log(exp.test(email)); //true false로 반환
					//console.log(email.match(exp)); 
					
					$('#emailChk').html('<font color=red>메일 형식이 아닙니다!</font>')
					return false;
				}
			}
			
			//가입하기 버튼 눌렀을때
			$('#join').click(function() {

				//셀렉트 박스 생년월일
				console.log($('#year').val())
				console.log($('#month > option:selected').val())
				console.log($('#day > option:selected').val())
				
				//성별 라디오 버튼
				console.log($('input[name=gender]:checked').val())
				if(idcheckflag && pwcheck() && pwccheck() && namecheck() && yearcheck() && datecheck() && gendercheck() && phonecheck() && mailcheck())
				{
					$.ajax({
						url: "db.jsp",
						data: { 
							id : $('#id').val(),
							pw : $('#pw').val(),
							name : $('#name').val(),
							birth : $('#year').val() + "-" + $('#month > option:selected').val() + "-" + $('#day > option:selected').val(),
							gender : $('input[name=gender]:checked').val(),
							phone : $('#phone').val(),
							email : $('#email').val()
						},
						success: function(result) {
							if (result) {
								location.href = "login.jsp"
							}
						}
					})
				} else {
					alert("유효하지 않은 입력이 있습니다");
					console.log(datecheck())
				}
				
							
			})//join btn click
			
			
		})//ready
	</script>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<jsp:include page="../layout/head.jsp"></jsp:include>


	<div class="container" id="wrap">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<!-- <form action="r" method="post" accept-charset="utf-8" class="form" role="form">   -->

				<legend>웰컴제주 회원가입</legend>

				<label>아이디</label> <input type="text" maxlength="20" id="id"
					name="id" value="" class="form-control input-lg" placeholder="ID">
				<div id=idChk></div>
				<br> <label>비밀번호</label> <input type="password" maxlength="16"
					id="pw" name="pw" value="" class="form-control input-lg"
					placeholder="Password">
				<div id=pwChk></div>
				<br> <label>비밀번호 확인</label> <input type="password"
					maxlength="16" id="pwc" name="pwc" value=""
					class="form-control input-lg" placeholder="Confirm Password">
				<div id=pwcChk></div>
				<br> <label>이름</label> <input type="text" id="name" name="name"
					value="" class="form-control input-lg" placeholder="Name" /><br>
				<label>생년월일</label>
				<div class="row">
					<div class="col-xs-4 col-md-4">
						<input type="text" maxlength="4" id="year" name="year"
							class="form-control input-lg" placeholder="출생년도">

					</div>

					<div class="col-xs-4 col-md-4">

						<select id="month" name="month" class="form-control input-lg">
							<option disabled selected>월</option>
							<option value="01">1</option>
							<option value="02">2</option>
							<option value="03">3</option>
							<option value="04">4</option>
							<option value="05">5</option>
							<option value="06">6</option>
							<option value="07">7</option>
							<option value="08">8</option>
							<option value="09">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select>
					</div>
					<div class="col-xs-4 col-md-4">
						<select id="day" name="day" class="form-control input-lg">
							<option disabled selected>일</option>
							<option value="01">1</option>
							<option value="02">2</option>
							<option value="03">3</option>
							<option value="04">4</option>
							<option value="05">5</option>
							<option value="06">6</option>
							<option value="07">7</option>
							<option value="08">8</option>
							<option value="09">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
							<option value="13">13</option>
							<option value="14">14</option>
							<option value="15">15</option>
							<option value="16">16</option>
							<option value="17">17</option>
							<option value="18">18</option>
							<option value="19">19</option>
							<option value="20">20</option>
							<option value="21">21</option>
							<option value="22">22</option>
							<option value="23">23</option>
							<option value="24">24</option>
							<option value="25">25</option>
							<option value="26">26</option>
							<option value="27">27</option>
							<option value="28">28</option>
							<option value="29">29</option>
							<option value="30">30</option>
							<option value="31">31</option>
						</select>
					</div>

				</div>
				<div id=yearChk></div>
				<div id=dateChk></div>
				<br> <label>성별 : </label> <label class="radio-inline">
					<input type="radio" name="gender" value="M" id=male /> 남
				</label> <label class="radio-inline"> <input type="radio"
					name="gender" value="F" id=female /> 여
				</label> <br /> <br> <label>휴대전화</label> <input type="text" id="phone"
					name="phone" value="" class="form-control input-lg"
					placeholder="Phone Number">
				<div id=phoneChk></div>
				<br> <label>이메일</label> <input type="text" id="email"
					name="email" value="" class="form-control input-lg"
					placeholder="Email">
				<div id=emailChk></div>
				<br>

				<button id="join"
					class="btn btn-lg btn-primary btn-block signup-btn" type="submit">
					가입하기</button>

				<!--</form>  -->
			</div>
		</div>
	</div>

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