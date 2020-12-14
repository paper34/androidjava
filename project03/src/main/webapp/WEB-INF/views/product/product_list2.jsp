<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core" %>
    <%request.setCharacterEncoding("UTF-8"); %>
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
	<script src="<c:url value="/resources/js/jquery-3.5.1.js" />"></script>

</head>
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
				         <div><a class="h5 mb-0 font-weight-bold text-gray-800" href="/project/product/product_list2.do">인기매물</a></div>
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
      		
      		
      		
      		
      		
      	<div class="row">
      		<c:forEach var="vo" items="${list5}" end="11"> <%-- 컨트롤러에서 list를 불러와 foreach문을 사용하여 뿌려줌 --%>
      		 <div class="col-xl-8">
              <div class="card shadow mb-4" id="item">
               	  <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 35rem; height: 35rem; dlspaly:block; margin:0 auto;" src="../resources/img/${vo.product_image}"><%-- 상품 이미지 불러옴 --%> 
                  <div style="dlspaly:block; margin:20px;" class="h1 mb-0 font-weight-bold text-black-1000"><a href="product_view.do?product_id=${vo.product_id}">LeeJoBak ket</a></div><%-- 상품 아이디 불러옴 --%> 
                  <div style="dlspaly:block; margin:20px;" class="h4 mb-0 font-weight-bold text-black-1000">${vo.product_title}</div><%-- 상품 제목 불러옴 --%> 
                  <div style="dlspaly:block; margin:20px;"  class="h4 mb-0  font-weight-bold text-black-800">${vo.product_price}원</div><%-- 상품 가격정보 불러옴 --%> 
                  <div style="dlspaly:block; margin:20px;"  class="h4 mb-0  text-black-800">${vo.product_adress}</div><%-- 고객 주소 불러옴 --%> 
                  <div style="dlspaly:block; margin:20px;"  class="h5 mb-0  text-black-800">${vo.product_category}</div><%-- 상품 상세내용 불러옴 --%> 
                  <div style="dlspaly:block; margin:20px;"  class="h5 mb-0  text-black-800"> ${vo.product_date} </div>   <%-- 상품 등록 날짜 불러옴 --%>               
                  <div style="dlspaly:block; margin:20px;" class="h5 mb-0 font-weight-bold text-gray-1000">${vo.product_count}</div><%-- 상품 조회수 불러옴 --%> 
                  <div style="dlspaly:block; margin:15px;" class="h5 mb-0 font-weight-bold text-gray-800">${vo.user_id}</div><%-- 유저아이디 불러옴 --%> 
                  <div style="dlspaly:block; margin:15px;" class="h3 mb-0 font-weight-bold text-gray-800">♥</div><%-- 찜 상품 불러옴 --%> 
        		</div>
      		</div>
      		</c:forEach>	
      		
      		
      		
      		
      		
      		
      		
      		
      		
      		
      		
      		
	
      		
      				<%-- 최근본 상품 --%>
				 		<div id="rightSide" >
							<div id="right_zzim">
								<div class="recTit" >
									최근본상품 <span id=recentCnt></span>
								</div>
								<div> 
									<c:forEach var="vo" items="${list3}" ><%-- 컨트롤러에서 list3을 불러와 foreach문을 사용하여 뿌려줌  --%>
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
					<%-- 최근본 상품 끝 --%>
					<form action="product_list2.do">
					<input style="background-color: #4e73df; font-weight:bold; float: right; margin-left: 1000px;" type="submit" class="btn btn-primary pull-right" value="↑↑맨위로↑↑"/>
				</form>
				</div>	
				<%-- 끝--%>
			
			
			
			
			
			
      			
							
   

</body>

</html>