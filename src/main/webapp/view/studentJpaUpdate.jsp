<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="resource/css/employeeLuv2Form.css">
</head>
<body>
<!--
	實際組合至 webapp/studentJpaForm.jsp
				<th>ID
				<th>學號 int
				<th>姓名 String
				<th>班級 String
				<th>成績 int 
				<th>社團 int(代號)

最基本：<input pattern="\d*" /> 防止後端NullpointException -->
	<!-- header -->
	<%@include file="../component/header.html" %>
	
	<!-- hero -->
	<div class="hero-set hero">
		<form action="StudentJpaUpdateServlet" method="post">
		
	 	<h2 style="text-align: center">輸入班級資料：</h2>
	 	<table>
	 		<tbody>
	 			<tr>
	 				<th>學號</th>
	 				<td><input type="text" name="studentId" pattern="\d*" placeholder="${student.studentId}"/></td>
	 			</tr>
	 			<tr>
	 				<th>姓名</th>
	 				<td><input type="text" name="name" placeholder="${student.name}"/></td>
	 			</tr>
	 			<tr>
	 				<th>班級</th>
	 				<td><input type="text" name="group" pattern="\d*\s年\s\d*\s班" placeholder="${student.group}"/></td>
	 			</tr>
	 			<tr>
	 				<th>成績</th>
	 				<td><input type="text" name="score" pattern="\d*" placeholder="${student.score}" /></td>
	 			</tr>
	 			<tr>
	 				<th>社團編號</th>
	 				<td><input type="text" name="club" pattern="\d*" placeholder="${student.club}"/></td>
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