<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使用 JPA 的後端程式管理頁面</title>
<link type="text/css" rel="stylesheet" href="resource/css/employeeLuv2Form.css">
</head>
<body>

	<!-- header -->
	<%@include file="../../component/header.html" %>
	
	<!-- hero -->
	<div class="hero-set hero">		
		<form action="StudentJpaFormServlet" method="post">
			<h2 style="text-align: center">輸入班級資料：</h2>
		 	<table>
		 		<tbody>
		 			<tr>
		 				<th>學號</th>
		 				<td><input type="text" name="studentId" pattern="\d*" placeholder="10001"/></td>
		 			</tr>
		 			<tr>
		 				<th>姓名</th>
		 				<td><input type="text" name="name" placeholder="周杰倫"/></td>
		 			</tr>
		 			<tr>
		 				<th>班級</th>
		 				<td><input type="text" name="group" pattern="\d*\s年\s\d*\s班" placeholder="* 年 * 班"/></td>
		 			</tr>
		 			<tr>
		 				<th>成績</th>
		 				<td><input type="text" name="score" pattern="\d*" placeholder="0 ~ 100"/></td>
		 			</tr>
		 			<tr>
		 				<th>社團編號</th>
		 				<td><input type="text" name="club" pattern="\d*" placeholder="101 ~ 104"/></td>
		 			</tr>
		 			<tr>
		 				<td colspan="2">
		 					<input type="submit" value="送出"/>
		 					<input type="reset" value="重製" />
		 					<input type="submit" formaction="index.html" value="首頁" />
		 				</td> 				
		 			<tr>
		 		</tbody>
		 	</table>
		</form>
	</div>
</body>
</html>