package com.controller.employee;

import java.io.IOException;

import javax.sql.DataSource;

import com.listener.DataBaseResource;
import com.service.ejb.EmployeeServiceStateless;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeLuv2FormServlet
*/
@WebServlet("/EmployeeLuv2FormServlet")
public class EmployeeLuv2FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	private EmployeeServiceStateless eService;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		if(request.getUserPrincipal() == null)
			response.sendRedirect("http://localhost:8080/ServletBasic2/NoActiveServlet");
		
		// output
		request.getRequestDispatcher("./WEB-INF/view/employeeForm.jsp").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// DataBase connection to Service from listener of ServletContext.
		if(DataBaseResource.DB != null) {
			DataSource ds = (DataSource)request.getServletContext().getAttribute(DataBaseResource.DB);			 
			eService.setDs(ds);		
		}
		
		// get parameter
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String department = request.getParameter("department");
		String salary = request.getParameter("salary");		
		
		String path = "http://localhost:8080" + request.getContextPath() + request.getServletPath();
		Cookie cookie = new Cookie("back", path);
		response.addCookie(cookie);
		//set method	
		if(eService.addEmployee(lastName, firstName, email, department, salary))
			response.sendRedirect("./formSuccess.jsp");		
		else		
			response.sendRedirect("./formFail.jsp");
		
			
//		doGet(request, response);
	}

}
