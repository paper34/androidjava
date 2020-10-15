<%@page import="bean.MemberDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 

	String name = request.getParameter("id");
 	String id = request.getParameter("kakaoid");

 	
    session.setAttribute("id", id); //로그인 성공시 세션 설정하기
    session.setAttribute("kakao", name);
    String redirectUrl = "loginok.jsp"; // 로그인 성공시 이동 페이지 url
    response.sendRedirect(redirectUrl); 
    
    //멤버 테이블에 카카오id가 없을때 저장
    
    MemberDAO2 dao = new MemberDAO2();
 	int result = dao.read(id);
 	if(result == 0){
    dao.create(id, name);
 	}
    
	 
%>
<html>
<h1><%= session.getAttribute("id") %>님을 환영합니다.</h1>
<h1><%= id %>님을 환영합니다.</h1>

</html>