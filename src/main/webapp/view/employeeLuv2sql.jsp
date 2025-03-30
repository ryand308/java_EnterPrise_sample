<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmployeeLuv2 SQL DataBase</title>
<link type="text/css" rel="stylesheet" href="resource/css/employeeLuv2.css">
</head>
<body>
	
	<!-- header 依賴內部css -->
	<div class="header">
		<!-- 最好使用編譯的方式 -->
		<%@include file="../component/header.html" %>
	</div>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>last_name</th>
				<th>first_name</th>
				<th>email</th>
				<th>departments</th>
				<th>salary</th>	
				<th>delete</th>
				<th>modify</th>	
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${emp}" var="e" varStatus="status">
				<tr>
					<!-- e.對應的是Object getter() -->
					<td>${status.count}</td>
					<td>${e.lastName }</td>
					<td>${e.firstName }</td>
					<td>${e.email }</td>
					<td>${e.departments }</td>
					<td>${e.salary }</td>
					<td>
						<form action="EmployeeLuv2Servlet" method="post">
							<input type="hidden" value="${e.id}" name = "delete" />
							<input type="submit" value="刪除">
						</form>
					</td>
					<td>
						<form action="EmployeeLuv2UpdateServlet" method="get">
							<input type="hidden" value="${e.id}" name = "update" />							
							<input type="submit" value="修改">
						</form>
					</td>				
				</tr>
			</c:forEach>			
		</tbody>
	</table>
			
</body>
</html>