<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl xml tag test</title>
<link type="text/css" rel="stylesheet" href="resource/css/testXml.css">
</head>
<body>
	<c:import url="/WEB-INF/xmlSample.xml" var="bookInfo" charEncoding="utf-8"></c:import>
	<x:parse xml="${bookInfo}" var="output"></x:parse>
	<table>
		<tbody>
			<tr>
				<th colspan="2"><h2>x:out</h2></th>
			</tr>
			<x:forEach select="$output/books/book" var="items" varStatus="status">
				<tr>
					<td>title of (${status.count})</td>
					<td><x:out select="$items/name"/></td>
				</tr>
				<tr>
					<td>author of (${status.count})</td>
					<td><x:out select="$items/author"/></td>
				</tr>
				<tr>
					<td> price of (${status.count})</td>
					<td><x:out select="$items/price" /></td>
				</tr>
			</x:forEach>
			
		</tbody>
	</table>
</body>
</html>