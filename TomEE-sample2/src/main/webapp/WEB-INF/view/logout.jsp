<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>重新填寫</title>
<link type="text/css" rel="stylesheet" href="resource/css/main.css" />
</head>
<body>

	<!-- header -->
	<%@include file="../../component/header.html" %>
	<!-- El 內建名稱 -->
	
	<!-- hero -->
	<div class="hero">
		<h3><%=request.getRemoteUser()%>&nbsp;has been logged out.</h3>
		<br/>
		<h4>
			<%if(request.getUserPrincipal() != null){ %>
				<%=request.getUserPrincipal().toString()%>
			<%} %>	
		</h4>
		<br/>
		<a href="index.html">首頁</a>
	</div>
	
</body>
</html>