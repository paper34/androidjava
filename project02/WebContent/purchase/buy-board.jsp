<%@page import="bean.CartInfo"%>
<%@page import="java.util.Vector"%>
<%@page import="bean.BuyDAO"%>
<%@page import="bean.BuyVO"%>
<%@page import="bean.ItemVO"%>
<%@page import="bean.ItemDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>


<%

String name = request.getParameter("name");

ItemDAO dao = new ItemDAO();
ItemVO vo = dao.one(name);

String adult_count = request.getParameter("adult_count");
System.out.println(adult_count);
if(adult_count == null) adult_count = "0";
else if(adult_count.equals("")) adult_count = "0";
String teen_count = request.getParameter("teen_count");
if(teen_count == null) teen_count = "0";
else if(teen_count.equals("")) teen_count = "0";
String child_count = request.getParameter("child_count");
if(child_count == null) child_count = "0";
else if(child_count.equals("")) child_count = "0";

boolean isCart = request.getParameter("cart").equals("yes");
Vector<CartInfo> cart = null;
String total = null;

if(isCart) {
	cart = (Vector<CartInfo>)session.getAttribute("cart");
	int t = 0;
	for(int i=0; i<cart.size(); i++) {
		CartInfo item = cart.get(i);
		t = t + item.getAdult() * 12000 + item.getTeen() * 9000 + item.getChild() * 6000;
	}
	total = String.valueOf(t);
	System.out.println(t);
	System.out.println(total);
} else {
	cart = new Vector<CartInfo>(); 
	CartInfo item = new CartInfo();
	item.setName(name);
	item.setAdult(Integer.parseInt(adult_count));
	item.setTeen(Integer.parseInt(teen_count));
	item.setChild(Integer.parseInt(child_count));
	cart.add(item);
	total = request.getParameter("total");
}

session.setAttribute("adult_count", adult_count);
session.setAttribute("teen_count", teen_count);
session.setAttribute("child_count", child_count);
session.setAttribute("total", total);
session.setAttribute("cartbill", cart);

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

<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<!-- 결제아이콘 -->
<script src='https://kit.fontawesome.com/a076d05399.js'></script>

