<%@page import="bean.ZzimDAO"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
    String id = (String)session.getAttribute("id");
    String name = request.getParameter("name");

    ZzimDAO dao = new ZzimDAO();
    dao.delete(name, id);
    
%>