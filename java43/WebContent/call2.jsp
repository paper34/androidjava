<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%
	String result = "재시험";
String exam = request.getParameter("exam");

if (Integer.parseInt(exam) >= 90) {
	result = "최우수";
} else if (Integer.parseInt(exam) >= 80) {
	result = "우수";
} else if (Integer.parseInt(exam) < 80) {
	result = "보통";
}
%><%=result%>