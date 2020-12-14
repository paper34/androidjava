<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Custom fonts for this template-->
<link
	href="../resources/bootstrap/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="../resources/bootstrap/css/sb-admin-2.min.css"
	rel="stylesheet">
	
<div class="modal-header">
	<h5 class="modal-title" id="modal">유저상세</h5>
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>

<div class="modal-body">

	<div class="form-row">
		<div class="form-group col-lg-12">
			<label>아이디</label><br> <label>${one.user_id}</label>
		</div>
		<div class="form-group col-sm-9">
			<label>이름</label><br> <label>${one.user_name}</label>
		</div>
		<div class="form-group col-sm-9">
			<label>닉네임</label><br> <label>${one.user_nickname}</label>
		</div>

		<div class="form-group col-sm-9">
			<label>나이</label><br> <label>${one.user_age}</label>
		</div>
		<div class="form-group col-sm-9">
			<label>전화번호</label><br> <label>${one.user_tel}</label>

		</div>

		<div class="form-group col-sm-9">
			<label>이메일</label><br> <label>${one.user_email}</label>
		</div>
		<div class="form-group col-sm-9">
			<label>주소</label><br> <label style="width:500px">${one.user_address}</label>
		</div>
		<div class="form-group col-sm-9">
			<label>가입일</label><br> <label>${one.user_date}</label>
		</div>
	</div>

</div>


