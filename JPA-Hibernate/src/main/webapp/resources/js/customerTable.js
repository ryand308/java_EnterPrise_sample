
let table = document.getElementById("customerList");

// customer = [];產生 陣列型態 的 物件

let describe =  "";

for(var i = 0; i < customer.length ; i++) {
	/* 使用關聯實體，物件就變為陣列？ */
	describe += `
		<tr>
			<td>${customer[i][0]}</td>
			<td>${customer[i][1]}</td>
			<td>${customer[i][2]}</td>
			<td>${customer[i][3]}</td>
			<td>
				<form action="CustomerListServlet" method="POST">			
					<input type="hidden" value="${customer[i][0]}" name="delete" />
					<input type="submit" value="刪除"/>
				</form>
			</td>
			<td>
				<form action="CustomerFormServlet" method="GET">			
					<input type="hidden" value="${customer[i][0]}" name="update" />
					<input type="submit" value="更新"/>
				</form>
			</td>
		</tr>
	`
}

table.innerHTML = describe;