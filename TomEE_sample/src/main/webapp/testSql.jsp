<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="resource/css/testSql.css">
</head>
<body>
	<!-- header -->
	<div>
		<%@include file="./component/header.html" %>
	</div>

	<!-- hero -->
	<sql:setDataSource driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/test" user="root" password="12345678" var="db"/>
	<sql:query var="rs" dataSource="${db}">select * from test.customer</sql:query>
	<table>
		<tbody>
			<tr>
				<th>cust_id</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>phone</th>
			</tr>
			<c:forEach items="${rs.rows}" var="cust" varStatus="status">
				<tr>
					<td>${cust.cust_id}</td>
					<td>${cust.first_name}</td>
					<td>${cust.last_name}</td>
					<td>${cust.phone}</td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
</body>
</html>