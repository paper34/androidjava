<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert_book.jsp">
	<div style="margin-left: 800px">
	<h2>Book 서점</h2>
	책이름: <input type="text" placeholder="이름을 입력하세요." name="book_name"> <br> <br>
	책줄거리: <textarea  placeholder="책줄거리를 입력하세요" name="book_plot"></textarea> <br><br>
	출판사: <input type="text" placeholder="책판사를 입력하세요." name="book_publisher"><br><br>
	저자: <input type="text" placeholder="저자를 입력하세요."name="book_writer"><br><br>
	<button type="submit">저장</button>
	</div>
	</form>
</body>
</html>