<%@page import="bean.ReviewDAO"%><%@page import="bean.ZzimDAO"%>
<%@page import="java.util.Vector"%>
<%@page import="bean.ItemVO"%>
<%@page import="bean.ItemDAO"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	int category;
	try { //getParameter로 못 받는다고? 그럼 0이 기본값
		category = Integer.parseInt(request.getParameter("category"));
	} catch (Exception e) {
		category = 0;
	}
	String[] classPointed = new String[12];
	Arrays.fill(classPointed, "");
	classPointed[0] = "all";
	classPointed[category] = classPointed[category].concat(" pointed");
	
	String imgsrc = "https://dummyimage.com/300x200/ffd47e/FFEFA0&text=JejuTravel";
	
	ItemDAO dao = new ItemDAO();
	String[] categoryName = { "", "자연", "문화관광", "레저/체험", "테마관광지",
							"섬 속의 섬", "도보", "포토스팟", "템플스테이",
							"제주 4.3", "의료관광","웰니스" };
	Vector<ItemVO> bag = dao.read(categoryName[category]);
	ZzimDAO zzdao = new ZzimDAO();
	ReviewDAO rvdao = new ReviewDAO();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>

<!-- jQeury -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- css -->
<link href="../css/main2.css" rel="stylesheet" type="text/css">
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

<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="../assets/img/favicon.ico" />

<link href="../css/bootstrap.min.css?after" rel="stylesheet">
<link rel="stylesheet" href="../css/index.css?after" type="text/css" />
</head>
<body>
<jsp:include page="../layout/main-head.jsp"></jsp:include>
	<div class="row">
		<!-- left 사이드 레이아웃 일단 사용x -->
		<div class="column side">
			<h2></h2>
		</div>

	<!-- 메인 공지사항 게시판 영역 -->
		<div class="column middle">

	<div id="category-wrapper"  style="position: relative; left: -73px">
		<table id="category">
			<tr>
				<td class="<%=classPointed[0]%>" rowspan=3><a
					href="?category=0">전체</a></td>
				<td class="<%=classPointed[1]%>"><a href="?category=1">자연</a></td>
				<td class="<%=classPointed[2]%>"><a href="?category=2">문화관광</a></td>
				<td class="<%=classPointed[3]%>"><a href="?category=3">레저/체험</a></td>
				<td class="<%=classPointed[4]%>"><a href="?category=4">테마관광지</a></td>
			</tr>
			<tr>
				<td class="<%=classPointed[5]%>"><a href="?category=5">섬
						속의 섬</a></td>
				<td class="<%=classPointed[6]%>"><a href="?category=6">도보</a></td>
				<td class="<%=classPointed[7]%>"><a href="?category=7">포토스팟</a></td>
				<td class="<%=classPointed[8]%>"><a href="?category=8">템플스테이</a></td>
			</tr>
			<tr>
				<td class="<%=classPointed[9]%>"><a href="?category=9">제주
						4.3</a></td>
				<td class="<%=classPointed[10]%>"><a href="?category=10">의료관광</a></td>
				<td class="<%=classPointed[11]%>"><a href="?category=11">웰니스</a></td>
				<td></td>
			</tr>
		</table>
	</div>
	<div id="item-container-wrapper"">
		<div id="item-container">
			<ul>
				<%
					for (int i = 0; i < bag.size(); i++) {
						ItemVO vo = bag.get(i);
				%>
				<a href="detail.jsp?name=<%=vo.getName()%>">
					<li class="btn btn-default">
						<div class="item-image"><img src="<%=imgsrc%>"></div>
						<div class="item-info-wrapper">
							<h3><%=vo.getName() %></h3>
						</div>
						<div class="item-action-wrapper">
							<span class="item-action">
								<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span><br>
								좋아요<br>
								<%=vo.getLikes() %>
							</span>
							<span class="item-action">
								<span class="glyphicon glyphicon-heart" aria-hidden="true"></span><br>
								찜<br>
								<%=zzdao.zzimcount(vo.getName()) %>
							</span>
							<span class="item-action">
								<span class="glyphicon glyphicon-comment" aria-hidden="true"></span><br>
								리뷰<br>
								<%=rvdao.count(vo.getName()) %>
							</span>
						</div>
					</li>
				</a>
				<% } %>
			</ul>
		</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js?after"></script>
	<script src="js/bootstrap.min.js?after"></script>
	
	
	</div>
	
		<!-- right 사이드 레이아웃 일단 사용x -->
		<div class="column side">
			<h2></h2>
		</div>
	</div>

	<jsp:include page="../layout/main-foot.jsp"></jsp:include>
</body>
</html>