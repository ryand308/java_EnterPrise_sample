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
 * Servlet implementation class CustomerListServlet
 */
@WebServlet("/CustomerListServlet")
public class CustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
	private CustomerService service;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		// method from service; String to Json		 		
		response.getWriter().append(service.findAllCustomerJson());
		
		// request dispatcher include 
		request.getRequestDispatcher("./WEB-INF/view/customerTable.html").include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// getParameter
		String delete = request.getParameter("delete");				
		
		System.out.println(delete);
		// delete method from service	
		service.deleteCustomer(delete);
		
		response.sendRedirect("http://localhost:8080" + request.getContextPath() + request.getServletPath());
	}

}
