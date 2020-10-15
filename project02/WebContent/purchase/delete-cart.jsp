<%@page import="bean.CartInfo"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
   	Vector<CartInfo> cart = (Vector<CartInfo>)session.getAttribute("cart");
    int idx = Integer.parseInt(request.getParameter("cartidx"));
    cart.remove(idx);
    session.setAttribute("cart", cart);
    %>