<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employee register form</title>
<link type="text/css" rel="stylesheet" href="resource/css/employeeLuv2Form.css">
</head>
<body>
	<!-- header 依賴內部css -->
	
	<%@include file="component/header.html" %>
	
	<!-- hero -->
	<div class="hero-emp hero">
		<form action="EmployeeLuv2FormServlet" method="post">
			<%-- 作用在編譯時期 --%>		
			<%@include file="component/employeeLuv2Table.html" %>
		</form>
	</div>
	
	<!-- footer -->
	
</body>
</html>