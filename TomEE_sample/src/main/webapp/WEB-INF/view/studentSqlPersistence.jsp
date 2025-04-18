<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Data Base Students</title>
<link type="text/css" rel="stylesheet" href="resource/css/studentSql.css" />
</head>
<body>

	<!-- header -->
	<%@include file="../../component/header.html" %>
	
	<!-- hero  -->	
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>學號</th>
					<th>姓名</th>
					<th>班級</th>
					<th>成績</th>
					<th>社團</th>
					<th>刪除</th>
					<th>更新</th>
				</tr>				
			</thead>
			<tbody>
				<c:forEach items="${stu1}" var="s" varStatus="status">
					<tr>
						<td style="width: 50px;">${s.id}</td>
						<td>${s.studentId}</td>
						<td style="width: 150px;">${s.name}</td>
						<td style="width: 150px;">${s.group}</td>
						<td style="width: 100px;">${s.score}</td>
						<td style="width: 100px;">${s.club}</td>
						<td>
							<form action="StudentPersistenceServlet" method="post">
								<input type="hidden" name="delete" value="${s.id}"/>
								<input type="submit" value="刪除" />
							</form>
						</td>
						<td>
							<form action="StudentJpaUpdateServlet" method="get">
								<input type="hidden" name="update" value="${s.id}"/>
								<input type="submit" value="更新" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
</body>
</html>