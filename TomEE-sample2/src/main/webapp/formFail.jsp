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
	<%@include file="component/header.html" %>
	<!-- El 內建名稱 -->
	
	<!-- hero -->
	<div class="hero">
		<h1>填寫失敗</h1>
		<c:if test="${cookie.back.value != null}">
			<a href="${cookie.back.value}">回表單</a>
		</c:if>
	</div>
	
</body>
</html>