<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>core formatting expression</title>
<link type="text/css" rel="stylesheet" href="resource/css/testFormatting.css">
</head>
<body>
	
	<table>
		<tbody>
			<tr>
				<th colspan="2"><h2>fmt:setLocale, fmt:bundle</h2></th>
			</tr>
			<fmt:setLocale value="ja_JP" />
			<fmt:bundle basename="com.locale.JapanMessage" prefix="count.">
				<tr>
					<td>fmt: message key="one"</td>
					<td><fmt:message key="one"></fmt:message></td>
				</tr>
				<tr>
					<td>fmt: message key="two"</td>
					<td><fmt:message key="two"></fmt:message></td>
				</tr>
				<tr>
					<td>fmt: message key="three"</td>
					<td><fmt:message key="three"></fmt:message></td>
				</tr>
				<tr>
					<td>fmt: message key="four"</td>
					<td><fmt:message key="four"></fmt:message></td>
				</tr>
				<tr>
					<td>fmt: message key="five"</td>
					<td><fmt:message key="five"></fmt:message></td>
				</tr>
			</fmt:bundle>
			<fmt:setLocale value="zh_TW"/>
			<fmt:setBundle basename="com.locale.TaiwanMessage" var="tBundle"/>
			<tr>
				<td>\${tBundle}</td>
				<td>${tBundle}</td>
			</tr>
			<tr>
				<td>fmt:message key="one" bundle="\${tBundle}"</td>
				<td><fmt:message key="one" bundle="${tBundle}"></fmt:message></td>
			</tr>
			<tr>
				<td>fmt:message key="two" bundle="\${tBundle}"</td>
				<td><fmt:message key="two" bundle="${tBundle}"></fmt:message></td>
			</tr>
			<tr>
				<td>fmt:message key="three" bundle="\${tBundle}"</td>
				<td><fmt:message key="three" bundle="${tBundle}"></fmt:message></td>
			</tr>
			<tr>
				<th colspan="2"><h2>fmt:parseDate</h2></th>
			</tr>
			<c:set var="time" value="02-19-2025 12:15"></c:set>
			<fmt:parseDate value="${time}" var="paredDate" pattern="MM-dd-yyyy HH:mm"></fmt:parseDate>
			<tr>
				<td>\${paredDate}</td>
				<td>${paredDate}</td>
			</tr>
			<tr>
				<th colspan="2"><h2>fmt:parseNumber</h2></th>
			</tr>
			<c:set value="15513.12" var="balance"></c:set>
			<fmt:parseNumber type="number" var="i1" value="${balance}"></fmt:parseNumber>
			<tr>
				<td>parsed Number \${i1}</td>
				<td>${i1}</td>
			</tr>
			<fmt:parseNumber type="number" var="i2" value="${balance}" integerOnly="true"></fmt:parseNumber>
			<tr>
				<td>parsed Number \${i2}</td>
				<td>${i2}</td>
			</tr>
			<tr>
				<td>parsed Number value="12%"</td>
				<td><fmt:parseNumber value="12%"></fmt:parseNumber></td>
			</tr>
			<tr>
				<th colspan="2"><h2>fmt:formatDate</h2></th>
			</tr>
			<c:set value="<%=new java.util.Date() %>" var="now"/>
			<tr>
				<td>fmt:formatDate type="time"</td>
				<td><fmt:formatDate type="time" value="${now}"/></td>
			</tr>
			<tr>
				<td>fmt:formatDate type="date"</td>
				<td><fmt:formatDate type="date" value="${now}"/></td>
			</tr>
			<tr>
				<td>fmt:formatDate type="both"</td>
				<td><fmt:formatDate type="both" value="${now}"/></td>
			</tr>
			<tr>
				<td>For:formatDate (1)</td>
				<td><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${now}"/></td>
			</tr>
			<tr>
				<td>For:formatDate (2)</td>
				<td><fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${now}"/></td>
			</tr>
			<tr>
				<td>For:formatDate (3)</td>
				<td><fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${now}"/></td>
			</tr>
			<tr>
				<td>For:formatDate (4)</td>
				<td><fmt:formatDate type="both" dateStyle="full" timeStyle="full" value="${now}"/></td>
			</tr>
			<tr>
				<td>For:formatDate (5)</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${now}"/></td>
			</tr>
			<tr>
				<th colspan="2"><h2>fmt:formatNumber</h2></th>
			</tr>
			<c:set var="balance" value="153157.15212"></c:set>
			<tr>
				<td>fmt:formatNumber type="currency"</td>
				<td><fmt:formatNumber type="currency" value="${balance}"/></td>
			</tr>
			<tr>
				<td>fmt:formatNumber type="number" (1)</td>
				<td><fmt:formatNumber type="number" maxIntegerDigits="5">${balance}</fmt:formatNumber></td>
			</tr>
			<tr>
				<td>fmt:formatNumber type="number" (2)</td>
				<td><fmt:formatNumber type="number" maxFractionDigits="5">${balance}</fmt:formatNumber></td>
			</tr>
			<tr>
				<td>fmt:formatNumber groupingUsed="false"</td>
				<td><fmt:formatNumber groupingUsed="false" type="number" value="${balance}"></fmt:formatNumber></td>
			</tr>
			<tr>
				<td>fmt:formatNumber groupingUsed="true"</td>
				<td><fmt:formatNumber groupingUsed="true" type="number" value="${balance}"></fmt:formatNumber></td>
			</tr>
			<tr>
				<td>fmt:formatNumber type="percent" (1)</td>
				<td><fmt:formatNumber type="percent" maxIntegerDigits="6">${balance}</fmt:formatNumber></td>
			</tr>
			<tr>
				<td>fmt:formatNumber type="percent" (2)</td>
				<td><fmt:formatNumber type="percent" minFractionDigits="7">${balance}</fmt:formatNumber></td>
			</tr>
			<tr>
				<td>fmt:formatNumber type="percent" (3)</td>
				<td><fmt:formatNumber type="percent" minIntegerDigits="5">${balance}</fmt:formatNumber></td>
			</tr>
			<tr>
				<td>fmt:formatNumber type="percent" (4)</td>
				<td><fmt:formatNumber type="percent" pattern="##.##E00">${balance}</fmt:formatNumber></td>
			</tr>
			<!--  相對應代碼可參考 locale country list -->
			<tr>
				<td>fmt:formatNumber type="currency"</td>
				<fmt:setLocale value="zh-hk"/>
				<td><fmt:formatNumber type="currency" value="${balance}"></fmt:formatNumber></td>
			</tr>
			<tr>
				<td>fmt:formatNumber type="currency"</td>
				<fmt:setLocale value="ja_JP"/>
				<td><fmt:formatNumber type="currency" value="${balance}"></fmt:formatNumber></td>
			</tr>
			<tr>
				<td>fmt:formatNumber type="currency"</td>
				<fmt:setLocale value="ko_KR"/>
				<td><fmt:formatNumber type="currency" value="${balance}"></fmt:formatNumber></td>
			</tr>
		</tbody>
	</table>
	<button onclick="window.location.href='index.html'">首頁</button>
</body>
</html>