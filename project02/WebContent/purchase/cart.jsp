<%@page import="bean.CartInfo"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
    Vector<CartInfo> cart = (Vector<CartInfo>)session.getAttribute("cart");
    if(cart == null) cart = new Vector<>();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
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
<!-- 스크립트 -->
<script>
	function deleteItem(i) {
		$.ajax({
			url: 'delete-cart.jsp',
			data: {
				cartidx: i
			},
			success: function(){
				alert("삭제되었수다");
				location.reload()
			}
		})
	}
</script>
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
		<h2>장바구니</h2>
		<table class="table table-sprited">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">상품명</th>
					<th scope="col">성인</th>
					<th scope="col">청소년</th>
					<th scope="col">어린이</th>
					<th scope="col">삭제</th>
				</tr>					
			</thead>
			<tbody>
			<%for (int i=cart.size(); i>0; i--) {
				CartInfo item = cart.get(i-1);
			%>
				<tr>
					<th scope="row"><%=i %></th>
					<td><%=item.getName() %></td>
					<td><%=item.getAdult() %></td>
					<td><%=item.getTeen() %></td>
					<td><%=item.getChild() %></td>
					<td><button onclick='deleteItem(<%=i-1%>)' class="btn btn-danger">삭제</button></td>
				</tr>
			<% } %>
			</tbody>		
		</table>
		<button onclick="location.href = '../main/index.jsp'" class="btn btn-light">계속 쇼핑하기</button>
		<button onclick="location.href = 'buy-board.jsp?cart=yes'" class="btn btn-warning">결제하기</button>
		</div>
		<!--  right 레이아웃 사용x -->
		<div class="column side">
			<h2></h2>
		</div>
	</div>
	<jsp:include page="../layout/foot.jsp"></jsp:include>
</body>
</html>