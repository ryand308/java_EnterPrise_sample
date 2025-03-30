<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message Box</title>
<link rel="stylesheet" href="../resource/css/cookeInfo.css">
<link rel="stylesheet" type="text/css" href="../resource/css/cookieForm.css">
</head>
<body>
	<%-- include 產生的網頁是在編譯(compilor time)時期。也就是並未透過伺服器接收傳至 .jsp；
	在編碼上無論是加上request.setCharacterEncoding("utf-8"),setContentType("utf-8") 都沒用，只能直接加在.html 上 --%>	
	<%@include file="../CookieForm.html" %>
	<div class="log">
		
		<p>${cookie.msg.value}</p>		
		<p class="name">${cookie.lname.value} - ${cookie.fname.value}</p>
	</div>
	
	
</body>
</html>