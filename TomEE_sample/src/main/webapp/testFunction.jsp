<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>function in the jstl</title>
<link type="text/css" rel="stylesheet" href="resource/css/testFunction.css">
</head>
<body>
	<%@include file="resource/javascripting/TestFuntion.java" %>
	
	<table>
		<tbody>
			<tr>
				<th colspan="2"><h3>fn:contains, containsIgnoreCase</h3></th>
			</tr>
			<tr>
				<td>s1</td>
				<td>${s1}</td>
			</tr>
			<c:if test="${fn:contains(s1, 'tags')}">
				<tr>
					<td>\${fn:contains(s1, 'tags')}</td>
					<td>${fn:contains(s1, 'tags')}</td>				
				</tr>
			</c:if>
			<c:if test="${fn:containsIgnoreCase(s1, 'jstl')}">
				<tr>
					<td>\${fn:containsIgnoreCase(s1, 'jstl')}</td>
					<td>${fn:containsIgnoreCase(s1, 'jstl')}</td>
				</tr>		
			</c:if>
			<tr>
				<td>\${fn:startsWith(s1, 'this')}</td>
				<td>${fn:startsWith(s1, 'this')}</td>
			</tr>
			<tr>
				<td>\${fn:startsWith(s1, 'This')}</td>
				<td>${fn:startsWith(s1, 'This')}</td>
			</tr>
			<tr>
				<td>\${fn:endsWith(s1, 'test') }</td>
				<td>${fn:endsWith(s1, 'test')}</td>
			</tr>
			<tr>
				<td>\${fn:length(s2)}</td>
				<td>${fn:length(s2)}</td>
			</tr>
			<c:set value="${fn:trim(s2)}" var="s3"></c:set>
			<tr>
				<td>\${fn:length(s3)}</td>
				<td>${fn:length(s3)}</td>
			</tr>
		</tbody>		
	</table>
</body>
</html>