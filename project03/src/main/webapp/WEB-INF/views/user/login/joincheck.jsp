<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    
<sql:setDataSource url="jdbc:mysql://localhost:3366/project03"
		driver="com.mysql.jdbc.Driver" user="root" password="1234"
		scope="application" var="db" />
		
<sql:update var="insert" dataSource="${db}">
		insert into user_review(user_id, review1_count, review2_count, review3_count, review4_count,
		review5_count, review6_count, review7_count, review8_count
		) values (?, '0', '0', '0', '0', '0', '0', '0', '0')
		<sql:param value="${param.user_id}" />
</sql:update>


<% response.sendRedirect("../../../../project/user/login/user_login.jsp");%> 



