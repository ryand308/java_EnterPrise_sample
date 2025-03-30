<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>輸出表達式</title>
<link rel="stylesheet" type="text/css" href="../resource/css/elParamResult.css">
</head>
<body>
<style>
	
</style>
	<table class="first">
		<tbody>
			<tr>
				<th style="min-width: 150px;">大概意思：</th><th style="min-width:250px;">EL:</th><th>header:</th>
			</tr>
			<tr>
				<!-- header 是取 單一值；也就是 物件；以下headerValue 取的是 多值 -->
				<td>餅乾屑</td><td>\${header["cookie"]}</td> <td>${header["cookie"]}</td>
			</tr>
			<tr>
				<td>使用者的瀏覽器</td><td>\${header["User-Agent"]}</td> <td>${header["User-Agent"]}</td>
			</tr>
			<tr>
				<td>客戶端接受的內容</td><td>\${header["Accept"]}</td> <td>${header["Accept"]}</td>				
			</tr>
			<tr>
				<td>內容型態</td><td>\${header["Content-Type"]}</td> <td>${header["Content-Type"]}</td>
			</tr>
			<tr>
				<td>發起請求</td><td>\${header["Referer"]}</td> <td>${header["Referer"]}</td>
			</tr>
			<tr>
				<td>主機資訊</td><td>\${header["Host"]}</td> <td>${header["Host"]}</td>
			</tr>
		</tbody>
	</table>
	
	<table class="first">
		<tbody>
			<tr>
				<th style="min-width: 150px;">大概意思：</th><th style="min-width:250px;">EL:</th><th>headerValues:</th>
			</tr>
			<tr>
				<td>餅乾屑</td> <td>\${headerValues["cookie"]}</td> <td>${headerValues["cookie"]}</td>
			</tr>
			<tr>
				<td>餅乾屑[0]</td> <td>\${headerValues["cookie"][0]}</td> <td>${headerValues["cookie"]["0"]}</td>
			</tr>
			<tr>
				<td>餅乾屑[1]</td> <td>\${headerValues["cookie"][1]}</td> <td>${headerValues["cookie"]["1"]}</td>
			</tr>
			<tr>
				<td>接受內容</td> <td>\${headerValues["Accept"]}</td> <td>${headerValues["Accept"]}</td>
			</tr>
			<tr>
				<td>接受內容[0]</td> <td>\${headerValues["Accept"][0]}</td> <td>${headerValues["Accept"][0]}</td>
			</tr>
		</tbody>		
	</table>
	<hr/>
	<div style="display: flex; justify-content: flex-start;">
	<table style="height: calc(40px*5); margin-right: 50px;">
		<tbody>
			<tr>
				<th style="width: 150px;">參數(parameter)</th> <th>內容(content)</th>
			</tr>
			<tr>
				<!-- param 對應單一值 -->
				<td>\${param}</td> <td>${param}</td>				
			</tr>
			<tr>
				<td>\${param.name}</td> <td>${param.name}</td>
			</tr>
			<tr>
				<td>\${param.gender}</td> <td>${param.gender}</td>
			</tr>
			<tr>
				<td>\${param.lang}</td> <td>${param.lang}</td>
			</tr>
			<tr>
				<!-- param面對 多個值並不會以物件的形式表示；而是取內部之一值 -->
				<td>\${param.interest}</td> <td>${param.interest}</td>
			</tr>
		</tbody>
	</table>
	<table style="height: calc(40px*12);">
		<tbody>
			<tr>
				<th style="width: 200px;">參數值(paramValue)</th> <th>內容(content)</th>
			</tr>
			<tr>
				<td>\${paramValues.name}</td> <td>${paramValues.name}</td>
			</tr>
			<tr>
				<td>\${paramValues.name[0]}</td> <td>${paramValues.name[0]}</td>
			</tr>
			<tr>
				<td>\${paramValues.gender}</td> <td>${paramValues.gender}</td>
			</tr>
			<tr>
				<td>\${paramValues.gender[0]}</td> <td>${paramValues.gender[0]}</td>
			</tr>
			<tr>
				<td>\${paramValues.lang}</td> <td>${paramValues.lang}</td>
			</tr>
			<tr>
				<td>\${paramValues.lang[0]}</td> <td>${paramValues.lang[0]}</td>
			</tr>
			<tr>
				<td>\${paramValues.interest}</td> <td>${paramValues.interest}</td>
			</tr>
			<tr>
				<td>\${paramValues.interest[0]}</td> <td>${paramValues.interest[0]}</td>
			</tr>
			<tr>
				<td>\${paramValues.interest[1]}</td> <td>${paramValues.interest[1]}</td>
			</tr>
			<tr>
				<td>\${paramValues.interest[2]}</td> <td>${paramValues.interest[2]}</td>
			</tr>
			<tr>
				<td>\${paramValues.interest[3]}</td> <td>${paramValues.interest[3]}</td>
			</tr>
			<tr>
				<td>\${paramValues.interest[4]}</td> <td>${paramValues.interest[4]}</td>
			</tr>
		</tbody>
	</table>
	</div> 
</body>
</html>