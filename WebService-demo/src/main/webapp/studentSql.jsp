<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Data Base Students</title>

</head>
<body>

	
	<!-- hero  -->
	<form action="StudentServlet" method="post">
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>學號</th>
					<th>姓名</th>
					<th>班級</th>
					<th>成績</th>
					<th>社團</th>					
				</tr>				
			</thead>
			<tbody>
				<c:forEach items="${students}" var="s" varStatus="status">
					<tr>
						<td>${s.id}</td>
						<td>${s.studentId}</td>
						<td>${s.name}</td>
						<td>${s.group}</td>
						<td>${s.score}</td>
						<td>${s.club}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>