<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript">

	var idcheckflag = false; //idcheck는 ajax호출하므로 외부에서 함수를 쉽게 부를 수 없어 flag로 구현
	
		$(function() {
			$('#bedal_id').keyup(function() {
				$.ajax({
					url:"../bedal/bedal_user/check_id.do",
					data: {
						bedal_id : $('#bedal_id').val()
					},
					success : function(result) {
						
						// db에 중복된 id가 있으면 1
						if(result == 1){
							$('#idChk').html('<font color=red>중복된 ID가 있습니다.</font>')
							idcheckflag = false;

							
						} else {
							var id = $('#bedal_id').val();
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
			}) // id 중복검사
			
			
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
			} // 비밀번호 확인
			
			$('#pwc').keyup(pwccheck)//pwc
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
			} // 비밀번호 재확인
			
			
			
			//이름체크
			function namecheck() {	
				if($('#name').val().length == 0) return false;
				else return true;
			}
			//닉네임체크
			function nicknamecheck() {
				if($('#nickname').val().length == 0) return false;
				else return true;
			}
			
			//나이체크
			function agecheck() {
				if($('#age').val().length == 0) return false;
				else return true;
			}
			
			//시 체크
			function sicheck() {
				if($('#sido1').val().length == 0 && $('#sido1').val == "시/도 선택") return false;
				else return true;
			}
			//구 체크
			function gucheck() {
				if($('#gugun1').val().length == 0 && $('#sido1').val == "구/군 선택") return false;
				else return true;
			}
			//배송수단 체크
			function vehiclecheck() {
				if($('#vehcle').val().length == 0) return false;
				else return true;
			}
			//증명사진 체크
			function imagecheck() {
				if($('#bedal_image').val().length == 0) return false;
				else return true;
			}
			
			
			//이메일 체크
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
						
			 
			//전화번호 체크
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
		
			
		})//ready
		
		
		// 지역 선택
		$('document').ready(function() {
			var area0 = ["시/도 선택","서울특별시","인천광역시","대전광역시","광주광역시","대구광역시","울산광역시","부산광역시","경기도","강원도","충청북도","충청남도","전라북도","전라남도","경상북도","경상남도","제주도"];
			  var area1 = ["강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"];
			   var area2 = ["계양구","남구","남동구","동구","부평구","서구","연수구","중구","강화군","옹진군"];
			   var area3 = ["대덕구","동구","서구","유성구","중구"];
			   var area4 = ["광산구","남구","동구",     "북구","서구"];
			   var area5 = ["남구","달서구","동구","북구","서구","수성구","중구","달성군"];
			   var area6 = ["남구","동구","북구","중구","울주군"];
			   var area7 = ["강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"];
			   var area8 = ["고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","여주군","연천군"];
			   var area9 = ["강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"];
			   var area10 = ["제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"];
			   var area11 = ["계룡시","공주시","논산시","보령시","서산시","아산시","천안시","금산군","당진군","부여군","서천군","연기군","예산군","청양군","태안군","홍성군"];
			   var area12 = ["군산시","김제시","남원시","익산시","전주시","정읍시","고창군","무주군","부안군","순창군","완주군","임실군","장수군","진안군"];
			   var area13 = ["광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
			   var area14 = ["경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","영양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"];
			   var area15 = ["거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","통영시","거창군","고성군","남해군","산청군","의령군","창녕군","하동군","함안군","함양군","합천군"];
			   var area16 = ["서귀포시","제주시","남제주군","북제주군"];
	
			  
			 // 시/도 선택 박스 초기화
			 $("select[name^=sido]").each(function() {
			  $selsido = $(this);
			  $.each(eval(area0), function() {
			   $selsido.append("<option value='"+this+"'>"+this+"</option>");
			  });
			  $selsido.next().append("<option value=''>구/군 선택</option>");
			 });

			 
			 // 시 선택시 구 설정
			 $("select[name^=sido]").change(function() { // ^= 속성지정하는 
			  var area = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의 구군 Array
			  var $gugun = $(this).next(); // 선택영역 군구 객체
			  $("option",$gugun).remove(); // 구군 초기화

			  if(area == "area0")
			   $gugun.append("<option value=''>구/군 선택</option>");
			  else {
			   $.each(eval(area), function() {
			    $gugun.append("<option value='"+this+"'>"+this+"</option>");
			   });
			  }
			 });
			 
			});
		
		
	</script>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<div class="container" id="wrap">
		<div class="row" style="margin-top: 100px; margin-bottom: 100px">
			<div class="col-md-6 col-md-offset-3">
				<form action="../bedal/bedal_user/joincheck.do" name="form" id="form" role="form" method="post">
					<legend style="font-size: 30px">배달 회원가입</legend>

					<label>아이디*</label> 
					<input type="text" maxlength="20" id="bedal_id" 
					name="bedal_id" value="" class="form-control input-lg" required="" autofocus=""
					placeholder="ID">
					<div id=idChk></div>
					
					
					<br> <label>비밀번호*</label> <input type="password" required="" autofocus=""
						maxlength="16" id="pw" name="bedal_pw" value=""
						class="form-control input-lg" placeholder="Password">
					<div id=pwChk></div>
					
					
					<br> <label>비밀번호 확인*</label> <input type="password" required="" autofocus=""
						maxlength="16" id="pwc" value="" class="form-control input-lg"
						placeholder="Confirm Password">

					<div id=pwcChk></div>
					<br> <label>이름*</label> <input type="text" id="name"  required="" autofocus=""
						name="bedal_name" value="" class="form-control input-lg"
						placeholder="Name" /><br>
						
						<label>배송할 지역 선택* (한 곳 이상 선택 필수!)</label> 
						<br>
							<!-- 서울시 선택 -->
								<select name="sido1" id="sido1" style="padding:5px; margin-bottom: 5px;" required="" autofocus=""></select>
								<select name="gugun1" id="gugun1" style="padding:5px;" required="" autofocus=""></select> *
						<br>
								<select name="sido2" id="sido2" style="padding:5px; margin-bottom: 5px;"></select>
								<select name="gugun2" id="gugun2" style="padding:5px; margin-bottom: 20px;"></select>
						
						
						<br><label>휴대전화*</label>
						<input type="text" id="phone" name="bedal_tel" value="" class="form-control input-lg" required="" autofocus=""
						placeholder="Phone Number">
						<div id=phoneChk></div>

						
						<br><label>이메일*</label>
						<input type="text" id="email"  required="" autofocus="" name="bedal_email" value="" class="form-control input-lg"
                 		 placeholder="Email">
                 		<div id=emailChk></div>
					
					
						<br> <label>닉네임*</label> 
						<input type="text" id="nickname" name="bedal_nickname" value="" required="" autofocus=""
						class="form-control input-lg" placeholder="NickName"/>

						
						<br> <label>배송 수단*</label> <br>
						<select name="bedal_vehicle" id="vehicle" style="padding:5px; margin-bottom: 20px;" required="" autofocus="">
								<option value="선택">선택</option>
								<option value="도보">도보</option>
								<option value="자전거">자전거</option>
								<option value="전동킥보드">전동 킥보드</option>
								<option value="오토바이">오토바이</option>
								<option value="승용차">승용차</option>
								<option value="트럭">트럭</option>
						</select>
						
						
						<br><label>증명사진* (2.5cm * 3cm 규격의 증명사진을 첨부해주세요!)</label>
						<input type="file" id="bedal_image"  required="" autofocus=""
						name="bedal_image" class="form-control input-lg">
						<br>


					<button id="join"
						class="btn btn-lg btn-primary btn-block signup-btn" type="submit" onsubmit="return false">
						가입하기</button>
						</form>

			</div>
		</div>
	</div>

</body>
</html>