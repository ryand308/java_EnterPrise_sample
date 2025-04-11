package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CustomerService;

/**
 * Servlet implementation class CustomerFindServlet
 */
@WebServlet("/CustomerFindServlet")
public class CustomerFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	private CustomerService service = new CustomerService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get method of service
		service.findAllCustomer();		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

}
