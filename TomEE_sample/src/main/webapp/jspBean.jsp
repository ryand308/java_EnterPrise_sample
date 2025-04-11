<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使用JSP標準標籤</title>
<link rel="stylesheet" type="text/css" href="resource/css/jspBean.css">
</head>
<body>
	<jsp:useBean id="myBean" scope="page" class="com.model.Customer"></jsp:useBean>
	<table>
		<thead>
			<tr>
				<th>EL</th> <th>Value</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>\${myBean}</td> <td>${myBean}</td>
			</tr>
			<tr>
				<td>\${myBean.name}</td> <td>${myBean.name}</td>
			</tr>
			<tr>
				<td>\${myBean.email}</td> <td>${myBean.email}</td>
			</tr>
			<tr>
				<td>\${myBean.phone}</td> <td>${myBean.phone}</td>
			</tr>
		</tbody>
	</table>

	<%-- 使用jsp:include 不能被當作scripting 使用；會被看作純文字檔 --%>
	<%@include file="resource/javascripting/CustomerBean.java" %>
	<table>
		<thead>
			<tr>
				<th>EL</th> <th>Value</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>\${cust}</td> <td>${cust}</td>
			</tr>
			<tr>
				<td>\${cust.name}</td> <td>${cust.name}</td>
			</tr>
			<tr>
				<td>\${cust.email}</td> <td>${cust.email}</td>
			</tr>
			<tr>
				<td>\${cust.phone}</td> <td>${cust.phone}</td>
			</tr>
		</tbody>
	</table>
	<%-- property 對應 Costomer feild: private String Attribute; Object name: myBean;--%>
	<jsp:setProperty property="name" name="myBean" value="成龍"/>
	<jsp:setProperty property="email" name="myBean" value="kk@mail"/>
	<jsp:setProperty property="phone" name="myBean" value="+86"/>
	<table>
		<thead>
			<tr>
				<th>EL</th> <th>Value</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>\${myBean}</td> <td>${myBean}</td>
			</tr>
			<tr>
				<td>\${myBean.name}</td> <td>${myBean.name}</td>
			</tr>
			<tr>
				<td>jsp:getProperty property="name"</td> <td><jsp:getProperty name="myBean" property="name"/></td>
			</tr>
			<tr>
				<td>\${myBean.email}</td> <td>${myBean.email}</td>
			</tr>
			<tr>
				<td>jsp:getProperty property="email"</td> <td><jsp:getProperty name="myBean" property="email"/></td>
			</tr>
			<tr>
				<td>\${myBean.phone}</td> <td>${myBean.phone}</td>
			</tr>
			<tr>
				<td>jsp:getProperty property="phone"</td> <td><jsp:getProperty name="myBean" property="phone"/></td>
			</tr>
		</tbody>
	</table>
</body>
</html>