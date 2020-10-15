<%@page import="bean.ItemDAO"%><%@page import="java.net.URLDecoder"%><%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%><%
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
    name = URLDecoder.decode(name, "utf-8");
    ItemDAO dao = new ItemDAO();
    int result = dao.likes(name);
%><%=result%>		