<script type="text/javascript">
	function goTop() {
		$('html').scrollTop(0);
	}

	var IMP = window.IMP; // 생략가능
	IMP.init('imp57643464'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용

	// 입력확인체크
	function check() {
		tel = document.getElementById('tel').value //전화번호
		user_name = document.getElementById('user_name').value
		cardNm = document.getElementById('cardNm').value //카드번호
		RN = document.getElementById('RN').value //주민번호
		cardPW = document.getElementById('cardPW').value //카드비밀번호

		if (tel.length == 0) {
			alert("전화번호를 입력해주세요.");
		} else if (user_name.length == 0) {
			alert("이름을 입력해주세요.");
		} else if (cardNm.length == 0) {
			alert("카드번호를 입력해주세요.");
		} else if (RN.length == 0) {
			alert("주민번호를 입력해주세요.");
		} else if (cardPW.length == 0) {
			alert("카드 비밀번호를 입력해주세요.");
		} else if (tel.length < 11) {
			alert("전화번호 자릿수를 확인해주세요.");
		} else if (cardNm.length < 16) {
			alert("카드번호 자릿수를 확인해주세요.");
		} else if (RN.length < 6) {
			alert("주민번호 자릿수를 확인해주세요.");
		} else if (cardPW.length < 2) {
			alert("카드 비밀번호 자릿수를 확인해주세요.");
		} else {

			IMP.request_pay({
				pg : 'uplus', // version 1.1.0부터 지원.
				pay_method : 'card',
				merchant_uid : 'merchant_' + new Date().getTime(),
				name : '주문명:결제테스트',
				amount : <%=total%>,
				buyer_email : 'iamport@siot.do',
				buyer_name : '구매자이름',
				buyer_tel : '010-1234-5678',
				buyer_addr : '서울특별시 강남구 삼성동',
				buyer_postcode : '123-456',
				m_redirect_url : 'https://www.yourdomain.com/payments/complete'
			}, function(rsp) {
				if (rsp.success) {
					var msg = '결제가 완료되었습니다.';
					msg += '고유ID : ' + rsp.imp_uid;
					msg += '상점 거래ID : ' + rsp.merchant_uid;
					msg += '결제 금액 : ' + rsp.paid_amount;
					msg += '카드 승인번호 : ' + rsp.apply_num;
				} else {
					var msg = '결제에 실패하였습니다.';
					msg += '에러내용 : ' + rsp.error_msg;
					
					document.getElementById('form').submit();
					return false;
				}
				alert(msg);
			});

		}

	}
</script>

<meta charset="UTF-8">
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
			<h2 align="center">check2</h2>

			<hr style="background-color: black">
			<!-- 결제창 박스 -->
			<div class="container p-3 my-3 border">
				<form name="form" id="form" role="form" method="post"
					action="buy-after.jsp" autocomplete="off">
					<!-- 결제확인 테이블 -->
					<table class="table">
						<thead align="center">
							<tr>
								<th>상풍명</th>
								<th>성인</th>
								<th>청소년</th>
								<th>소인</th>
								<th>이용금액</th>
							</tr>
						</thead>
						<tbody align="center">
						<% for (int i=0; i<cart.size(); i++) {
									CartInfo item = cart.get(i); %>
							<tr>
								<td id="product_name"><input type="hidden" name="product_name" id="name" value="<%=item.getName()%>"><%=item.getName()%></td>
								<td id="adult_count"><%=item.getAdult()%></td>
								<td id="teen_count"><%=item.getTeen()%></td>
								<td id="child_count"><%=item.getChild()%></td>
								<td><%=item.setTotal()%>원</th>
							</tr>
							<% } %>
						</tbody>
					</table>
					<!-- 총결제 구역 -->
					<!-- style="margin-left: 490px;  "margin-left: 700px-->
					<div
						style="text-align: right; color: red; font-weight: bold; font-size: 20px">
						<input type="hidden" name="total" id="total" value="<%=total%>">
						총 결제금액:
						<%=total%>원
					</div>
					<br>
					<!-- 이용자정보 -->
					<p style="font-weight: bold; font-size: 15px">이용자정보</p>
					<hr style="background-color: black;">

					<!-- 입력칸 -->
					<div>
						<table class="table">
							<thead align="left">
								<tr>
									<td
										style="width: 130px; background-color: lightgray;; font-weight: bold;">휴대전화</td>
									<td><input type="text" size=40 maxlength="11" id="tel"
										oninput="this.value = this.value.replace(/[^0-9]/g, '');"
										name="tel" placeholder="- 없이 번호만 입력하시오."></td>
								</tr>
							</thead>
							<tbody align="left">
								<tr>
									<td
										style="width: 130px; background-color: lightgray; font-weight: bold">이름</td>
									<td><input type="text" size=40 maxlength="4"
										oninput="this.value = this.value.replace(/[a-z0-9]|[ \[\]{}()?|`~!@#$%^&*-_+=,.;:\'\\]/g, '');"
										id="user_name" name="user_name" placeholder="이름을 입력하시오."></td>
								</tr>
							</tbody>

						</table>
					</div>
					<!-- 카드정보입력 -->
					<br> <br>
					<p style="font-weight: bold; font-size: 15px">카드정보</p>
					<hr style="background-color: black;">
					<div>
						<table class="table table-bordered">
							<thead align="left">
								<tr>
									<td
										style="width: 130px; background-color: lightgray; font-weight: bold"><i
										style='font-size: 24px' class='fas'>&#xf53c;</i> 카드번호</td>
									<td><input type="text" size=40 maxlength="16" id="cardNm"
										oninput="this.value = this.value.replace(/[^0-9]/g, '');"
										name="cardNm" placeholder="카드번호를 입력하시오."> - 없이 숫자만 입력</td>
								</tr>

								<tr>
									<td
										style="width: 130px; background-color: lightgray; font-weight: bold">유효기간</td>
									<td><select name="month" style="width: 100px">
											<option value="01">01</option>
											<option value="02">02</option>
											<option value="03">03</option>
											<option value="04">04</option>
											<option value="05">05</option>
											<option value="06">06</option>
											<option value="07">07</option>
											<option value="08">08</option>
											<option value="09">09</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>

									</select>월 <select name="year" style="width: 100px">
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

									</select>년</td>


								</tr>

								<tr>
									<td
										style="width: 130px; background-color: lightgray; font-weight: bold">할부기간</td>
									<td><select name="buy-month" style="width: 100px">
											<option value="일시불">일시불</option>
											<option value="2개월">2개월</option>
											<option value="3개월">3개월</option>
											<option value="4개월">4개월</option>
											<option value="5개월">5개월</option>
											<option value="6개월">6개월</option>
											<option value="7개월">7개월</option>
											<option value="8개월">8개월</option>
											<option value="9개월">9개월</option>
											<option value="10개월">10개월</option>
											<option value="11개월">11개월</option>
											<option value="12개월">12개월</option>
									</select></td>
								</tr>

								<tr>
									<td
										style="width: 130px; background-color: lightgray; font-weight: bold">주민번호</td>
									<td><input type="text" size=40 maxlength="6" name="RN"
										oninput="this.value = this.value.replace(/[^0-9]/g, '');"
										id="RN" placeholder="주민번호을 입력하시오."> (주민번호 앞자리)</td>
								</tr>

								<tr>
									<td
										style="width: 130px; background-color: lightgray; font-weight: bold">비밀번호</td>
									<td><input type="text" size=40 maxlength="2" id="cardPW"
										oninput="this.value = this.value.replace(/[^0-9]/g, '');"
										placeholder="비밀번호를 입력하시오."> **(앞번호 두자리)</td>
								</tr>
							</thead>

						</table>
					</div>
					<br>
					<button type="button" class="btn btn-dark btn-block" id="pay"
						onclick="check()">결제하기</button>
				</form>
			</div>




		</div>
	</div>

	<!--  right 레이아웃 사용x -->
	<div class="column side">
		<h2></h2>
	</div>

	<br>
	<br>
	<jsp:include page="../layout/foot.jsp"></jsp:include>

</body>
</html>