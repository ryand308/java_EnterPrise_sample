let form = document.getElementById("customerForm");
let describe = ""

// customer 宣告  from servlet in String of java

if( customer != null) {
	
	describe =`
			<tbody>
					<tr>
						<th>First_Name:</th>
						<td><input type="text" name="firstName" placeholder="${customer.firstName}"/></td>						
					</tr>
					<tr>
						<th>Last_Name:</th>
						<td><input type="text" name="lastName" placeholder="${customer.lastName}" /></td>
					</tr>
					<tr>
						<th>Country:</th>
						<td><input type="text" name="country" placeholder="${customer.country}" /></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="送出"/>
							<input type="reset" value="重置"/>
							<input type="submit" formaction="index.html" value="首頁" />
						</td>
					</tr>
			</tbody>
	`;
}
else {
	describe =`
				<tbody>
						<tr>
							<th>First_Name:</th>
							<td><input type="text" name="firstName"/></td>						
						</tr>
						<tr>
							<th>Last_Name:</th>
							<td><input type="text" name="lastName" /></td>
						</tr>
						<tr>
							<th>Country:</th>
							<td><input type="text" name="country" /></td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="送出"/>
								<input type="reset" value="重置"/>
								<input type="submit" formaction="index.html" value="首頁" />
							</td>
						</tr>
				</tbody>
				`
}

form.innerHTML = describe

