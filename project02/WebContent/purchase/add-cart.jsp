<%@page import="bean.CartInfo"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
    String name = request.getParameter("product_name");
    int adult = Integer.parseInt(request.getParameter("adult"));
    int teen = Integer.parseInt(request.getParameter("teen"));
    int child = Integer.parseInt(request.getParameter("child"));
    Vector<CartInfo> cart = null;
    if(session.getAttribute("cart") == null){
    	cart = new Vector<>();
    } else {
    	cart = (Vector<CartInfo>)session.getAttribute("cart");
    }
    CartInfo item = new CartInfo();
    item.setName(name);
    item.setAdult(adult);
    item.setTeen(teen);
    item.setChild(child);
    cart.add(item);
    session.setAttribute("cart", cart);
    %>