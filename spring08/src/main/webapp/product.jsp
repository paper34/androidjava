<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상품등록</h1>
<form action="insert.do">
상품번호: <input type="text" name="no"><br>
상품명: <input type="text" name="name"><br>
상품설명: <input type="text" name="content"><br>
상품가격: <input type="text" name="price"><br>
<button type="submit" style="width: 200px; height: 50px; background-color: red; color: white;">
상품등록</button>
</form>

<h1>상품삭제</h1>
<form action="delete.do">
상품번호: <input type="text" name="no"><br>
<button type="submit" style="width: 200px; height: 50px; background-color: black; color: white;">
삭제</button>
</form>

<h1>상품가격 수정</h1>
<form action="update.do">
상품번호: <input type="text" name="no"><br>
상품가격: <input type="text" name="price"><br>
<button type="submit" style="width: 200px; height: 50px; background-color: steelblue; color: white;">
수정</button>
</form>

<h1>상품검색</h1>
<form action="one.do">
상품번호: <input type="text" name="no"><br>
<button type="submit" style="width: 200px; height: 50px; background-color: darkgray; color: white;">
검색</button>
</form>
<br>
<a style="font-size: 20px; font-weight: bold;" href="list.do">전체회원검색>></a>
</body>
</html>