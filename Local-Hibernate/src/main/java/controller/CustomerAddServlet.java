package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CustomerService;

/**
 * Servlet implementation class CustomerAddServlet
 */
@WebServlet("/CustomerAddServlet")
public class CustomerAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerService service = new CustomerService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get parameter
		String lastName = "Apink";
		String firstName = "Rose";
		String country = "Korea";

		// get method from service
		service.addCustomer(lastName, firstName, country);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
