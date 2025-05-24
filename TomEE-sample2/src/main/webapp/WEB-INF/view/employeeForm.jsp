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
	<%-- 作用在編譯時期 --%>		
			<!--
	實際組合至 webapp/employeeForm.jsp
				<th>ID
				<th>last_name
				<th>first_name
				<th>email
				<th>departments
				<th>salary -->
	
	<%@include file="../../component/header.html" %>
	
	<!-- hero -->
	<div class="hero-set hero">
		<form action="EmployeeLuv2FormServlet" method="post">
		 	<h2 style="text-align: center">員工資料登入</h2>
			<table>
				<tbody>
					<tr>
						<td>Last_name</td>
						<td><input type="text" name="lastName"/></td>
					</tr>
					<tr>
						<td>First_name</td>
						<td><input type="text" name="firstName" /></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email" /></td>
					</tr>
					<tr>
						<td>Departments</td>
						<td><input type="text" name="department" /></td>
					</tr>
					<tr>
						<td>Salary</td>
						<td><input type="text" name="salary" pattern="\d*"/></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="submit" value="送出" /> 
						<input type="reset"  value="重製" /> 
						<input type="submit" formaction="index.html" value="首頁" /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	
	<!-- footer -->
	
</body>
</html>