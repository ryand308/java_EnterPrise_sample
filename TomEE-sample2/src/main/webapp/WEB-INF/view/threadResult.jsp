<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>multithread with Executors</title>
</head>
<body>
	
	<h3>Response Thread:</h3>
	<h3>Name: <%=Thread.currentThread().getName() %> <br>
	   Time: <%= new Date() %> </h3>
</body>
</html>