<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>전체회원검색</h3>
	<form action="list2.do">
		id <input type="text" name="id"><br> pw <input
			type="text" name="pw"><br> name <input type="text"
			name="name"><br> tel <input type="text" name="tel"><br>
		<button type="submit">전체회원 확인</button>
	</form>
	<br>
	
	<hr color="red"><br>
	 
	<h3>아이디로 회원검색</h3>
	<form action="one2.do">
		id <input type="text" name="id"><br>
		<button type="submit">검색확인</button>
	</form>
	<br>
	<hr color="orange"><br>
	
	<h3>회원가입</h3>
	<form action="create2.do">
		id <input type="text" name="id"><br> pw <input
			type="text" name="pw"><br> name <input type="text"
			name="name"><br> tel <input type="text" name="tel"><br>
		<button type="submit">가입 확인</button>
	</form>
	<br>
	
	<hr color="yellow"><br>
	
	<h3>회월탈퇴</h3>
	<form action="delete.do">
		id <input type="text" name="id"><br>
		<button type="submit">탈퇴 확인</button>
	</form>
	<br>
	<hr color="green"><br>
	
	<h3>회원수정</h3>
	<form action="update.do">
		id <input type="text" name="id"><br> pw <input
			type="text" name="pw"><br> name <input type="text"
			name="name"><br> tel <input type="text" name="tel"><br>
		<button type="submit">수정 확인</button>
	</form>
</html>