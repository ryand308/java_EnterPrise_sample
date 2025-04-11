<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="justify-items: center;">
<style>
:root {
	--header-background: #70CAD1;
	--hero-background: #CAEDFF;
	--footer-background: #3E517A;
}
div {
	width: 750px;	
}
h2 {
	width: 750px;
	background-color: var(--header-background);
	text-align: center;
	color: white;
}
div p:nth-of-type(odd) {
	background-color: #eee;	
}
</style>
	<%
		// pageContext 只能作用在jsp；implicit object(隱藏物件之一)
		pageContext.setAttribute("names", "一般字串");// default is PAGE_SCOPE
		pageContext.setAttribute("mark", "hi ApplicationSope", PageContext.APPLICATION_SCOPE);
	%>
	<h2>pageContext:</h2>
	<div>
		<p>1.\${pageContext.request.method}&nbsp;=>&nbsp;&nbsp;${pageContext.request.method}</p>
		<p>2.\${pageContext.request.contextPath}&nbsp;=>&nbsp;&nbsp;${pageContext.request.contextPath}</p>
		<p>3.\${pageContext.out.bufferSize}&nbsp;=>&nbsp;&nbsp;${pageContext.out.bufferSize}</p>
	</div>
	<h2>pageScope:</h2>
	<div>
		<p>1.\${pageScope.names}&nbsp;=>&nbsp;&nbsp;${pageScope.names}</p>
		<p>2.\${names}&nbsp;=>&nbsp;&nbsp;${names}</p>
	</div>
	<h2>requestScope:</h2>
	<div>
		<p>1.\${requestScope.e1}&nbsp;=>&nbsp;&nbsp;${requestScope.e1}</p>
		<p>2.\${requestScope.e1.address.location}&nbsp;=>&nbsp;&nbsp;${requestScope.e1.address.location}
		<p>3.\${requestScope.names[0]}&nbsp;=>&nbsp;&nbsp;${requestScope.names[0]}</p>
		<p>4.\${requestScope.names}&nbsp;=>&nbsp;&nbsp;${requestScope.names}</p>
		<p>5.\${names[1]}&nbsp;=>&nbsp;&nbsp;PropertyNotFoundException;  names is exist, but not Arrays, List...etc Type.</p>
		<p>6.\${names}&nbsp;=>&nbsp;&nbsp;${names}；page優先於request</p>
		<p>7.\${requestScope.mark}&nbsp;=>&nbsp;&nbsp;${requestScope.mark}</p>
	</div>
	<h2>sessionScope:</h2>
	<div>
		<p>1.\${sessionScope.e2}&nbsp;=>&nbsp;&nbsp;${sessionScope.e2}</p>
		<p>2.\${sessionScope.e2.name}&nbsp;=>&nbsp;&nbsp;${sessionScope.e2.name}</p>
		<p>3.\${e2}&nbsp;=>&nbsp;&nbsp;${e2}</p>
		<p>4.\${e2.address.location}&nbsp;=>&nbsp;&nbsp;${e2.address.location}</p>
	</div>
	<h2>applicationScope:</h2>
	<div>
		<p>1.\${applicationScope.mark}&nbsp;=>&nbsp;&nbsp;${applicationScope.mark}</p>
		<p>2.\${mark}&nbsp;=>&nbsp;&nbsp;${mark}</p>	
	</div>
	<div>
		<a href="index.html">首頁</a>		
	</div>
	
</body>
</html>