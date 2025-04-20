<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="resources/css/mainForm.css">
</head>
<body>

	<section class="mebForm">
		<h2>會員申請表</h2>
		<form action="MemberFormServlet" method="post">
			<table>
				<tbody>
					<tr>
						<th>Name:</th>
						<td><input type="text" name="name" placeholder="${member.name}"/></td>	
					</tr>
					<tr>
						<th>Sex:</th>
						<td>
							<!-- input 使用 check 避免parameter 出現 null -->
							<c:if test="${member.sex != 77}">
								<input type="radio" name="sex" value="F" checked/>Female<br/>						
								<input type="radio" name="sex" value="M" />Male							
							</c:if>
							<!-- 接收 char 使用ascii 77='M' 70='F'-->	
							<c:if test="${member.sex == 77}">
								<input type="radio" name="sex" value="F" />Female<br/>
								<input type="radio" name="sex" value="M" checked/>Male
							</c:if>	
 						</td>
					</tr>
					<tr>
						<th>Address:</th>
						<td><input type="text" name="address" placeholder="${member.address}"/></td>
					</tr>
					<tr>
						<th>Phone:</th>
						<td><input type="text" name="phone" pattern="\d{4}-?\d{6}" placeholder="${member.phone}"/></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="送出" />
							<input type="reset" value="重新" />
							<input type="submit" formaction="index.html" value="首頁" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</section>
</body>
</html>