<%@page import="bean.ReviewVO"%>
<%@page import="bean.ReviewDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
    String id = request.getParameter("id");
    String product_name = request.getParameter("product_name");
    String text = request.getParameter("text");
    String date = request.getParameter("date");
    
    ReviewDAO dao = new ReviewDAO();
    ReviewVO vo = new ReviewVO();
    vo.setId(id);
    vo.setProduct_name(product_name);
    vo.setText(text);
    vo.setDate(date);
    
    int result = dao.create(vo);
%><%=id%>,<%=text%>,<%=date%>