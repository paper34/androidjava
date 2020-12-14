<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap -->
<link href="../../resources/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="../../resources/bootstrap/css/sb-admin-2.css" rel="stylesheet" type="text/css">

<!-- css -->
<link href="../../resources/bootstrap/css/bedallist.css" rel="stylesheet" type="text/css">

<!-- javascript -->
<script type="text/javascript" src="../../resources/js/jquery-3.5.1.js"></script>


<script type="text/javascript">

	
	$(function() {
		$('#edit').click(function() {
			$.ajax({
				url : "../bedal_list/bedal_profile.do", //배달 마이프로필 수정
				data : {
					
					bedal_nickname : $('#bedal_nickname').val(),
					bedal_vehicle : $('#bedal_vehicle').val(),
					sido1 : $('#sido1').val(),
					gugun1 : $('#gugun1').val(),
					sido2 : $('#sido2').val(),
					gugun2 : $('#gugun2').val()
				},
				success : function(result) {
						
						alert("수정 되었습니다!");
						
				}
			})
		})
	})

	//테이블 스크롤 
	$(window).on("load resize",
			function() {
				var scrollWidth = $('.tbl-content').width()
						- $('.tbl-content table').width();
				$('.tbl-header').css({
					'padding-right' : scrollWidth
				});
			}).resize();

	// 지역 선택
	$('document').ready(
			function() {
				var area0 = [ "시/도 선택", "서울특별시", "인천광역시", "대전광역시", "광주광역시", "대구광역시", "울산광역시", "부산광역시", "경기도",
								"강원도", "충청북도", "충청남도", "전라북도", "전라남도", "경상북도", "경상남도", "제주도" ];
				var area1 = [ "강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구",
								"마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구" ];
				var area2 = [ "계양구", "남구", "남동구", "동구", "부평구", "서구", "연수구", "중구", "강화군", "옹진군" ];
				var area3 = [ "대덕구", "동구", "서구", "유성구", "중구" ];
				var area4 = [ "광산구", "남구", "동구", "북구", "서구" ];
				var area5 = [ "남구", "달서구", "동구", "북구", "서구", "수성구", "중구", "달성군" ];
				var area6 = [ "남구", "동구", "북구", "중구", "울주군" ];
				var area7 = [ "강서구", "금정구", "남구", "동구", "동래구", "부산진구", "북구", "사상구", "사하구", "서구", "수영구", "연제구", "영도구",
								"중구", "해운대구", "기장군" ];
				var area8 = [ "고양시", "과천시", "광명시", "광주시", "구리시", "군포시", "김포시", "남양주시", "동두천시", "부천시", "성남시", "수원시",
								"시흥시", "안산시", "안성시", "안양시", "양주시", "오산시", "용인시", "의왕시", "의정부시", "이천시", "파주시", "평택시",
								"포천시", "하남시", "화성시", "가평군", "양평군", "여주군", "연천군" ];
				var area9 = [ "강릉시", "동해시", "삼척시", "속초시", "원주시", "춘천시", "태백시", "고성군", "양구군", "양양군", "영월군", "인제군",
								"정선군", "철원군", "평창군", "홍천군", "화천군", "횡성군" ];
				var area10 = [ "제천시", "청주시", "충주시", "괴산군", "단양군",
								"보은군", "영동군", "옥천군", "음성군", "증평군", "진천군", "청원군" ];
				var area11 = [ "계룡시", "공주시", "논산시", "보령시", "서산시", "아산시", "천안시", "금산군", "당진군", "부여군", "서천군",
								"연기군", "예산군", "청양군", "태안군", "홍성군" ];
				var area12 = [ "군산시", "김제시", "남원시", "익산시", "전주시", "정읍시", "고창군", "무주군", "부안군", "순창군", "완주군",
								"임실군", "장수군", "진안군" ];
				var area13 = [ "광양시", "나주시", "목포시", "순천시", "여수시", "강진군", "고흥군", "곡성군", "구례군", "담양군", "무안군",
								"보성군", "신안군", "영광군", "영암군", "완도군", "장성군","장흥군", "진도군", "함평군", "해남군", "화순군" ];
				var area14 = [ "경산시", "경주시", "구미시", "김천시", "문경시", "상주시", "안동시", "영주시", "영천시", "포항시", "고령군",
								"군위군", "봉화군", "성주군", "영덕군", "영양군", "예천군","울릉군", "울진군", "의성군", "청도군", "청송군", "칠곡군" ];
				var area15 = [ "거제시", "김해시", "마산시", "밀양시", "사천시", "양산시", "진주시", "진해시", "창원시", "통영시", "거창군",
								"고성군", "남해군", "산청군", "의령군", "창녕군", "하동군","함안군", "함양군", "합천군" ];
				var area16 = [ "서귀포시", "제주시", "남제주군", "북제주군" ];

				
			// 시/도 선택 박스 초기화
			$("select[name^=sido]").each(
					function() { 
						$selsido = $(this);
						$.each(eval(area0),function() {
							$selsido.append("<option value='"+this+"'>"+ this+ "</option>");
								
						});
							$selsido.next().append("<option value=''>구/군 선택</option>");
							
						});

			
			// 시 선택시 구 설정
			$("select[name^=sido]").change(
					function() { // ^= 속성지정하는 
						var area = "area" + $("option", $(this)).index($("option:selected", $(this))); // 선택지역의 구군 Array
						var $gugun = $(this).next(); // 선택영역 군구 객체
						$("option", $gugun).remove(); // 구군 초기화
						
							if (area == "area0")
								$gugun.append("<option value=''>구/군 선택</option>");
							else {
								$.each(eval(area),
										
						function() {
								$gugun.append("<option value='"+this+"'>"+ this + "</option>");
										
						});
			}
	});
			
			 $('#detail').click(function() {//상세보기 버튼 눌렀을 때
	                y = $(this).val(); //버튼의 값 가져오기
	                lately(y);//lately함수에 값 적용
	            })
	                
	});
	function lately(x1, x2, x3, x4) {//lately함수
	    $.ajax({
	        url : "../bedal_list/bedal_lately.do",//최근 조회목록 요청 주소
	        data : {
	            bedal_list_id : x1, //x는 함수에 적용된 값
	            product_title : x2,
	            user_address : x3,
	            payment_price : x4
	        },
	        success : function(list2){
	            json = list2; //json에 결과값 넣기
	            console.log(json[0].product_title);
	            for (var i = 0; i < list2.length; i++) {
	                $('#late').append( //late div에 넣기
	                    "<tr><td>" + json[i].product_title +" / "+ json[i].user_address +" / "+ json[i].payment_price + "</td></tr>"
	                    //한 행으로 json에 있는 데이터 순서대로 꺼내주기
	                    
	                    
	                    )
	                }
	        }
	    })
	} 	
			

