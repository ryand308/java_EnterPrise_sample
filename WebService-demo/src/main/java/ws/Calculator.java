package ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;


@WebService
public class Calculator {

	@WebMethod
	public int sum(int add1, int add2) {
		// TODO Auto-generated method stub
		return add1 + add2;
	}

	@WebMethod
	public int multiply(int mul1, int mul2) {
		// TODO Auto-generated method stub
		return mul1 * mul2;
	}
	
}
