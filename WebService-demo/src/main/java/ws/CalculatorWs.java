package ws;

import jakarta.jws.WebService;

@WebService(targetNamespace = "http://superbiz.org/wsdl")
public interface CalculatorWs {

	public int sum(int add1, int add2);

    public int multiply(int mul1, int mul2);
}
