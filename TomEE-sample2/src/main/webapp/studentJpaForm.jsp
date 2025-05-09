<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使用 JPA 的後端程式管理頁面</title>
<link type="text/css" rel="stylesheet" href="resource/css/employeeLuv2Form.css">
</head>
<body>

	<!-- header -->
	<%@include file="./component/header.html" %>
	
	<!-- hero -->
	<div class="hero-set hero">		
		<form action="StudentJpaFormServlet" method="post">
			<%@include file="./component/studentJpaTable.html" %>
		</form>
	</div>
</body>
</html>