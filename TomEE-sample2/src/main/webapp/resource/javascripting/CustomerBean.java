<%@page import="com.model.Customer" pageEncoding="UTF-8"%>
<%
	
	Customer cust = new Customer();
	
	cust.setName("夜市王");
	cust.setEmail("nightMark@mail");
	cust.setPhone("99006");
	
	pageContext.setAttribute("cust", cust);
%>