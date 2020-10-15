<%@page import="bean.ZzimDAO"%>
<%@page import="java.util.Vector"%>
<%@page import="bean.ReviewVO"%>
<%@page import="bean.ReviewDAO"%>
<%@page import="string.StringExtractor"%>
<%@page import="bean.ItemVO"%>
<%@page import="bean.ItemDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
    String name = request.getParameter("name");
    
    ItemDAO dao = new ItemDAO();
    ItemVO vo = dao.one(name);
    if(vo == null) vo = new ItemVO();
 	
    ZzimDAO zzdao = new ZzimDAO();
    int zzim = zzdao.zzimcount(name);
    
    
    int view = dao.view(name);
    int like = vo.getLikes();
    
    String imgsrc="https://dummyimage.com/1500x400/ffd47e/FFEFA0&text=JejuTravel";
    
    //괄호가 있는 이름일 경우 2단제목으로 표기
    String nameMain = name;
    String nameSub = "";
    if(nameMain.indexOf("(") != -1){
	    nameMain = StringExtractor.extractor("","(",name);
	    nameSub = StringExtractor.extractor(nameMain,name);
    }
    
    //태그 텍스트를 공백 지우고 ","구분자를 기준으로 모두 나누기
    String[] keywordname = vo.getKeyword().replaceAll(" ","").split(",");
    String product_name = request.getParameter("product_name"); 
	
    //리뷰관리
    ReviewDAO rvdao = new ReviewDAO();
    Vector<ReviewVO> rvbag = rvdao.read(name);
    int reviewcount = rvbag.size();
    
    String id = null;
    if(session.getAttribute("kakao") == null) {
    	if(session.getAttribute("id") != null) {
    		id = (String)session.getAttribute("id");
    	}
    } else {
    	id = (String)session.getAttribute("kakao");
    }
    int isZzim = zzdao.read(name, id);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- css -->
<link href="../css/main2.css" rel="stylesheet" type="text/css">
<link href="../css/detail.css?after" type="text/css" rel="stylesheet">
<!-- js -->
<script>
	$(function() {
		//Date.format 정의
		Date.prototype.format = function (f) {
		    if (!this.valueOf()) return " ";
		    var weekKorName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
		    var weekKorShortName = ["일", "월", "화", "수", "목", "금", "토"];
		    var weekEngName = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
		    var weekEngShortName = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
		    var d = this;
		    return f.replace(/(yyyy|yy|MM|dd|KS|KL|ES|EL|HH|hh|mm|ss|a\/p)/gi, function ($1) {
		        switch ($1) {
		            case "yyyy": return d.getFullYear(); // 년 (4자리)
		            case "yy": return (d.getFullYear() % 1000).zf(2); // 년 (2자리)
		            case "MM": return (d.getMonth() + 1).zf(2); // 월 (2자리)
		            case "dd": return d.getDate().zf(2); // 일 (2자리)
		            case "KS": return weekKorShortName[d.getDay()]; // 요일 (짧은 한글)
		            case "KL": return weekKorName[d.getDay()]; // 요일 (긴 한글)
		            case "ES": return weekEngShortName[d.getDay()]; // 요일 (짧은 영어)
		            case "EL": return weekEngName[d.getDay()]; // 요일 (긴 영어)
		            case "HH": return d.getHours().zf(2); // 시간 (24시간 기준, 2자리)
		            case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2); // 시간 (12시간 기준, 2자리)
		            case "mm": return d.getMinutes().zf(2); // 분 (2자리)
		            case "ss": return d.getSeconds().zf(2); // 초 (2자리)
		            case "a/p": return d.getHours() < 12 ? "오전" : "오후"; // 오전/오후 구분
		            default: return $1;
		        }
		    });
		};
		String.prototype.string = function (len) { var s = '', i = 0; while (i++ < len) { s += this; } return s; };
		String.prototype.zf = function (len) { return "0".string(len - this.length) + this; };
		Number.prototype.zf = function (len) { return this.toString().zf(len); };
		
		$('#zzim').click(function() {
			<%if(session.getAttribute("id")!=null) {%> <!-- 세션이 있다 로그인 상태 -->
				//찜버튼 클릭시 여행지의 이름과 회원의 아이디 db저장
				//찜 테이블에 여행지 이름을 검색해보고 없으면 저장함
				//있으면 삭제함 (취소할까요? 물어보기)
				$.ajax({
					url : "../myinfo/zzimdb.jsp", //있는지 없는지 검색만 하기
				data: {
					name : "<%=vo.getName() %>"			
				},
				success : function(result) {
					//있으면 삭제함 (취소할까요? 물어보기)
					console.log(result)
					if (result==1) {
						alert("찜이 삭제되었습니다")
						$('#zzim>p:nth-child(2)').text(parseInt($('#zzim>p:nth-child(2)').text())-1);
						$('#zzim').removeClass('zzimed');
					}else {
						alert("찜되었습니다")
						$('#zzim>p:nth-child(2)').text(parseInt($('#zzim>p:nth-child(2)').text())+1);
						$('#zzim').addClass('zzimed');
					}   
					 
				}//success
			})//ajax
				
			<%}else{ %> <!-- 세션끊김 로그아웃 상태 -->	
				alert('로그인이 필요한 서비스 입니다')
			<%} %>
				
				//alert("찜버튼 클릭")
			})//click
		
		$('#like-button').click (function () {
			$.ajax({
				url:"like.jsp",
				data: {
					name: "<%=name%>"
				},
				success: function(result) {
					$('#like-button>p:nth-child(2)').text(result);
				}
			})
		})
		$('#submit').click (function() {
			$.ajax({
				url:"review.jsp",
				data: {
					id: "<%=id%>",
					product_name: "<%=name%>",
					text: $('#rvtext').val(),
					date: new Date().format('yyyy-MM-dd HH:mm:ss')
				},
				success: function(result) {
					parameter = result.split(',')
					pre = $("#review-area").html()
					post = `<div class="card">
					<div class="card-header">작성자:` + parameter[0] + ` / 작성일시: ` + parameter[2] + ` </div>
					<div class="card-body">` + parameter[1] + `</div>
					</div><br>`
					$("#review-area").html(post + pre)
					$("#review-button>p:nth-child(2)").text(parseInt($("#review-button>p:nth-child(2)").text())+1)
					$("#rvtext").val('')
				}
			})
		})
	})
