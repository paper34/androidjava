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
<!-- ������ -->
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<!-- ��ũ��Ʈ -->
<script>
	function deleteItem(i) {
		$.ajax({
			url: 'delete-cart.jsp',
			data: {
				cartidx: i
			},
			success: function(){
				alert("�����Ǿ�����");
				location.reload()
			}
		})
	}
</script>
</head>
<body>
	<jsp:include page="../layout/head.jsp"></jsp:include>
	<!-- left ���̾ƿ� ���x -->
	<div class="row">
		<div class="column side">
			<h2></h2>
		</div>
		<!-- ���� ������ -->
		<div class="column middle">
		<h2>��ٱ���</h2>
		<table class="table table-sprited">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">��ǰ��</th>
					<th scope="col">����</th>
					<th scope="col">û�ҳ�</th>
					<th scope="col">���</th>
					<th scope="col">����</th>
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
					<td><button onclick='deleteItem(<%=i-1%>)' class="btn btn-danger">����</button></td>
				</tr>
			<% } %>
			</tbody>		
		</table>
		<button onclick="location.href = '../main/index.jsp'" class="btn btn-light">��� �����ϱ�</button>
		<button onclick="location.href = 'buy-board.jsp?cart=yes'" class="btn btn-warning">�����ϱ�</button>
		</div>
		<!--  right ���̾ƿ� ���x -->
		<div class="column side">
			<h2></h2>
		</div>
	</div>
	<jsp:include page="../layout/foot.jsp"></jsp:include>
</body>
</html>