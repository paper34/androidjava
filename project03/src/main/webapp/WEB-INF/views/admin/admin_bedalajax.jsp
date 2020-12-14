<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Custom fonts for this template-->
<link href="../resources/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="../resources/bootstrap/css/sb-admin-2.min.css" rel="stylesheet">
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
	<script type="text/javascript">
	
	$(function(){
	$('.reject').click(function() {
		 result = confirm('거절하시겠습니까?');
		 var bedal_list_status = $(this).attr('id')
		 if(result == true){
		  	location.href ='admin_bedal_reject.do?bedal_list_status='+bedal_list_status
		  }
		  else{
			  return false;
		  } 
		})
		
	$('.accept').click(function () {
		 result = confirm('수락하시겠습니까?');
		 var bedal_list_status = $(this).attr('id')
		 if(result == true){
			 location.href ='admin_bedal_accept.do?bedal_list_status='+bedal_list_status+'&user_name='+'${one.user_name}'+'&user_email='+'${one.user_email}'
		 }
		else{
			  return false;
		  } 
		})
	
	$('.done').click(function () {
		result = confirm('배달이 완료되었습니까?');
		var bedal_list_status = $(this).attr('id')
		if(result == true){
	      	location.href ='admin_bedal_done.do?bedal_list_status='+bedal_list_status
		}			
		else{
			  return false;
		  } 
		})		
	}) 
	</script> 


<div class="modal-header">
	<h5 class="modal-title" id="modal">배달내역상세보기</h5>
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>

<div class="modal-body">
	    
	    
		<div class="form-row">
			<div class="form-group col-lg-12">
				<label>유저:</label> <label>${one.user_id}</label>
			</div>
			<div class="form-group col-lg-12">
				<label>배달유저:</label> <label>${one.bedal_id}</label>
			</div>
			
			<div class="form-group col-lg-12">
				<label>상품제목:</label> <label>${one.product_title}</label>
			</div>
			
			<div class="form-group col-sm-9">
				<label>배달지역:</label> <label>${one.user_address}</label>
			</div>
			

			<div class="form-group col-lg-12">
				<label>상품이미지</label> <label><img style="width:450px; height:250px;" src="../resources/img/${one.product_image}"></label>
			</div>
			
			<div class="modal-footer" style="width: 450px;">
				<button type="button" class="btn btn-primary accept" id='${one.bedal_list_status}' style="float: right">수락</button>
				<button type="button" class="btn btn-danger reject" id='${one.bedal_list_status}' style="float: right">거절</button>
				<button type="button" class="btn btn-success done" id='${one.bedal_list_status}' style="float: right">완료</button>
			</div>
			
			

		</div>
	
</div>


