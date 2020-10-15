<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="bean.ItemVO"%>
<%@page import="bean.ItemDAO"%>

<%
	request.setCharacterEncoding("UTF-8");


String cart = request.getParameter("cart");
boolean isCart = cart.equals("yes");
String name = request.getParameter("name");

ItemDAO dao = new ItemDAO();
ItemVO vo = dao.one(name);

%>




<!DOCTYPE html>
<html>
<head>
<!-- css -->
<link href="../css/main.css" rel="stylesheet" type="text/css">
<!-- jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- 아이콘 -->
<script src='https://kit.fontawesome.com/a076d05399.js'></script>

<!-- 메인 스크립트 -->
<script type="text/javascript">
	function goTop() {
		$('html').scrollTop(0);
	}

	// 총합가격 전역변수
	var totalprice = 0;
	
	//확장 parseInt: null이나 빈 문자열이면 0으로 변환
	function myParseInt (param) {
		if(isNaN(param)) return 0
		else if(param == "") return 0
		else return parseInt(param)
	}
	
	// 가격계산
	function calcPrice() {
		adultCount = myParseInt($('#adult_count').val())
		teenCount = myParseInt($('#teen_count').val())
		childCount = myParseInt($('#child_count').val())
		return adultCount * 12000 + teenCount * 9000 + childCount * 6000
	}
	
	
	$(function() {
		// 가격체크 (자동)
		$('#adult_count').keyup(function() {
			$('#total').val(calcPrice())
		})
		$('#teen_count').keyup(function() {
			$('#total').val(calcPrice())
		})
		$('#child_count').keyup(function() {
			$('#total').val(calcPrice())
		})
	})

	// 성인가격체크 (deprecated: keyup 이벤트 리스너로 대체되었음)
	function adultcheck() {
		adult = document.getElementById('adult_count').value
		adult = adult == null ? 0 : parseInt(adult)

		//총 가격 = 성인수량 * 12000 + 전역변수total
		totalprice = adult * 12000 + totalprice

		if (adult.length > 0) {
			document.getElementById('total').value = totalprice;
		}
	}
	
	// 청소년가격체크 (deprecated)
	function teencheck() {
		teen = document.getElementById('teen_count').value
		teen = teen == null ? 0 : parseInt(teen)
		//총 가격 = 청소년수량 * 12000 + 전역변수total
		totalprice = parseInt(teen) * 9000 + totalprice

		if (teen.length > 0) {
			document.getElementById('total').value = parseInt(totalprice)
		}
	}

	// 소인가격체크 (deprecated)
	function childcheck() {
		child = document.getElementById('child_count').value
		child = child == null ? 0 : parseInt(child)
		//총 가격 = 소인수량 * 12000 + 전역변수total
		totalprice = parseInt(child) * 6000 + totalprice

		if (child.length > 0) {
			document.getElementById('total').value = totalprice
		}
	}
	// 수량입력확인체크
	function check() {
		console.log("아직 deprecated 안됐다")
		total = document.getElementById('total').value
		// 글자수가 0이면 경고창 else form 실행
		if (total.length == 0) {
			alert("입장권 수량을 확인해주세요.");
		} else {
			document.getElementById('form').submit();
			return false;
		}
	}
	
	// 장바구니에 등록
	function addCart() {
		total = document.getElementById('total').value
		// 글자수가 0이면 경고창 else form 실행
		if (total.length == 0) {
			alert("입장권 수량을 확인해주세요.");
		} else {
			$.ajax({
				url: 'add-cart.jsp',
				data: {
					product_name: '<%=name%>',
					adult: myParseInt($('#adult_count').val()),
					teen: myParseInt($('#teen_count').val()),
					child: myParseInt($('#child_count').val())
				},
				success: function(result){
					alert("장바구니에 등록되었습니다")
					location.href='cart.jsp'
				}
			})
			return false;
		}
	}
</script>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>


	<jsp:include page="../layout/head.jsp"></jsp:include>


	<!-- left 레이아웃 사용x -->
	<div class="row">
		<div class="column side">
			<h2></h2>
		</div>


		<!-- 메인 컨텐츠 -->
		<div class="column middle">


			<form name="form" id="form" role="form" method="post"
				action="buy-board.jsp?cart=no" autocomplete="off">
				<input type="hidden" name="name" id="name" value="<%=name%>"><%=name%>
			<hr style="background-color: black">
				<div class="container p-3 my-3 border" style="width: 520px">
					<input type="checkbox">
					<div>
						<p style="font-size: 30px">A-1. [성인] 1인 입장권</p>
	
						<i style='font-size: 35px' class='fas'>&#xf07a;</i><input
							type="text" size="2" maxlength="3"
							oninput="this.value = this.value.replace(/[^0-9]/g, '');"
							style="margin-left: 330px" id="adult_count" name="adult_count"
							class="adult_count">
						<!-- button was deprecated -->
						<button class="d-none" type="button" onclick="adultcheck()">확인</button>
					</div>
				</div>
				<br>
				<div class="container p-3 my-3 border" style="width: 520px">
					<input type="checkbox">
					<div>
						<p style="font-size: 30px">A-2. [청소년] 1인 입장권</p>
						<i style='font-size: 35px' class='fas'>&#xf07a;</i><input
							type="text" size=2 maxlength="3" style="margin-left: 330px"
							oninput="this.value = this.value.replace(/[^0-9]/g, '');"
							id="teen_count" name="teen_count" class="teen_count">
						<!-- button was deprecated -->
						<button class="d-none" type="button" onclick="teencheck()">확인</button>
					</div>
				</div>
				<br>
				<div class="container p-3 my-3 border" style="width: 520px">
					<input type="checkbox">
					<div>
						<p style="font-size: 30px">A-3. [소인] 1인 입장권</p>
						<i style='font-size: 35px' class='fas'>&#xf07a;</i><input
							type="text" size=2 maxlength="3" style="margin-left: 330px"
							oninput="this.value = this.value.replace(/[^0-9]/g, '');"
							id="child_count" name="child_count" class="child_count">
						<!-- button was deprecated -->
						<button class="d-none" type="button" onclick="childcheck()">확인</button>
					</div>
				</div>
				<br>
				<!-- 수량 입력후 확인누르면 결제확인 밑에 총 금액이 나옴  -->
				<!-- 이제 확인 안눌러도 총금액 자동으로 계산해줍니다 -->
				<table style="margin-left: 340px;">
					<!-- style="margin-left: 230px;" "margin-left: 340px;"> -->
					<tr align="center">
						<td bgcolor="lightgray" width="100px" height="50px">총 결제금액</td>
						<td bgcolor="lightgray" width="170px" height="50px"><input
							type="text" id="total" value='' name="total" readonly="readonly"
							style="width: 120px; font-size: 20px; text-align: right;">원</td>
					</tr>
				</table>
				<br>
				<% if (!isCart) { %>
				<button type="button" class="btn btn-warning" onclick="check()">결제확인</button>
				<% } else { %>
				<button type="button" class="btn btn-warning" onclick="addCart()">장바구니 담기</button> 
				<% } %>
				<button type="button" class="btn btn-light"
					onclick="window.location.reload()">초기화</button>
			</form>
		</div>


		<!--  right 레이아웃 사용x -->
		<div class="column side">
			<h2></h2>
		</div>
	</div>


	<jsp:include page="../layout/foot.jsp"></jsp:include>
</body>
</html>