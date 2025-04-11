 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language practice</title>
<link rel="stylesheet" type="text/css" href="resource/css/elAccess.css">
</head>
<body>

	<table border="1">
		<tr>
			<th colspan="2">Test Attribute</th>
		</tr>
		<tr>
			<th>variable</th> <th>value</th>
		</tr>		
		
		<tr>
			<td>\${myNum}</td> <td>${myNum}</td>			
		</tr>
		<tr>
			<td>\${myStr}</td> <td>${myStr}</td>
		</tr>
		<%-- ------------------------------------------------------ --%>
		<tr>
			<th colspan="2">Test Map</th>
		</tr>
		<tr>
			<td>\${map}</td> <td>${map}</td>
		</tr>
		<tr>
			<td>\${map["e1"].name}</td> <td>${map["e1"].name}</td>
		</tr>
		<tr>
			<td>\${map.e1.address}</td> <td>${map.e1.address}</td>
		</tr>
		<tr>
			<td>\${map[myStr].name}</td> <td>${map[myStr].name}</td>
		</tr>
		<%-- ------------------------------------------------------ --%>
		<tr>
			<th colspan="2">Test List</th>
		</tr>
		<tr>
			<td>\${list}</td> <td>${list}</td>			
		</tr>
		<tr>
			<td>\${list["0"].name}</td> <td>${list["0"].name}</td>
		</tr>
		<tr>
			<td>\${list[1].name}</td> <td>${list[1].name}</td>
		</tr>
		<tr>
			<td>\${list[myNum].address.location}</td> <td>${list[myNum].address.location}</td>
		</tr>
		<%-- ------------------------------------------------------ --%>
		<tr>
			<th colspan="2">Test Array</th>
		</tr>
		<tr>
			<td>\${array}</td> <td>${array}</td>
		</tr>
		<tr>
			<td>\${array["0"].address}</td> <td>${array["0"].address}</td>
		</tr>
		<tr>
			<td>\${array[1].name}</td> <td>${array[1].name}</td>
		</tr>
		<tr>
			<td>\${array[myNum].address.location}</td> <td>${array[myNum].address.location}</td>
		</tr>
		<%-- ------------------------------------------------------ --%>
		<tr>
			<th colspan="2">Test NotFound</th>			
		</tr>
		<tr>
			<td>\${myList} =</td> <td>${myList}</td>
		</tr>
		<tr>
			<td>\${list[5].name}</td> <td>${list[5].name}</td>
		</tr>
		<tr>
			<td>\${myList["0"].nameX}</td> <td>${myList["0"].nameX}ProperyNotFoundException</td>
		</tr>
		<tr>
			<td>\${map.eX.name}</td> <td>${map.eX.name}</td>
		</tr>
		<tr>
			<td>\${array[X].name}</td> <td>${array[X].name}NumberFomatException</td>
		</tr>
	</table>
	
	
	
</body>
</html>