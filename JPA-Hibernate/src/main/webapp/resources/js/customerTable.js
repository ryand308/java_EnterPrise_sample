
let table = document.getElementById("customerList");

// customer = [];產生 陣列型態 的 物件

let describe =  "";

for(var i = 0; i < customer.length ; i++) {
	
	describe += `
		<tr>
			<td>${customer[i].id}</td>
			<td>${customer[i].country}</td>
			<td>${customer[i].firstName}</td>
			<td>${customer[i].lastName}</td>
			<td>
				<form action="CustomerListServlet" method="POST">			
					<input type="hidden" value="${customer[i].id}" name="delete" />
					<input type="submit" value="刪除"/>
				</form>
			</td>
			<td>
				<form action="CustomerFormServlet" method="GET">			
					<input type="hidden" value="${customer[i].id}" name="update" />
					<input type="submit" value="更新"/>
				</form>
			</td>
		</tr>
	`
}

table.innerHTML = describe;