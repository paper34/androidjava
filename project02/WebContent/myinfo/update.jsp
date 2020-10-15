<%@page import="bean.MemberDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!-- 액션태그 -->
<!--넘어오는 4개의 값을 받아서 vo에 넣어준다  -->
<jsp:useBean id="vo" class="bean.MemberVO2"></jsp:useBean>
<!--useBean액션태그 : new를 가지고 객체생성, import역할도 같이 가지고 있음  -->
<jsp:setProperty property="*" name="vo" />

<!--setProperty액션태그: 클라이언트가 전송한 파라메터 받아오고,
vo의 set() 메서드 호출해줌  -->

<!--dao를 이용해서 update 한다  -->
<%
MemberDAO2 dao = new MemberDAO2();
out.println(vo);
boolean result = dao.update(vo);

%>