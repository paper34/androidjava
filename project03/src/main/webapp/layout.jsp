<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/bootstrap/vendor/fontawesome-free/css/all.min.css" />" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<link href="<c:url value="/resources/bootstrap/css/sb-admin-2.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/myprofileCSS9.css" />" rel="stylesheet">
 
</head>

<style>
  .col-xl-8 {
    flex: 0 0 25%;
    max-width: 66%;
  }
  
  

</style>
<style>


#rightSide{

position: absolute;

top: 547px;

left: 70%;

margin: 0 0 0 500px;

	}

#rightSide #right_zzim {

position: fixed;

top: 126px;

left: 50%;

margin-left: 41%;

border:1px solid #B0B5BD;

width:150px;

height:500px;



}



#rightSide #right_zzim  div {text-align:center;}

#rightSide #right_zzim  div.recTit{line-height:1.5em;padding:5px;color:white;background-color:#505A69;}

#right_zzim #recentCnt {color:yellow;}

#rightSide #right_zzim ul {min-height:495px;}

#rightSide #right_zzim  li{text-align:center;padding:5px;position:relative;} 

#rightSide #right_zzim ul li img {border:1px solid #ccc}

#right_zzim .detail {

display: none;

position: absolute;

top: 3px;

right: 20px;

xheight: 40px;

xpadding: 15px 11px 0;

xbackground: #404a59;

color: #fff;

xtext-align: left;

white-space: nowrap;



}



#right_zzim li:hover .detail {display:block}

#right_zzim li .btn_delete {

position: absolute;

top: 3px;

right: -1px;

width: 11px;

height: 11px;

background: url(/img/sp.png) no-repeat -193px -111px;

text-indent: -9000px;

}

#right_zzim  #currentPage {color:#505A69;font-weight:bold}

#right_zzim  #totalPageCount {color:#CBC8D2;font-weight:bold}

.noData {color:#ccc;text-align:center;margin-top:223px;}



}

#paging {display:;position:relative;line-height:1em;}

#paging .btn_prev {

position: absolute;

top: 526px;

left: 4px;

width: 13px;

height: 11px;

background: url(/images/ico_arrow.png)  no-repeat ;

text-indent: -9000px;

border:1px solid #CCC;

display:inline-block;

}



#paging .btn_next {

position: absolute;

top: 526px;

right: 4px;

width: 13px;

height: 11px;

background: url(/images/ico_arrow.png) -11px 0px;

text-indent: -9000px;

border:1px solid #CCC;

display:inline-block;

}


</style>


