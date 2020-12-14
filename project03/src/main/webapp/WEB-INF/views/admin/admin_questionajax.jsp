<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Custom fonts for this template-->
<link href="../resources/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="../resources/bootstrap/css/sb-admin-2.min.css" rel="stylesheet">

<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
	<script type="text/javascript">
	$(function() {
	 $('.answerinsert').click(function() {
		 result = confirm('등록하시겠습니까?');
		 var admin_answer = $('#qa_answer').val();
		 var qa_status = $(this).attr('id')
		 if(result == true){
		  	location.href ='question_answer.do?qa_no='+${one.qa_no}+'&admin_answer='+admin_answer+'&qa_status='+qa_status
		  }
		  else{
			  return false;
		  } 
		})
	}) 
	</script> 
<div class="modal-header">
	<h5 class="modal-title" id="modal">질문상세보기</h5>
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>

<div class="modal-body">
	    
	    
		<div class="form-row">
			<div class="form-group col-lg-12">
				<label>아이디</label> <label>${one.user_id}</label>
			</div>
			<div class="form-group col-lg-12">
				<label>게시물번호</label> <label>${one.qa_no}</label>
			</div>

			<div class="form-group col-lg-12">
				<label>제목</label> <label>${one.qa_title}</label>
			</div>
			<div class="form-group col-sm-9">
				<label>질문내용</label><br>
				<textarea class="form-control" maxlength="2048" style="height: 180px; width: 450px;">${one.qa_content}</textarea>
			</div>
			
			<div class="form-group col-sm-9">
				<label>답변</label><br>
				<textarea class="form-control" id="qa_answer" maxlength="2048" style="height: 180px; width: 450px;"></textarea>
			</div>
           
			<div class="modal-footer" style="width: 450px;">
				<button type="button" class="btn btn-primary answerinsert" id='${one.qa_status}' style="float: right">등록하기</button>
			</div>
			
			

		</div>
	
</div>


