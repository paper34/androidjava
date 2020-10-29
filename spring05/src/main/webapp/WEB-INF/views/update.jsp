<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>나는 수정하는 페이지</h1> <br>
검색결과 : ${bbsVO2} <br>
번호: ${bbsVO2.no} <br>
내용: ${bbsVO2.content} <br>
제목: ${bbsVO2.title} <br>
작성자: ${bbsVO2.writer} <br>
<hr color="green">
<a href="delete.do">삭제하기!</a>
</body>
</html>