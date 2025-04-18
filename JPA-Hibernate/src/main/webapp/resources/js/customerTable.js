
var table = document.getElementById("customerList");

// customer = [];產生 陣列型態 的 物件
const customer = JSON.parse(customers); 

var describe =  "";

for(var i = 0; i < customer.length ; i++) {
	
	describe += `
		<tr>
			<td>${customer[i].id}</td>
			<td>${customer[i].country}</td>
			<td>${customer[i].firstName}</td>
			<td>${customer[i].lastName}</td>
		</tr>
	`
}

table.innerHTML = describe;