<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
    String reply = request.getParameter("reply");
	//파라메터값 받아주고
	//ReplyDAO로 댓글을 저장처리
	//성공하면, 저장된 댓글데이터를 전송
	String result = "-" +  reply + "<br>";
%><%=result%>