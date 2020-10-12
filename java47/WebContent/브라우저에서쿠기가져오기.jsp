<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[] list = request.getCookies();
		out.println("쿠키개수: " +  list.length + "개<br>");
	
		for (int i=0; i < list.length; i++) {
			if(!list[i].getName().equals("JSESSIONID")) {
				
	%>
			쿠키 이름: <%= list[i].getName() %>,
			쿠키 값: <%= list[i].getValue() %> <br>
			
			<% 
			}
		}
	
	%>
</body>
</html>