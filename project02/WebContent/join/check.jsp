<%@page import="bean.MemberDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
   
    String id = request.getParameter("id");
    MemberDAO2 dao = new MemberDAO2();
    int result = dao.read(id);
   %><%= result %>