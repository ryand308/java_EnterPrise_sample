<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="resources/css/mainList.css">
</head>
<body>
	
	<div>
		<h2>會員清單</h2>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>name</th>
					<th>sex</th>
					<th>address</th>
					<th>phone</th>
				</tr>
			</thead>
			<tbody>
				<!-- forEach to Member list -->
				<c:forEach items="${members}" var="member" varStatus="status">
					<tr>
						<td>${member.id}</td>
						<td>${member.name}</td>
						<td>${member.sex}</td>
						<td>${member.address}</td>
						<td>${member.phone}</td>					
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>