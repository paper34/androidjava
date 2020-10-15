<%@page import="java.util.Vector"%>
<%@page import="bean.CartInfo"%>
<%@page import="bean.BuyDAO"%>
<%@page import="bean.BuyVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	Vector<CartInfo> cart = (Vector<CartInfo>)session.getAttribute("cartbill");
	
	BuyVO vo = new BuyVO();
//	String product_name = request.getParameter("product_name");
	String user_name = request.getParameter("user_name");
	String tel = request.getParameter("tel");
	String cardNm = request.getParameter("cardNm");
	String total = request.getParameter("total");
	
	BuyDAO dao = new BuyDAO();
//	vo.setProduct_name(product_name);
//	vo.setUser_name(user_name);
//	vo.setTel(tel);
//	vo.setCardNm(cardNm);
//	vo.setTotal(total);
	for(int i=0; i<cart.size(); i++) {
		CartInfo item = cart.get(i);
		vo.setProduct_name(item.getName());
		vo.setUser_name(user_name);
		vo.setTel(tel);
		vo.setCardNm(cardNm);
		vo.setTotal(String.valueOf(item.setTotal()));
		dao.buy(vo);
	}
%>
<!DOCTYPE html>
<html>
<head>
<!-- jQeury -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- css -->
<link href="../css/main.css" rel="stylesheet" type="text/css">
<!-- boottrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function goTop() {
		$('html').scrollTop(0);
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
			<h2 align="center">결제완료</h2>

			<hr style="background-color: black; height: 5px">
			<!-- 결제창 박스 -->
			<div class="container p-3 my-3 border" style="width: 750px">
				<p style="font-size: 20px; font-weight: bold;">결제 정보</p>
				<table class="table text-center">
					<tr align="left">
						<th style="width: 250px">결제수단</th>
						<th>카드결제</th>
					</tr>
					<tr align="left">
						<th>거래카드</th>
						<th id="cardNm"><%=cardNm%></th>
					</tr>
					<tr align="left">
						<th>상품이름</th>
						<th id="product_name">
							<%for(int i=0; i<cart.size(); i++) {
								CartInfo item = cart.get(i);%>
							<p><%=item.getName()%></p>
							<% } %>
						</th>
					</tr>
					<tr align="left">
						<th>구매자</th>
						<th id="user_name"><%=user_name%></th>
					</tr>
					<tr align="left">
						<th>결제금액</th>
						<th id="total"><%=total%>원</th>
					</tr>
				</table>
			</div>


			<!-- <button type="submit" class="btn btn-dark" onclick="check()">결제확인</button> -->
			<!-- 수량 입력후 확인누르면 결제확인 밑에 총 금액이 나옴  -->
			<div align="left">

				<a href="#"><button type="button" class="btn btn btn-dark">메인
						홈</button></a>

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