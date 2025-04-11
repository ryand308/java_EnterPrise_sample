package controller;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CustomerService;

import java.io.IOException;

/**
 * Servlet implementation class CustomerAddServlet
 */
@WebServlet("/CustomerAddServlet")
public class CustomerAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
	CustomerService service;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get parameter
		String firstName = "bruno";
		String lastName = "mars";
		String country = "UK";
		
		// methods from service
		service.AddCustomer(lastName, firstName, country);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
}
