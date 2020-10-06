<%@page import="bean.CodeGenerator"%><%@page import="java.util.Random"%><%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%
	String tel = request.getParameter("tel");
	String code = tel.substring(0, 3);
	String result = "";
	StringBuffer temp = new StringBuffer("");
	CodeGenerator codeGenerator = new CodeGenerator();
	if (code.equals("010")) {
		temp.append("11");
		result = codeGenerator.generator(temp).toString();
		
	} else if (code.equals("011")) {
		temp.append("12");
		result = codeGenerator.generator(temp).toString();
	}%><%=result%>