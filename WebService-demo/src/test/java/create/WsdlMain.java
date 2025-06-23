package create;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.wsdl.xml.WSDLWriter;

public class WsdlMain {

	public static void main(String[] args) {
		
		try {
			WSDLFactory factory = WSDLFactory.newInstance();
			WSDLReader reader = factory.newWSDLReader();  
			reader.setFeature("javax.wsdl.verbose",true);  
			reader.setFeature("javax.wsdl.importDocuments",true);  
			Definition def=reader.readWSDL("http://localhost:8080/DemoWebService/CalculatorService?wsdl");  
			WSDLWriter writer=factory.newWSDLWriter();  
			
			writer.writeWSDL(def, System.out); 
			
		} catch (WSDLException e) {
			e.printStackTrace();
		}
		
	}
}
