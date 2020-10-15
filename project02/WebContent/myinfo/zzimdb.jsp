<%@page import="bean.ZzimDAO"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
    String id = (String)session.getAttribute("id");
    String name = request.getParameter("name");
	ZzimDAO dao = new ZzimDAO();
	int result = dao.read(name, id);
	//0이 넘어오면 검색결과 없음
	//1이 넘어오면 검색결과 있음
	
	if(result!=0){
		dao.delete(name, id);
	}else{
	dao.zzim(name, id);//누른 내역이 없으면 저장함
	}
	%><%= result %>