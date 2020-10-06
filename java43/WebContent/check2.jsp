<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%
	String id = request.getParameter("id");
MemberDAO dao = new MemberDAO();
int result = dao.read(id);
String result1 = "<font color=blue>사용가능한 id입니다 </font>";
if (result == 0) {
	result1 = "<font color=red>사용불가능한 id입니다 </font>";
}%><%=result1%>