<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="<c:url value="/product/product_list.do"/>">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-shopping-basket"></i>
				</div>
				<div class="sidebar-brand-text mx-3">이조박 마켓</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">



			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">상품</div>

			<!-- 좌측 네비 메뉴선택 중고거래 카테고리 -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-store-alt-slash"></i> <span>중고거래</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">카테고리</h6>
						
					<a class="collapse-item" href="<c:url value="/product/product_list.do"/>">전체목록</a> 
					<a class="collapse-item" href="<c:url value="/product/product_search.do?product_category=디지털"/>">디지털/가전</a> <!-- 카테고리별 -->
					<a class="collapse-item" href="<c:url value="/product/product_search.do?product_category=가구"/>">가구/인테리어</a>
					<a class="collapse-item" href="<c:url value="/product/product_search.do?product_category=유아용"/>">유아용/유아도서</a>
					<a class="collapse-item" href="<c:url value="/product/product_search.do?product_category=생활"/>">생활/가공식품</a>
					<a class="collapse-item" href="<c:url value="/product/product_search.do?product_category=스포츠"/>">스포츠/레저</a>
					<a class="collapse-item" href="<c:url value="/product/product_search.do?product_category=여성잡"/>">여성잡화</a>
					<a class="collapse-item" href="<c:url value="/product/product_search.do?product_category=여성의"/>">여성의류</a>
					<a class="collapse-item" href="<c:url value="/product/product_search.do?product_category=남성패"/>">남성패션/잡화</a>
					<a class="collapse-item" href="<c:url value="/product/product_search.do?product_category=게임"/>">게임/취미</a>
					<a class="collapse-item" href="<c:url value="/product/product_search.do?product_category=뷰티"/>">뷰티/미용</a>
					<a class="collapse-item" href="<c:url value="/product/product_search.do?product_category=반려동"/>">반려동물용품</a>
					<a class="collapse-item" href="<c:url value="/product/product_search.do?product_category=티켓"/>">도서/티켓/음반</a>
					<a class="collapse-item" href="<c:url value="/product/product_search.do?product_category=기타"/>">기타 중고물품</a>
					<a class="collapse-item" href="<c:url value="/product/product_search.do?product_category=삽니다"/>">삽니다</a>
						
						
					</div>
				</div></li>

			<!-- 네비 배달 버튼 -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseUtilities"
				aria-expanded="true" aria-controls="collapseUtilities"> <i
					class="fas fa-truck-moving"></i> <span>배달</span>
			</a>
				<div id="collapseUtilities" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">배달정보</h6>
						
						
						<c:choose>
						<c:when test="${bedal_id == null }">
						<a class="collapse-item" href="../bedal_login/bedal_user_login.jsp">로그인</a> 
						</c:when>
						
						<c:otherwise>
						<a class="collapse-item" href="../bedal_login/bedal_user_login.jsp">로그아웃</a> 
						</c:otherwise>
						
						</c:choose>
						
						
						<c:choose>

									<c:when test="${bedal_id eq null}">
										<input type="hidden" >
										
									</c:when>

									<c:otherwise>
									
									<form action="../bedal/bedal_list/bedal_list.do">
									<button type="submit">배달정보</button>
									</form>
									
									</c:otherwise>

								</c:choose>
						
						
						
						
						
					</div>
				</div></li>
			<li class="nav-item"><a class="nav-link collapsed" href= "<c:url value="/admin/qa_algolism.do" />"
				> <i              
					class="fas fa-question-circle"></i> <span>Q&A추천 게시판</span>
			</a>
			
			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">





		</ul>
		<!-- End of Sidebar -->

		<!-- 여기까지가 좌측 네비 -->




		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>



		<!-- 상단 검색창 -->

  	<form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search" action="<c:url value="../product/product_search.do" />" >
            <div class="input-group">
              <input type="text" class="form-control bg-light border-0 small" placeholder="물품명을 검색해보세요!" name="product_title">
              <div class="input-group-append">
                <button class="btn btn-primary" type="submit" id="b1">
                  <i class="fas fa-search fa-sm"></i>
                </button>
              </div>
            </div>
          </form>





					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">




						<!-- 회원프로필 -->
						<!-- Nav Item - User Information -->


						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">

									<p
										style="font-size: 20px; font-weight: bold; color: black; margin-top: 12px">
										${user_id}</p>

							</span> <img class="img-profile rounded-circle"
								src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
						</a> <!-- Dropdown - User Information -->

							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								
								
								<c:choose>
								
								<c:when test="${bedal_id != null }">
								
								<input type="hidden"> 
							
								</c:when>
								
								<c:otherwise>
								
								<a class="dropdown-item" href="<c:url value="/user/profile/myprofile_onSale.jsp" />"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"
									id="myprofile"></i> 마이프로필
									</a> 
								
								</c:otherwise>
								
								
								</c:choose>
									
									
								<c:set var="user"></c:set>
								<c:if test="${user_id eq 'admin' }">
								<a class="dropdown-item" href="../admin/admin_index.jsp"> <i
									class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i> 관리자
								</a>
								</c:if>
								
								



								<div class="dropdown-divider"></div>

								<c:set var="user"></c:set>
								<c:choose>

									<c:when test="${user_id eq null}">
										<a class="dropdown-item" href="<c:url value="/user/login/user_login.jsp"/>"> <i
											class="glyphicon glyphicon-log-in"></i> 로그인
										</a>
									</c:when>

									<c:otherwise>
										<a class="dropdown-item" href="<c:url value="/user/login/user_login.jsp"/>"> <i
											class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i> 로그아웃

										</a>
									</c:otherwise>

								</c:choose>
							</div></li>

					</ul>

				</nav>

		<!-- Logout Modal-->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Ready to
							Leave?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">Select "Logout" below if you are
						ready to end your current session.</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancel</button>
						<a class="btn btn-primary" href="login.html">Logout</a>
					</div>
				</div>
			</div>
		</div>


</body>
</html>