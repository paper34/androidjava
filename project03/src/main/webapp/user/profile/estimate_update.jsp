<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:setDataSource url="jdbc:mysql://localhost:3366/project03"
	driver="com.mysql.jdbc.Driver" user="root" password="1234"
	scope="application" var="db" />

<sql:update var="update" dataSource="${db}">
		UPDATE user_review SET review1_count = review1_count+?, review2_count = review2_count+?, review3_count = review3_count+?
		, review4_count = review4_count+?, review5_count = review5_count+?, review6_count = review6_count+?, review7_count = review7_count+?
		, review8_count = review8_count+? WHERE user_id = ?
		
		<sql:param value="${param.review1_count}" />
		<sql:param value="${param.review2_count}" /> 	
		<sql:param value="${param.review3_count}" />
		<sql:param value="${param.review4_count}" />	
		<sql:param value="${param.review5_count}" />
		<sql:param value="${param.review6_count}" />
		<sql:param value="${param.review7_count}" />
		<sql:param value="${param.review8_count}" />
		<sql:param value="${param.user_id}" />
</sql:update>

<% response.sendRedirect("../profile/myprofile_onSale.jsp");%>

