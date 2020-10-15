<%@page import="bean.MemberVO2"%>
<%@page import="bean.MemberDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 1. id값 받아와야 함. -->
    <!-- 2. dao와 연동하여 결과 받아와야 함. -->
    <!-- 3. html로 만들어서 전송해야함. -->
<%
	String id = (String)session.getAttribute("id"); //세션에서 아이디값 가져옴
	MemberDAO2 dao = new MemberDAO2();
	MemberVO2 vo = dao.one(id);
	String date[] = vo.getBirth().split("-");
%>    
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
		$(function() {
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
						} else {
							//중복이 아닐경우 정규식 검사해줌
							var id = $('#id').val();
	 						var exp = /^[a-z0-9]{5,20}$/;
							if (exp.test(id) == false) { //중복은 아니지만 정규식에 맞지않음
								$('#idChk').html('<font color=red>5~20자의 영문 소문자, 숫자만 사용가능합니다</font>')
							}else { //중복도 아니고 정규식도 맞는 사용가능한 아이디
								$('#idChk').html('')
							}
						}
					}
				})
			})//id
			
			$('#pw').keyup(function() {
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
			})//pw	
			
			$('#pwc').keyup(function() {
				//비밀번호 재확인(재입력 받아서 동일한지 확인)
				 var pw = $('#pw').val();
		 		 var pwc = $('#pwc').val();
		 		 
		 		 if (pw != pwc) {
		 			$('#pwcChk').html('<font color=red>비밀번호가 일치하지 않습니다.</font>')
				}else {
					$('#pwcChk').html('')
				}
			})//pwc
			
			
			$('#year').keyup(function() {
				// 출생년도 : 숫자4자리만 입력가능 1920년도 이후~ 2020년 이전
				var year = $('#year').val();
			 	var exp = /^\d{1,4}$/;
				if (exp.test(year) && year>1920 && year<2020) {
					$('#yearChk').html('')
				} else {
					$('#yearChk').html('<font color=red>태어난 년도 4자리를 정확하게 입력하세요.</font>')
				}	
			})//birth year
			
			
			$('#phone').keyup(function() {
				//숫자 010 으로 시작 - 4자리 숫자 - 4자리숫자
				var exp = /^(010)-\d{4}-\d{4}$/;
				var phone = $('#phone').val();
				if (exp.test(phone)) {
					
					$('#phoneChk').html('')
				} else {
					$('#phoneChk').html('<font color=red>전화번호 형식이 아닙니다!</font>')
				}	
			})//phone
			
			$('#email').keyup(function() {
				//이메일 정규식 @와 . 반드시 포함
				var exp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
				var email = $('#email').val();
				if (exp.test(email)) {
					console.log(exp.test(email));
					//console.log(email.match(exp));
					
					$('#emailChk').html('')
				} else {
					console.log(exp.test(email)); //true false로 반환
					//console.log(email.match(exp)); 
					
					$('#emailChk').html('<font color=red>메일 형식이 아닙니다!</font>')
				}	
			})//email
			
			//수정하기 버튼 눌렀을때
			$('#update').click(function() {

			year = $('#year').val()
			month = $('#month > option:selected').val()
			day = $('#day > option:selected').val()
			gender = $('input[name=gender]:checked').val()
			
			console.log(year + "-" + month + "-" + day)
			
			$.ajax({
				url: "update.jsp",
				data: { 
					id : $('#id').val(),
					pw : $('#pw').val(),
					name : $('#name').val(),
					birth : $('#year').val() + "-" + $('#month > option:selected').val() + "-" + $('#day > option:selected').val(),
					gender : gender,
					phone : $('#phone').val(),
					email : $('#email').val()
				},
				success: function(result) {
					alert("수정되었습니다");
					location.href = '../main/index.jsp';
				}
			})
			
							
			})//join btn click
			
			
		})//ready
	</script>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>

	<jsp:include page="../layout/head.jsp"></jsp:include>


	<div class="container" id="wrap">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">

				<legend><%= vo.getId() %>님의 회원정보</legend>

				<input type="hidden" maxlength="20" id="id"
					name="id" value="<%= vo.getId() %>" class="form-control input-lg" placeholder="ID">
				<label>이름</label> <input type="text" id="name" name="name"
					value="<%= vo.getName()%>" class="form-control input-lg" placeholder="Name" /><br>
								<div class="row">
					<div class="col-xs-4 col-md-4">
					<input type="hidden" value="<%= vo.getBirth()%>" class="form-control input-lg" placeholder="Name" />
					</div>			
				</div>
				<br> <label>비밀번호</label> <input type="password" id="pw"
					name="pw" value="<%= vo.getPw() %>" class="form-control input-lg"
					placeholder="password">
				<div id=pwChk></div>
				<label>생년월일</label>
				<div class="row">
					<div class="col-xs-4 col-md-4">
						<input type="text" maxlength="4" id="year" name="year"
							class="form-control input-lg" placeholder="출생년도" value='<%=date[0] %>'>
					</div>

					<div class="col-xs-4 col-md-4">
						<select id="month" name="month" class="form-control input-lg">
							<option disabled>월</option>
							<option value="01" <% if(date[1].equals("01")) {%>selected<%} %>>1</option>
							<option value="02" <% if(date[1].equals("02")) {%>selected<%} %>>2</option>
							<option value="03" <% if(date[1].equals("03")) {%>selected<%} %>>3</option>
							<option value="04" <% if(date[1].equals("04")) {%>selected<%} %>>4</option>
							<option value="05" <% if(date[1].equals("05")) {%>selected<%} %>>5</option>
							<option value="06" <% if(date[1].equals("06")) {%>selected<%} %>>6</option>
							<option value="07" <% if(date[1].equals("07")) {%>selected<%} %>>7</option>
							<option value="08" <% if(date[1].equals("08")) {%>selected<%} %>>8</option>
							<option value="09" <% if(date[1].equals("09")) {%>selected<%} %>>9</option>
							<option value="10" <% if(date[1].equals("10")) {%>selected<%} %>>10</option>
							<option value="11" <% if(date[1].equals("11")) {%>selected<%} %>>11</option>
							<option value="12" <% if(date[1].equals("12")) {%>selected<%} %>>12</option>
						</select>
					</div>
					<div class="col-xs-4 col-md-4">
						<select id="day" name="day" class="form-control input-lg">
							<option disabled>일</option>
							<option value="01" <% if(date[2].equals("01")) {%>selected<%} %>>1</option>
							<option value="02" <% if(date[2].equals("02")) {%>selected<%} %>>2</option>
							<option value="03" <% if(date[2].equals("03")) {%>selected<%} %>>3</option>
							<option value="04" <% if(date[2].equals("04")) {%>selected<%} %>>4</option>
							<option value="05" <% if(date[2].equals("05")) {%>selected<%} %>>5</option>
							<option value="06" <% if(date[2].equals("06")) {%>selected<%} %>>6</option>
							<option value="07" <% if(date[2].equals("07")) {%>selected<%} %>>7</option>
							<option value="08" <% if(date[2].equals("08")) {%>selected<%} %>>8</option>
							<option value="09" <% if(date[2].equals("09")) {%>selected<%} %>>9</option>
							<option value="10" <% if(date[2].equals("10")) {%>selected<%} %>>10</option>
							<option value="11" <% if(date[2].equals("11")) {%>selected<%} %>>11</option>
							<option value="12" <% if(date[2].equals("12")) {%>selected<%} %>>12</option>
							<option value="13" <% if(date[2].equals("13")) {%>selected<%} %>>13</option>
							<option value="14" <% if(date[2].equals("14")) {%>selected<%} %>>14</option>
							<option value="15" <% if(date[2].equals("15")) {%>selected<%} %>>15</option>
							<option value="16" <% if(date[2].equals("16")) {%>selected<%} %>>16</option>
							<option value="17" <% if(date[2].equals("17")) {%>selected<%} %>>17</option>
							<option value="18" <% if(date[2].equals("18")) {%>selected<%} %>>18</option>
							<option value="19" <% if(date[2].equals("19")) {%>selected<%} %>>19</option>
							<option value="20" <% if(date[2].equals("20")) {%>selected<%} %>>20</option>
							<option value="21" <% if(date[2].equals("21")) {%>selected<%} %>>21</option>
							<option value="22" <% if(date[2].equals("22")) {%>selected<%} %>>22</option>
							<option value="23" <% if(date[2].equals("23")) {%>selected<%} %>>23</option>
							<option value="24" <% if(date[2].equals("24")) {%>selected<%} %>>24</option>
							<option value="25" <% if(date[2].equals("25")) {%>selected<%} %>>25</option>
							<option value="26" <% if(date[2].equals("26")) {%>selected<%} %>>26</option>
							<option value="27" <% if(date[2].equals("27")) {%>selected<%} %>>27</option>
							<option value="28" <% if(date[2].equals("28")) {%>selected<%} %>>28</option>
							<option value="29" <% if(date[2].equals("29")) {%>selected<%} %>>29</option>
							<option value="30" <% if(date[2].equals("30")) {%>selected<%} %>>30</option>
							<option value="31" <% if(date[2].equals("31")) {%>selected<%} %>>31</option>
						</select>
					</div>

				</div>
				<div id=yearChk></div>
				<br> <label>성별 : </label> <label class="radio-inline">
					<input type="radio" name="gender" value="M" id=male
						<%if(vo.getGender().equals("M")) {%> checked<%} %>/> 남
				</label> <label class="radio-inline"> <input type="radio"
						name="gender" value="F" id=female
						<%if(vo.getGender().equals("F")) {%> checked<%} %>/> 여
				</label><br> <label>휴대전화</label> <input type="text" id="phone"
					name="phone" value="<%= vo.getPhone() %>" class="form-control input-lg"
					placeholder="Phone Number">
				<div id=phoneChk></div>
				<br> <label>이메일</label> <input type="text" id="email"
					name="email" value="<%= vo.getEmail() %>" class="form-control input-lg"
					placeholder="Email">
				<div id=emailChk></div>
				<br>

				<button type="submit" id="update"
					class="btn btn-lg btn-primary btn-block signup-btn" type="submit">
					수정하기</button>
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