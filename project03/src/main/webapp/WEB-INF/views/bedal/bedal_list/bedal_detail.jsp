<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배달 상세보기</title>
<link href="../../resources/bootstrap/css/sb-admin-2.css" rel="stylesheet"
	type="text/css">


<!-- javascript -->
<script type="text/javascript" src="../../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0d83259c940a3d4bd8bd4ac8dc6a450d&libraries=services"></script>
<script type="text/javascript">

	var json
	var bu = ${bu}
	console.log(bu)
	$(function() {
		$.ajax({
			url : "../bedal_list/bedal_detail1.do",
			success : function(detail) {
				json = detail; //받아온 데이터 json에 넣기
				console.log(json)
				
				$('#product_info').append(//div에 넣기
								"<p style='font-size:18px; font-weight: bold; margin:-5px 0 30px 0;'>주소 : "
										+ json[bu].user_address // 순서대로 json에 있는 데이터 꺼내주기
										+ "</p><div style='float:right;'><button id='b1' class='btn btn-primary address pull-right' style='width:150px; height: 50px; font-size: 20px;'>배달하기</button></div><br><h3 style='margin-right: 100px; margin-left: 10px; color: black;'>배달 상품</h3><div id='product_image' style='width: 200px; height: 300px;'>"
										/* +	"<img src=../../../../resources/img/"+ json[bu].product_image ">"// 이미지 꺼내기 */
										+ "</div><p style='font-size:20px'>거래상품명 : "
										+ json[bu].product_title // 상품명 꺼내기
										+ "</p><hr><p style='font-size:20px'>거래가격 : "+json[bu].payment_price+"")//가격 꺼내기
										
			
				$('#b1').click(function() {// 배달하기 버튼 눌렀을 때
					$.ajax({
						url : "../bedal_list/bedal_update.do", // 배달상태 변경
						data : {
							bedal_list_id : json[bu].bedal_list_id //json에서 배달리스트아이디 꺼내기
					},
					success : function(result) {// 성공했을 때
						alert("관리자의 배달 승낙을 기다려주세요!");
						$('#b1').attr('disabled', 'disabled');// 버튼 누르면 다시 못 누르게 버튼 막기
				}

			})
		}) // ajax
										
			
					var address = json[bu].user_address +""//user_address 받아옴
					var mapContainer = document.getElementById('map'), // 지도를 표시할 div
					mapOption = {
							center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
							level : 3// 지도의 확대 레벨
					};
				
						// 지도를 생성합니다
						var map = new kakao.maps.Map(mapContainer, mapOption);

						// 주소-좌표 변환 객체를 생성합니다
						var geocoder = new kakao.maps.services.Geocoder();

						// 주소로 좌표를 검색합니다.
						geocoder.addressSearch(
									address,
										function(result, status) {

											// 정상적으로 검색이 완료됐으면
											if (status === kakao.maps.services.Status.OK) {

													var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

											// 결과값으로 받은 위치를 마커로 표시합니다.
											var marker = new kakao.maps.Marker({
													map : map,
													position : coords
											});

											// 윈포윈도우로 장소에 대한 설명을 표시합니다.
											var infowindow = new kakao.maps.InfoWindow({
													content : '<div style="width:150px;text-align:center;padding:6px 0;">배달 목적지</div>'
											});
													
													infowindow.open(map, marker);

											// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다.
											map.setCenter(coords);

											var roadviewContainer = document.getElementById('roadview'); // 로드뷰 표시할 div
											var roadview = new kakao.maps.Roadview(roadviewContainer); // 로드뷰 객체
											var roadviewClient = new kakao.maps.RoadviewClient(); // 좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체

											// 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
											roadviewClient.getNearestPanoId(coords, 50, function(panoId) {
													roadview.setPanoId(panoId, coords); //panoId와 중심좌표를 통해 로드뷰 실행
											});
										}
								});

			}
			
			
		})
		
		

	}) // doc
</script>

</head>
<body>

	<!-- 지도 및 거리뷰 담는 div -->
	<h3 style="margin: 40px 0 20px 180px; color: black;">배달 목적지</h3>
	<div id="map"
		style="width: 500px; height: 350px; float: left; margin: -3px 0 15px 170px;"></div>
	<div id="roadview"
		style="width: 500px; height: 350px; float: left; margin-top: -3px"></div>

	<!-- 상품정보 담는 div -->
	<div id="product_info"
		style="float: left; display: inline; position: relative; margin-left: 170px; width: 1000px">

	</div>
	
</body>
</html>