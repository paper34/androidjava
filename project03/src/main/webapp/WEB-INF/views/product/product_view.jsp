<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>이조박켓</title>
	<!-- Custom fonts for this template-->
	<link href="<c:url value="/resources/bootstrap/vendor/fontawesome-free/css/all.min.css" />" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
	<!-- Custom styles for this template-->
	<link href="<c:url value="/resources/bootstrap/css/sb-admin-2.min.css" />" rel="stylesheet">
	 <!-- Bootstrap core JavaScript-->
	<script src="../resources/bootstrap/vendor/jquery/jquery.min.js"></script>
	<script	src="../resources/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script	src="../resources/bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
	<!-- Custom scripts for all pages-->
	<script src="../resources/bootstrap/js/sb-admin-2.min.js"></script>
	<!-- Page level plugins -->
	<script src="../resources/bootstrap/vendor/chart.js/Chart.min.js"></script>
	<!-- Page level custom scripts -->
	<script src="../resources/bootstrap/js/demo/chart-area-demo.js"></script>
	<script src="../resources/bootstrap/js/demo/chart-pie-demo.js"></script>
</head>

<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-x.y.z.js"></script>
<script type="text/javascript">
function payment() {
var IMP = window.IMP; // 생략가능
IMP.init('imp97137878'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용

 IMP.request_pay({
    pg : 'inicis', // version 1.1.0부터 지원.
    pay_method : 'vbank',
    merchant_uid : 'merchant_' + new Date().getTime(),
    name : '${vo.product_title}',
    amount : '${vo.product_price}' ,
    buyer_email : 'cagho2000@naver.com',
    buyer_name : '박창호',
    buyer_tel : '01031749022',
    buyer_addr : '서울 도봉구 노해로 143-6',
    buyer_postcode : '123-456',
    m_redirect_url : 'http://www.iamport.kr/mobile/landing'
}, function(rsp) {
    if ( rsp.success ) {
        var msg = '감사합니다!! 결제가 완료되었습니다. <이조박켓> 많이 이용해주세요';
		  
    document.getElementById('form').submit();
        
    	
    } else {
        var msg = '결제에 실패하였습니다.';
        msg += '에러내용 : ' + rsp.error_msg;
    }
    
    alert(msg);
    
}); 
}	

</script>


<script src="<c:url value="/resources/js/jquery-3.5.1.js" />"></script>
<script type="text/javascript">

	$(function() {
		$('#reply').click(function() {//reply를 클릭하면
			content = $('#content1').val()//cotent1에 입력을 하면
			$.ajax({
				url : "../product/create.do",//controller주소
				data : {
					content : content, // 댓글내용
					original : '${vo.product_id}', // 게시글 넘버 one.get~~
					writer : 	'${user_id}' //작성자

				},

				success : function(result) {//성공하면
					
					$('#t3').append(result)// div아이디 t3에 append 시켜줌
					location.reload()
					
				}

			})

		})

	})


	$(function() {
	 	
		$('#zzim').click(function() {

			$.ajax({
				url : "../user/profile/zzimcheck.do",
				data : {
					user_id : '${user_id}',
					product_id : '${vo.product_id}',
				},

				success : function(result) {

					if (result == 1) {

						alert("찜 취소!")
						$('#zzim').attr('class', "btn btn-outline-danger");
						location.reload()

					} else {
						alert("찜 성공!")
						$('#zzim').attr('class', "btn btn-danger");
						location.reload()
					}

				}
			})

		})
	})
</script>


<body>
	<jsp:include page="../../../layout.jsp"></jsp:include>

          <%-- 메일 타이틀 4종 --%>
          <div class="row">
            <%-- 나이대별 --%>
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">이조박켓</div>
                       <!-- Nav Item - Utilities Collapse Menu -->
				       <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#age" aria-expanded="true" aria-controls="age">
				         <div class="h5 mb-0 font-weight-bold text-gray-800">나이대별</div>
				        </a>
				        <div id="age" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
				          <div class="bg-white py-2 collapse-inner rounded">
							<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search1.do?user_age=1"/>">1 0 대</a></h6> <!-- 카테고리 10대 -->	
							<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search1.do?user_age=2"/>">2 0 대</a></h6> <!-- 카테고리 20대 -->	
							<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search1.do?user_age=3"/>">3 0 대</a></h6> <!-- 카테고리 30대 -->	
							<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search1.do?user_age=4"/>">4 0 대</a></h6> <!-- 카테고리 40대 -->	
							<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search1.do?user_age=5"/>">5 0 대</a></h6> <!-- 카테고리 50대 -->
				          	</div>
				          </div>
                    	</div>
                    <div class="col-auto">
                      <i class="fas fa-calendar fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <%-- 지역별 --%>
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-success text-uppercase mb-1">이조박켓</div>
				        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#dosi" aria-expanded="true" aria-controls="dosi">
				         <div class="h5 mb-0 font-weight-bold text-gray-800">지역별</div>
				        </a>
				        <div id="dosi" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
				          <div class="bg-white py-2 collapse-inner rounded">
						        <h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=강남"/>">서울특별시/강남구</a></h6> <!-- 카테고리 지역 -->
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=강동"/>">서울특별시/강동구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=강북"/>">서울특별시/강북구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=강서"/>">서울특별시/강서구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=관악"/>">서울특별시/관악구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=광진"/>">서울특별시/광진구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=구로"/>">서울특별시/구로구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=금천"/>">서울특별시/금천구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=노원"/>">서울특별시/노원구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=도봉"/>">서울특별시/도봉구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=동대문"/>">서울특별시/동대문구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=동작구"/>">서울특별시/동작구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=마포"/>">서울특별시/마포구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=서대문"/>">서울특별시/서대문구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=서초"/>">서울특별시/서초구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=성동"/>">서울특별시/성동구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=성북"/>">서울특별시/성북구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=송파"/>">서울특별시/송파구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=양천"/>">서울특별시/양천구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=영등포"/>">서울특별시/영등포구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=용산구"/>">서울특별시/용산구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=은평"/>">서울특별시/은평구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=종로"/>">서울특별시/종로구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=중구"/>">서울특별시/중구</a></h6>
								<h6 style="text-align: center;" ><a class="h6 mb-0 font-weight-bold text-blue-800" href="<c:url value="/product/product_search.do?product_adress=중랑구"/>">서울특별시/중랑구</a></h6>
				          </div>
				        </div>
                   	</div>
                    <div class="col-auto">
                      <i class="fas fa-calendar fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <%-- 인기매물 --%>
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">이조박켓</div><p></p>
				         <div><a class="h5 mb-0 font-weight-bold text-gray-800" href="/project/product/product_list2.do">인기매물</a></div><!--  href="../product/product_list2.do" -->
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-calendar fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
             <%-- 상품등록 --%>
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-success text-uppercase mb-1">이조박켓</div><p></p>
                      <div><a class="h5 mb-0 font-weight-bold text-gray-800" href="../web_product/writer.jsp">상품등록</a></div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
    	 </div>	
      		<%-- 메일 타이틀 4종끝!! --%>

				<%-- 상세 화면 보여주는 페이지 --%>
						<div class="container">
							<div class="row">
								<div class="col-xl-8">
								<%-- 상세 화면 보여주는 table 구현 --%>
									<table ctable class="table table-striped" style="text-align: center; border: #dddddd; color: white; width: 1100px; display: block; margin: 0 auto;">
										<thead>
											<tr>
												<th colspan="3" style="background-color: #4e73df; text-align: center; font-size: 3rem;">${vo.product_title}</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<%-- 이미지 --%>
												<td colspan="2"><img
													class="img-fluid px-3 px-sm-4 mt-3 mb-4"
													style="width: 950px; height: 950px; color: black;"
													src="../resources/img/${vo.product_image}"></td>
											</tr>
											 <tr>
												<%-- 작성자 --%>
												<td style="color: black; background-color: white; text-align: left;  font-size: 1.4rem;"
													colspan="2">${vo.user_id}</td> <!-- 종률이형한테 말하기 -->
											</tr> 
											<tr>
												<%-- 작성일 --%>
												<td style="color: black; background-color: white; text-align: left;  font-size: 1.4rem;"
													colspan="2">${vo.product_date}</td>
											</tr>
											<tr>
												<%-- 가격 --%>
												<td style="color: black; background-color: white; text-align: left;  font-size: 1.4rem;"
													colspan="2">${vo.product_price}</td>
											</tr>
											<tr>
												 <%-- 주소 --%>
												<td style="color: black; background-color: white; text-align: left;  font-size: 1.4rem;"
													colspan="2">${vo.product_adress}</td>
											</tr>
											<tr>
												<%-- 카테고리 --%>
												<td style="color: black; background-color: white; text-align: left;  font-size: 1.5rem;"
													colspan="2">${vo.product_category}</td>
											</tr>
											<tr>
												<%-- 상세내용 --%>
												<td
													style="color: black; background-color: white; text-overflow: ellipsis; min-height: 200px; text-align: left; font-size: 15px;"
													colspan="2">${vo.product_content}</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							
							
							
							<!-- 태그 사이에 내용(contents)이 비어있음. 빈태그 -->
							<sql:setDataSource url="jdbc:mysql://localhost:3366/project03"
								driver="com.mysql.jdbc.Driver" user="root" password="1234"
								scope="application" var="db" />

							<!-- 리스트불러오기 -->
							<sql:query var="list4" dataSource="${db}">
								select * from zzim where user_id = '${user_id}' and product_id = ${vo.product_id}
							</sql:query>
							
							<!-- 박창호 찜======================== -->
							<!-- db에 찜 한 기록이없으면 색이 안채워져있음 -->
							<!-- db에 찜 한 값이 있으면 색이 채워져있음 -->
							
							<c:forEach items="${list4.rows}" var="vo4">
								<c:choose>

									<c:when test="${vo4 == null}">
										<c:set var="service" value="btn btn-outline-danger"></c:set>
									</c:when>

									<c:when test="${vo4 != null}">
										<c:set var="service" value="btn btn-danger"></c:set>
									</c:when>

								</c:choose>

							</c:forEach>
							
							<button type="button" style="width: 50px;" class="btn btn-outline-danger<c:out value='${service}'></c:out>" id="zzim">
								<p>찜</p>
							</button>
							
							
							
							


							
							<c:if test="${user_id == vo.user_id}">
							<a style="background-color:#4e73df; float: left; margin: 5px;" href="product_update.do?product_id=${vo.product_id}" class="btn btn-primary">상품수정</a>
							<a style="background-color:#4e73df; float: left; margin: 5px;" href="product_delete.do?product_id=${vo.product_id}" class="btn btn-primary">상품삭제</a>
							</c:if>
							
							<c:choose>
							<c:when test="${vo.product_status == '0' }">
							
								<div class="form-group" >
									<%-- 결재상품 넘겨주는 값 --%> 
	 						      <form action="payment_create.do" id="form" name="form" method="post"> 
									 <input name="user_id" type="hidden" value="${user_id}"><%-- 유저아이디 --%>
									 <input name="product_id" type="hidden" value="${vo.product_id}"><%-- 상품아이디 --%>
									 <input name="product_price" type="hidden" value="${vo.product_price}"><%-- 상품가격 --%>
								   	<button onclick = "payment()" style="background-color: #4e73df; float: left; margin: 5px;" type="button" class="btn btn-primary pull-right" >결제하기</button>
								 </form>   
								<%-- 결제 API 사용하기 위해 onclick 만들어줌 --%>
								 <!-- <input onclick = "payment()" style="background-color: orange; float: left; margin: 5px;" type="button" class="btn btn-primary pull-right" value="결제" name="payment"> -->
	   							 </div>
	   							 </c:when>
	   							 
	   							 <c:otherwise>
	   							 
								   	<button type="button" style="background-color: #4e73df; float: left; margin: 5px;" disabled="disabled" class="btn btn-primary pull-right">결제하기</button>
	   							 
	   							 </c:otherwise>
	   							 
	   							 
							</c:choose>
							<!-- <a style="background-color:#4e73df; float: left; margin: 5px;" href="product_list.do" class="btn btn-primary">매물</a> -->

					<%-- 댓글 구현 --%>
					<div id="d2" style="width: 100%; height: 100px">
							<table style="width: 1100px; height: 50px" id="">
								<tr align="center">
									<td style="width: 10%; background-color: lightgray; color:black; border-bottom: 1px solid white">넘버</td>
									<td style="width: 50%; background-color: lightgray; color:black;">댓글</td>
									<td style="width: 20%; background-color: lightgray; color:black;">작성자</td>
									<td style="width: 20%; background-color: lightgray; color:black;">작성일자</td>
								</tr>
							</table>
						<c:forEach items="${list2}" var="vo" varStatus="status"><%-- 댓글을 구현하기위해 컨트롤러에서 list2를 불러와 foreach문을 사용 --%>
							<table style="width: 1100px; height: 100px" id="t2">
								<tr align="center">
									<td style="width: 10%;  border-bottom: 1px solid lightgray; color:black;">${status.index + 1}</td><%-- 댓글넘버를 1부터 빠진 번호 없이 보여주기 --%>
									<td style="width: 50%;  border-bottom: 1px solid lightgray; color:black;;">${vo.content}</td><%-- 댓글 상세내용 --%>
									<td style="width: 20%;  border-bottom: 1px solid lightgray; color:black;">${vo.writer}</td><%-- 댓글 작성자 --%>
									<td style="width: 20%;  border-bottom: 1px solid lightgray; color:black;">${vo.date}</td><%-- 댓글 작성시간 --%>
							<!-- 	<td><a href="delete.do?no=${vo.no}&original=${vo.original}"><button style="background: yellow">삭제</button></a></td> -->
								</tr>			
							</table>
						</c:forEach>
							<%-- 댓글 입력 --%>
							<input id="content1" name="content1" type="text" style="background-color: lightgray; float: left; margin: 5px; width: 85%;"/>
							<button id="reply" name="reply" class="btn btn-primary pull-right" type="submit" style="background-color: #4e73df; float: left; margin: 5px;">댓글달기</button>
					</div>
					<%-- 최근본상품 구현 --%>
					<div id="rightSide" >
							<div id="right_zzim">
								<div class="recTit" >
									최근본상품 <span id=recentCnt></span>
								</div>
								<div id="lately"> 
								<c:forEach var="vo" items="${list3}"><%-- 컨트롤러에서 list3을 불러와 foreach문을 사용하여 뿌려줌  --%>
									 <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 15rem; height: 5rem; dlspaly:block; margin:0 auto;" src="../resources/img/${vo.product_image}"><%-- 상품 이미지 불러옴 --%> 
									<div><a href="product_view.do?product_id=${vo.product_id}">LeeJoBak ket</a></div> <%-- 상품 이미지 불러옴 --%>
								</c:forEach>
								</div>
								<ul></ul> 
								<!-- 본 상품이 뿌려질 부분  -->
								<div id="paging">
									<a class="btn_prev" style="cursor: pointer">이전</a>
									<span id="currentPage"></span><span id="totalPageCount"></span>
									<a class="btn_next" style="cursor: pointer">다음</a>
							</div>
						</div>
					</div> 		
					<%-- 최근본상품 끝 --%>
					</div>
				<%-- 끝 --%>

			
	
</body>
</html>