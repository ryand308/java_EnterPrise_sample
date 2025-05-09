<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show cookies and xml parameter</title>
<!-- 作用在servlet tier -->
<link type="text/css" rel="stylesheet" href="resource/css/cookieEl.css" />
</head>
<body>
	<div>
		<table>
			<tbody>
				<tr>
					<th colspan="2" style="width: 450px;">Cookie</th><th>EL</th>
				</tr>			
				<c:forEach items="${cookie}" var="cake" varStatus="status">
					<tr>
						<c:if test="${cake.value.name !='JSESSIONID'}">
							<td>${status.count}.\${cookie[${cake.value.name}].value}</td><td>${cake.value.value}</td>
						</c:if>
						
						
						<c:if test="${cake.value.name == 'User.cookie'}">
							<td>${cookie["User.cookie"].value}</td>		
						</c:if>
						<c:if test="${cake.value.name == 'information'}">
							<td>${cookie["information"].value}</td>
						</c:if>	
						<c:if test="${cake.value.name == 'nightMarket'}">
							<td>${cookie["nightMarket"].value}</td>
						</c:if>
					</tr>
				</c:forEach>			
			</tbody>
		</table>
		<table style="margin-top: 50px;">
			<tbody>
				<tr>
					<th>EL</th><th>值</th>
				</tr>
				<tr>
					<td>\${initParam}</td> <td>${initParam}</td>
				</tr>
				<tr>
					<td>\${initParam.cookieEl1}</td> <td>${initParam.cookieEl1}</td>
				</tr>
				<tr>
					<td>\${initParam.cookieEl2}</td> <td>${initParam.cookieEl2}</td>
				</tr>
				<tr>
					<td>application.getInitParameter("cookieEl1")</td> <td><%=application.getInitParameter("cookieEl1") %></td>
				</tr>
				<tr>
					<td>application.getInitParameter("cookieEl2")</td> <td><%=application.getInitParameter("cookieEl2") %></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>