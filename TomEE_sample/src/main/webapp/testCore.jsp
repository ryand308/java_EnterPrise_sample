<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test Core express</title>
<link type="text/css" rel="stylesheet" href="resource/css/testCore.css">
</head>
<body>
<%@ include file="resource/javascripting/TestCore.java"%>

<table>
	<tbody>
		<tr>
			<th colspan="2"><h2>1. c:out</h2></th>
		</tr>
		<tr>
			<td>\${sessionScope.jim1}</td>
			<td>${sessionScope.jim1}</td>
		</tr>
		<tr>
			<td>escapeXml(false)</td>
			<td><c:out value="${sessionScope.jim1}" escapeXml="false" /></td>
		</tr>
		<tr>
			<td>escapeXml(true)</td>
			<td><c:out value="${sessionScope.jim1}" escapeXml="true" /></td>
		</tr>
		<tr>
			<td>\${jim0}</td>
			<td><c:out value="${jim0}" default="no scripting"></c:out></td>
		</tr>
		<tr>
			<th colspan="2"><h2>2. c:remove</h2></th>
		</tr>
		<tr>
			<td>before - \${sessionScope.jim1}</td>
			<td>${sessionScope.jim1}</td>
		</tr>
		<c:remove var="jim1" scope="session" />
		<tr>
			<td>after - \${sessionScope.jim1}</td>
			<td>${sessionScope.jim1}</td>
		</tr>
		<tr>
			<th colspan="2"><h2>3. c:catch</h2></th>
		</tr>
		<tr>
			<td>\${z = 10/0}</td>
			<td>${z = 10/0}</td>
		</tr>
		<tr>
			<td>&lt; %=10/0 &gt;</td>
			<c:catch var="zeroException">
				<td><%=10/0 %></td>				
			</c:catch>
		</tr>
		<tr>
			<td>c:out value="\${zeroException}"</td>
			<td><c:out value="${zeroException}"/></td>
		</tr>
		<tr>
			<td>\${zeroException}</td>
			<td>${zeroException}</td>
		</tr>
		<tr>
			<td>\${zeroException.message}</td>
			<td>${zeroException.message}</td>
		</tr>
		<tr>
			<th colspan="2"><h2>5. c:if</h2></th>
		</tr>
		<tr>
			<td>c:if test="\${not empty array}"</td>
			<c:if test="${not empty array}" var="visits">
				<td>${visits}</td>
			</c:if>			
		</tr>
		<tr>
			<td>\${array}</td>
			<td>${array}</td>
		</tr>
		<c:forEach items="${array}" var="ary" varStatus="status">
			<tr>
				<td>\${array[${status.count}]}</td>
				<td>${ary}</td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="2"><h2>6. c:choose, when, otherwirse</h2></th>
		</tr>
		<tr>
			<c:choose>
				<c:when test="${x == 11}"><td>\${x == 11}</td></c:when>
				<c:when test="${x == 12}"><td>\${x == 12}</td></c:when>
				<c:when test="${x == 13}"><td>\${x == 13}</td></c:when>
				<c:otherwise><td>x 不屬其中的數</td></c:otherwise>
			</c:choose>
			<td>true</td>
		</tr>
		<tr>
			<th colspan="2"><h2>7. forTokens</h2></th>
		</tr>
		<c:forTokens items="${lang}" delims="," var="program" varStatus="forStatus">
			<tr>
					<td>\${lang[${forStatus.index}]}</td>
					<td>${program}</td>
			</tr>
		</c:forTokens>
		<tr>
			<th colspan="2"><h2>8. c:import</h2></th>			
		</tr>
		<tr>
			<td>LifecycleServlet</td>
			<td><c:import url="http://localhost:8080/ServletBasic/LifecycleServlet"></c:import></td>
		</tr>
		<tr>
			<th colspan="2"><h2>9. c:url</h2></th>
		</tr>
		<tr>
			<c:url value="index.html" var="home"></c:url>
			<td>\${home}</td>
			<td><a href="${home}">home</td>			
		</tr>
	</tbody>	
</table>
	<%--
		<c:redirect url="https://www.google.com"></c:redirect>
	 --%>
</body>
</html>