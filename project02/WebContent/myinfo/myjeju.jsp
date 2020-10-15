<%@page import="java.util.ArrayList"%>
<%@page import="bean.ZzimVO"%>
<%@page import="bean.ZzimDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--zzim db에서 로그인된(세션) 아이디로 검색해서 여행지 이름 받아와야 함  --> 
<% 
String id = (String)session.getAttribute("id"); //세션에서 아이디값 가져옴
ZzimDAO dao = new ZzimDAO();
ZzimVO vo = new ZzimVO();
ArrayList<ZzimVO> list = dao.read2(id);

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

<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<!-- css -->
<link rel="stylesheet" type="text/css" href="../css/main.css" />
<style type="text/css">

body{
font-family: "맑은 고딕", Helvetica, sans-serif;
font-size : 15px;
}

#title{
background: lightgray;
padding: 20px; 
}

.zzim{
color: red;
font-weight: bold;
}
</style>	
<script type="text/javascript">

function goTop(){
	$('html').scrollTop(0);
}

</script>

<meta charset="UTF-8">
<title>웰컴제주</title>
</head>
<body>
	
	<jsp:include page="../layout/head.jsp"></jsp:include>


	<!-- left 레이아웃 사용x -->

		<div class="column side">
			<h2></h2>
		</div>


<meta charset="UTF-8">
<title>Insert title here</title>

<div class="column middle">
  

<!-- 	//name으로 item테이블에서 lat, lng 검색
	//검색할 name..이 여러개임
	//반복문으로 돌릴거면..? 배열에 저장??
	//list.size 크기의 배열을 만들고 : 이름을 저장한다
	//db검색시 이름을 하나씩 꺼내서 검색 -->
	
<jsp:include page="../layout/head.jsp"></jsp:include>

<div id="wrap">
<div id="title">

<%if(session.getAttribute("kakao")!=null) {%>

<h3><%= session.getAttribute("kakao") %>님의 제주여행 <span class="zzim"><%= list.size() %><span></h3>

<%}else{ %> <!-- 카카오 로그인 아닐경우 아이디 출력 -->	
<h3><%= session.getAttribute("id") %>님의 제주여행 <span class="zzim"><%= list.size() %><span></h3>

<%} %>
</div>
<div>
<% 
for (int i = 0; i < list.size(); i++){
%>
<hr>
<h4>
<a href="../main/detail.jsp?name=<%=list.get(i).getName()%>"><%=list.get(i).getName() %></a>
</h4>
<%
	}
%>

</div>

<div class="column side"></div>

<jsp:include page="../layout/foot.jsp"></jsp:include>
		<!--  right 레이아웃 사용x -->
		<div class="column side"></div>
</body>
</html>