</script>



<title>배달 항목</title>

</head>
<body>
	<section>
		<!--for demo wrap-->
		<h1>배달 목록</h1>
		<div class="tbl-header">
			<table cellpadding="0" cellspacing="0" border="0">
				<thead>
					<tr>
						<th>거래상품명</th>
						<th>거래가격</th>
						<th>목적지</th>
						<th>결제 날짜</th>
						<th>상세보기</th>
					</tr>
				</thead>
			</table>
		</div>

		<div class="tbl-content">
			<table cellpadding="0" cellspacing="0" border="0">
				<tbody>
					<c:forEach var="alvo" items="${algolist}" varStatus="status">
						<!-- blvo -> 배달리스트 vo / status가 foreach에서 index -->
						<tr>
							<!-- 배달 목록 불러오기 -->
							<td>${alvo.product_title}</td>
							<td>${alvo.payment_price}</td>
							<td>${alvo.user_address}</td>
							<td>${alvo.payment_date}</td>
							<td><button class="btn btn-primary address pull-right" id="bedal_detail" value="${alvo.bedal_list_id}"
                                    onclick="window.open('../bedal_list/bedal_detail.do?button_index=${status.index}', 
                                                'bedal_detail', 'width=1200, height=950'); lately(${alvo.bedal_list_id},'${alvo.product_title}','${alvo.user_address}',${alvo.payment_price})">상세보기</button></td>
                        </tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</section>

	<section>
		<!--for demo wrap-->
		<h1>마이프로필</h1>
		<div class="tbl-header">
			<table>
				<thead>
					<tr>
						<th>나의 정보</th>
						<th>나의 배달내역</th>
						<th>배달 승인여부</th>
						<th>최근 조회 목록</th>
					</tr>
				</thead>
			</table>
		</div>

 
		<!-- 마이프로필 불러오기 -->
		<sql:setDataSource 
			url="jdbc:mysql://localhost:3366/project03"
			driver="com.mysql.jdbc.Driver" 
			user="root" 
			password="1234"
			scope="application" 
			var="db" />

		<!-- 마이프로필 sql문 -->
		<sql:query var="mylist" dataSource="${db}">
				select bedal_id, bedal_nickname, bedal_vehicle, sido1, gugun1,
						sido2, gugun2, bedal_image from bedal_user where bedal_id = '${bedal_id}'
			</sql:query>


		
		<div class="tbl-content">
		<!-- 마이프로필!! -->
		<div style="width:28%; float: left; position: relative;">
				<c:forEach var="buvo" items="${mylist.rows}"> <!-- 배달유저의 이미지 -->
						<img src= "../../resources/img/bedal_user/${buvo.bedal_image}" style="width: 230px; height: 295px; float: left;">
							
							<p style="float: left; color: black; padding: 10px;">닉네임 :</p>
							<input type="text" name="bedal_nickname" id="bedal_nickname"
								style="margin: 10px 0 3px 5px;" value="${buvo.bedal_nickname}">
							<br>

							<p style="float: left; color: black; margin-left: -70px; margin-bottom: 5px;">아이디 : &nbsp;${bedal_id}</p>
							<br>
							
							<!-- 배달유저의 운송수단 -->
							<p style="float: left; color: black; margin-left: -95px">운송수단</p> &nbsp;
					<select name="bedal_vehicle" id="bedal_vehicle" style="margin-bottom: 20px;">
								<option value="선택">${buvo.bedal_vehicle}</option>
								<option value="도보">도보</option>
								<option value="자전거">자전거</option>
								<option value="전동킥보드">전동 킥보드</option>
								<option value="오토바이">오토바이</option>
								<option value="승용차">승용차</option>
								<option value="트럭">트럭</option>
							</select>


							<br><!-- 배송할 지역 -->
							<p style="float: left; color: black; padding: 10px;">배송할 지역</p>
							<select name="sido1" id="sido1" style="margin-bottom: 5px;">
								<option value="${buvo.sido1}">${buvo.sido1}</option>
							</select>
							<select name="gugun1" id="gugun1">
								<option value="${buvo.gugun1}">${buvo.gugun1}</option>
							</select> *
						<br>
							<select name="sido2" id="sido2" style="margin-bottom: 5px;">
								<option value="${buvo.sido2}">${buvo.sido2}</option>
							</select>
							<select name="gugun2" id="gugun2" style="margin-bottom: 20px;">
								<option value="${buvo.gugun2}">${buvo.gugun2}</option>
							</select>
						</c:forEach>

							<br><!-- 수정버튼 -->
							<button id="edit" class="btn btn-primary address pull-right"
								type="submit" style="float: right; margin-right: 15px;">수정</button>
							<br>


						</div><!-- 마이프로필!! -->
				
				
				
					<!-- 나의 배달내역 sql문 -->
					<sql:query var="com_list" dataSource="${db}">
						select pr.product_title, py.payment_price from product pr, payment py, bedal_list bl, bedal_user bu 
							where bl.product_id = pr.product_id and bl.payment_id = py.payment_id and bedal_list_status = '1'
							and bu.bedal_id = '${bedal_id}'; 
					</sql:query>
				
				
					<!-- 나의 배달내역 -->
					<div style="width: 24%; float: left; display: inline;" class="tbl-content">
						<table>
						<c:forEach var="cvo" items="${com_list.rows}">
								<tr>
									<td style="font-size:14px;">
										<p style="font-weight: bold;">배달상품명 </p>${cvo.product_title}</td>
									<td style="font-size:14px;">
										<p style="font-weight: bold;">거래가격  </p>${cvo.payment_price}</td>
								</tr>
							
						</c:forEach>
						</table>
					</div>
					
					
					
					<!-- 배달 승인 여부 목록 -->
					<div style="width:25%; float:left; position: relative;" class="tbl-content">
						<table>
							<c:forEach var="apro" items="${approval}">
							<tr>
								<td style="font-size:14px;">
									<p style="font-weight: bold;">배달상품명 </p>${apro.product_title}</td>
								<td style="font-size:14px;">
									
								<p style="font-weight: bold;">승인결과 </p>
								<span>
								<!-- 배송상태 -->
								<c:choose>
								<c:when test="${apro.bedal_list_status == '-1'}">
									<c:set value="배송전(승인)" var="service"></c:set>
								</c:when>
								
								<c:when test="${apro.bedal_list_status == '0'}">
									<c:set value="배송중" var="service"></c:set>								
								</c:when>
								
								<c:otherwise>
									<c:set value="배송거절" var="service"></c:set>								
								</c:otherwise>
								
								</c:choose>							
									${service}	
									</span>
									</td>
							</tr>
							</c:forEach>
						</table>
					</div>
					
					
					<!-- 최근 조회 목록 -->
					<div style="width:23%; float: right; position: relative;" class="tbl-content">
						<table id="late">

						</table>
					</div>

		</div>


	</section>

</body>
</html>