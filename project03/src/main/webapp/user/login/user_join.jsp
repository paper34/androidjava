<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>

<!-- boottrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	
<script src="<c:url value="/resources/js/jquery-3.5.1.js" />"></script>
<script type="text/javascript">

	var idcheckflag = false; //idcheck는 ajax호출하므로 외부에서 함수를 쉽게 부를 수 없어 flag로 구현
		
	
		$(function() {
			// 아이디 중복검사
			$('#id').keyup(function() {
				$.ajax({
					url:"../../user/login/check_id.do",
					data: {
						user_id : $('#id').val(),
					},
					success : function(result) {
						
						// db에 중복된 id가 있으면 1
						if(result == 1){
							
							$('#idChk').html('<font color=red>중복된 ID가 있습니다.</font>')
							idcheckflag = false;
							
						} else {
							var id = $('#id').val();
	 						var exp = /^[a-z0-9]{5,20}$/;
	 						
							if (exp.test(id) == false) { //중복은 아니지만 정규식에 맞지않음
								
								$('#idChk').html('<font color=red>5~20자의 영문 소문자, 숫자만 사용가능합니다</font>')
								idcheckflag = false;
							
							}else { //중복도 아니고 정규식도 맞는 사용가능한 아이디
								$('#idChk').html(' ')
								idcheckflag = true;
							} 
							
						}
					}
				})
			}) 
			
			//비밀번호 확인 체크
			$('#pw').keyup(pwcheck)
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
			
			// 비밀번호 재확인 체크
			$('#pwc').keyup(pwccheck)
			function pwccheck() {
				//비밀번호 재확인(재입력 받아서 동일한지 확인)
				 var pw = $('#pw').val();
		 		 var pwc = $('#pwc').val();
		 		 
		 		 if (pw != pwc) {
		 			$('#pwcChk').html('<font color=red>비밀번호가 일치하지 않습니다.</font>')
		 			return false;
				}else if (pw == pwc) {
					$('#pwcChk').html(' ')
					return true;
				}
			}
			
			//이름체크
			function namecheck() {
				if($('#name').val().length == 0) return false;
				else return true;
			}
			//닉네임임체크
			function nicknamecheck() {
				if($('#nickname').val().length == 0) return false;
				else return true;
			}
			
			//나이체크
			function agecheck() {
				if($('#age').val().length == 0) return false;
				else return true;
			}
			
			// 휴대전화 번호 체크
			$('#phone').keyup(phonecheck)
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
					$('#emailChk').html('')
					return true;
				} else {
					$('#emailChk').html('<font color=red>메일 형식이 아닙니다!</font>')
					return false;
				}
			}
			
			//가입하기 버튼 눌렀을때
			$('#join').click(function() {

				if(idcheckflag && pwcheck() && pwccheck() && namecheck() && nicknamecheck && agecheck && phonecheck() && mailcheck() == true)
				{
					//주소
					user_firstaddress = document.form.user_firstaddress.value;
					
					//상세주소
					user_detailaddress = document.form.user_detailAddress.value;
					
					//참고항목
					user_extraaddress = document.form.user_extraAddress.value;
					
					// 결과주소 = 주소 + 상세주소 + 참고항목
					user_address = user_firstaddress + user_detailaddress + user_extraaddress;
					
					// 결과주소
					document.form.user_address.value = user_address;
					document.form.submit();
					alert("회원가입이 완료되었습니다.")
				
				}
							
			})//join btn click
			
			
		})
		
	</script>

	<!-- 주소찾기 api -->
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript">
	
	function searchAddress() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var addr = ''; // 주소 변수
						var extraAddr = ''; // 참고항목 변수

						//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							addr = data.roadAddress;
						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							addr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
						if (data.userSelectedType === 'R') {
							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if (extraAddr !== '') {
								extraAddr = ' (' + extraAddr + ')';
							}
							// 조합된 참고항목을 해당 필드에 넣는다.
							document.getElementById("user_extraAddress").value = extraAddr;

						} else {
							document.getElementById("user_extraAddress").value = '';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById("user_firstAddress").value = addr;
						// 커서를 상세주소 필드로 이동한다.
						document.getElementById("user_detailAddress").focus();
					}
				}).open();
	}
	</script>
	
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<div class="container" id="wrap">
	
		<div class="row" style="margin-top: 100px; margin-bottom: 100px">
			<div class="col-md-6 col-md-offset-3">
			
				<form action="../../user/login/joincheck.do"  name="form" id="form" role="form" method="post">
				
					<legend style="font-size: 30px">회원가입</legend>
					<!-- 아이디 -->
					<label>아이디*</label> 
						<input type="text" maxlength="20" id="id" name="user_id"
						 value="" class="form-control input-lg" required="" autofocus="" placeholder="ID">
						 
					<div id=idChk></div><br>
					
					<!-- 비밀번호 -->
					<label>비밀번호*</label>
						<input type="password" required="" autofocus="" maxlength="16" id="pw" name="user_pw" value=""
						class="form-control input-lg" placeholder="Password">

					<div id=pwChk></div><br>
					
					<!-- 비밀번호 재확인 -->
					<label>비밀번호 확인*</label>
						<input type="password" required="" autofocus="" maxlength="16" id="pwc"
						value="" class="form-control input-lg" placeholder="Confirm Password">

					<div id=pwcChk></div><br>
					
					<!-- 이름 -->
					 <label>이름*</label>
					 	<input type="text" id="name"  required="" autofocus="" name="user_name" value=""
					 	 class="form-control input-lg" placeholder="Name" /><br>
					 	 
					<!-- 닉네임 -->
					<label>닉네임*</label>
					 	<input type="text" id="nickname" name="user_nickname" value="" required="" autofocus=""
					  	class="form-control input-lg" placeholder="NickName" /><br>

					<!-- 나이 -->
					<label>나이</label>
						<input type="text" id="age" oninput="this.value = this.value.replace(/[^0-9]/g, '');"
						name="user_age" value="" class="form-control input-lg" maxlength="3" size="5" required="" autofocus=""
						placeholder="age"> <br><br>
					
					<!-- 휴대전화 -->
					<label>휴대전화*</label>
						<input type="text" id="phone" name="user_tel" value="" class="form-control input-lg"
						required="" autofocus="" placeholder="Phone Number">

						<div id=phoneChk></div><br><br>
					
					<!-- 주소 -->
					<div class="teacher_cont_addr">
					
					<input type="button" onclick="searchAddress()" value="주소 찾기" class="btn btn-primary" readonly="readonly"><br> 
					
					<input type="text" name="user_firstaddress" id="user_firstAddress" placeholder="주소" class="form-control" readonly="readonly"><br>
					
					<input type="text" name="user_detailAddress" id="user_detailAddress" placeholder="상세주소" class="form-control"><br>
					
					<input type="text" name="user_extraAddress" id="user_extraAddress" placeholder="참고항목" class="form-control"><br>
					
					<input type="hidden" name="user_address" id="user_address" value="">
					
					</div><br>
					
					<!-- 이메일 -->
					 <label>이메일*</label>
					 	<input type="text" id="email"  required="" autofocus="" name="user_email" value=""
					 	 class="form-control input-lg" placeholder="email">
					 	 
						<div id=emailChk></div><br>
					

					<button id="join" class="btn btn-lg btn-primary btn-block signup-btn" type="button" onsubmit="return false">가입하기</button>
					
					</form>

			</div>
		</div>
	</div>

</body>
</html>