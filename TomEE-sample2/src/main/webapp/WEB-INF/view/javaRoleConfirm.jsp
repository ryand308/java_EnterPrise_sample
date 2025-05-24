<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="resource/css/javaRoleConfirm.css">
</head>
<body>

	<section>
		<table>
			<thead>
				<tr>
					<th>狀態</th>
					<th>使用者名稱：</th>
					<th colspan="2">系統</th>					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList}" var="user">
					<tr>						
						<c:if test="${user.active}">
							<td><h3>☑️</h3></td>
						</c:if>
						<c:if test="${!user.active}">
							<td><h3>❎</h3></td>
						</c:if>
						<td>${user.userName}</td>
						<td>
							<form action="JavaRoleConfirmServlet" method="post">
								<input type="hidden" name="user" value="${user.userName}">
								<input type="hidden" name="active" value="true">
								<input type="submit" value="啟用">
							</form>
						</td>
						<td>
							<form action="JavaRoleConfirmServlet" method="post">
								<input type="hidden" name="user" value="${user.userName}">
								<input type="hidden" name="active" value="false">
								<input type="submit" value="封鎖">
							</form>
						</td>
					</tr>					
				</c:forEach>
				
			</tbody>
		</table>
		<a href="./index.html">首頁</a>
	</section>
</body>
</html>