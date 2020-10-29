<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert.do" >
	
	<div class="mb-3">

		<label for="title">글번호</label> <input type="text" class="form-control"
			name="no" placeholder="글번호을 입력해 주세요">

	</div>
	
	<div class="mb-3">

		<label for="title">제목</label> <input type="text" class="form-control" 
			name="title" placeholder="제목을 입력해 주세요">

	</div>

	<div class="mb-3">

		<label for="title">이름</label><input type="text" class="form-control" name="writer" id="writer"
			placeholder="이름을 입력해 주세요">

	</div>

		<div class="mb-3">

		<label for="content">내용</label>

		<textarea class="form-control" rows="5" name="content"
			style="height: 500px; placeholder="내용을 입력해 주세요"></textarea>

	</div>
	<button type="submit" class="btn btn-primary content-right">글작성</button>
	</form>
</body>
</html>