</script>
</head>
<body>

<jsp:include page="../layout/main-head.jsp"></jsp:include>

<div id="main-info-wrapper">
	<div id="main-info-image"><img src=<%=imgsrc %> style="margin-top: 130px"></div>
	<div id="main-info" style="margin-top: 130px">
		<input id="name" name="name" type="hidden" value="<%=vo.getName() %>">
		<h2><%=nameMain %></h2>
		<h3><%=nameSub %></h3>
		<p></p>
		<p><% for(int i=0; i<keywordname.length; i++) { 
			%>#<%=keywordname[i]%> <%
			}%></p>
	</div>
	
	<div id="main-info" class="second">
		<h3>기본정보</h3>
		<hr>
		<table>
			<tr>
				<td>주소</td>
				<td><%=vo.getAddress() %></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><%=vo.getTel() %></td>
			</tr>
		</table>
	</div>
</div>	
<div id="item-pay-wrapper" class="flex">
	<button onclick="location.href = '../purchase/buy-main.jsp?cart=yes&name=<%=name %>'"
			class="btn btn-default">장바구니</button>
	<button onclick="location.href = '../purchase/buy-main.jsp?cart=no&name=<%=name %>'"
			class="btn btn-warning">결제하기</button>
</div></form>
<div id="item-menu-wrapper">
	<ul class="flex">
		<li>
			<button id="like-button" class="btn btn-default">
				<p><span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span></p>
				<p><%=like %></p>
				<p>좋아요</p>
			</button>
		</li>					
		<li>
			<button class="btn btn-default <%if(isZzim==1) { %>zzimed<% } %>" id="zzim">
				<p><span class="glyphicon glyphicon-heart" aria-hidden="true"></span></p>
				<p><%=zzim %></p>
				<p>찜</p>
			</button>
		</li>
		<li>
			<button id="review-button" class="btn btn-default">
				<p><span class="glyphicon glyphicon-comment" aria-hidden="true"></span></p>
				<p><%=reviewcount %></p>
				<p>리뷰</p>
			</button>
		</li>
		<li>
			<button class="btn btn-default">
				<p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></p>
				<p><%=view %></p>
				<p>조회수</p>
			</button>
		</li>
	</ul>
</div>

<div id="item-text">
	<ul class = "nav nav-pills">
		<li class="nav-item">
			<a class="nav-link active" data-toggle="tab" href="#detail">정보</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" data-toggle="tab" href="#mapnav">지도</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" data-toggle="tab" href="#review">리뷰</a>
		</li>
	</ul>
	<div style="height: 50px"></div>
	<div class="tab-content">
		<div class="tab-pane fade show active" id="detail">
			<p><%=vo.getText() %></p>
		</div>
		<div class="tab-pane fade" id="mapnav">
			<div id="map"></div>
		</div>
		<div class="tab-pane fade" id="review">
			<% if(session.getAttribute("kakao") == null
			   && session.getAttribute("id") == null) {
			%><div class="alert alert-warning">로그인 후에 리뷰 등록 가능합니다.</div><%
			} else {
			%><table>
				<tr>
					<td><textarea class="form-control" name="reviewtext" cols="100%" rows="3" id="rvtext"></textarea></td>
					<td><button class="btn btn-warning" type="submit" id="submit">등록</button></td>
				</tr>
			</table>
			<% } %>
			<div id="review-area">
				<% for (int i=rvbag.size(); i>0; i--) {
					ReviewVO rvvo = rvbag.get(i-1); 
				%>
				<div class="card">
					<div class="card-header">작성자: <%=rvvo.getId() %> / 작성일시: <%=rvvo.getDate() %></div>
					<div class="card-body"><%=rvvo.getText() %></div>
				</div>
				<br>
				<% } %>
			</div>
		</div>
	</div>
</div>

<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCJEalzBFAur1DlCax9kfJ0T4Kh8j87WAc&callback=initMap&region=kr"></script>
<script>
    function initMap() {
      var location = { lat: <%=vo.getLat()%> , lng: <%=vo.getLng()%> };
      var map = new google.maps.Map(
        document.getElementById('map'), {
          zoom: 14,
          center: location
        });
      new google.maps.Marker ({
    	  position: location,
    	  map: map,
    	  label: "<%=vo.getName()%>"
      })
      
    }
</script>
</body>
</html>