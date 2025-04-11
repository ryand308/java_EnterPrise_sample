<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language page</title>
<link rel="stylesheet" type="text/css" href="resource/css/main.css">
</head>
<body>
<!-- header -->
	<!-- header 依賴內部css -->
	<div class="header">
		<jsp:include page="component/header.html"></jsp:include>
	</div>
<!-- hero -->
	<div class="hero">
		<form action="view/elParamResult.jsp" >
			<jsp:include page="component/elParamForm.html"></jsp:include>
		</form>
	</div>
<!-- footer -->
	<div class="footer">
		<jsp:include page="component/footer.html"></jsp:include>
	</div>
	
</body>
</html>