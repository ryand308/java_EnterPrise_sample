package controller;

import java.io.IOException;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CustomerService;

/**
 * Servlet implementation class CustomerFormServlet
 */
@WebServlet("/CustomerFormServlet")
public class CustomerFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
	private CustomerService service;
	private String id = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		id = request.getParameter("update");
		// control page; debug error of javaScript
		if(id == null)
			response.getWriter().append(service.idNullDeclare());
		else
			response.getWriter().append(service.findCustomerJson(id));
		// include html
		request.getRequestDispatcher("./WEB-INF/view/customerForm.html").include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get parameter
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String country = request.getParameter("country");
		
		// test value
		System.out.printf("first_name:%-10s, last_name:%-10s, country:%-10s%n", firstName, lastName, country);
		
		// save data
		if( id != null) {
			service.updateCustomer(id, country, firstName, lastName);
			response.sendRedirect("http://localhost:8080/testHibernate/CustomerListServlet");
		}
		else if(service.addCustomer(country, firstName, lastName))
			response.sendRedirect("http://localhost:8080/testHibernate/formSuccess.html");
		else
			response.sendRedirect("http://localhost:8080/testHibernate/formFailure.html");
		
	}

}
