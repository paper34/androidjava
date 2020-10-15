<%@page import="bean.MemberDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
	1. 클라이언트가 입력해서 제출한 데이터를 받아와야 한다.
	2. DB연동해서 처리해서 결과 받아와야 한다.
	3. 받아온 결과에 따라서 화면을 html로 만들어서 클라이언트에게 전송한다.
 -->
<% //스크립트릿(scriptlet)
	//HttpServletRequest request = new HttpServletRequest();
	//내장된 객체
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	//자동import: 해당 클래스를 클릭하고, ctrl+shift+m
	MemberDAO2 dao = new MemberDAO2();
	boolean result = dao.read(id, pw); //false값 넘어오면 로그인 불가
	
    String redirectUrl = "login.jsp?error=login-failed"; // 인증 실패시 요청 될 url 
    if (result) {
    session.setAttribute("id", id); //로그인 성공시 세션 설정하기
    redirectUrl = "../main/index.jsp"; // 로그인 성공시 이동 페이지 url
    }
    response.sendRedirect(redirectUrl);   
%>
