<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%
	//String pay = request.getParameter("pay");
String paym = request.getParameter("paym");

int pay = Integer.parseInt(request.getParameter("pay"));

String result = String.valueOf(pay);

switch (paym) {

case "1": {
	result = "<font color=blue>결제방법 : 계좌이체, 결제금액: " + pay + "</font>";
	

	break;
}


case "2":{
	pay = pay + 1000;
	
	result = "<font color=blue>결제방법 : 신용카드, 결제금액: " + pay + "</font>";
	break;
}
	
case "3": {
	pay = pay - 1000;
	
	result = "<font color=blue>결제방법 : 휴대폰, 결제금액: " + pay + "</font>";
	break;
}
	
	
}
%><%=result%>
