package com.controller.login;

import java.io.IOException;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.service.JavaRoleService;

/**
 * Servlet implementation classJavaUserCreateServlet
 */
@WebServlet("/JavaUserCreateServlet")
public class JavaUserCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
	private JavaRoleService service;	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("./WEB-INF/view/javaUserCreate.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// parameter = [username, password, check]
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String check = request.getParameter("check");
		
//		System.out.println(username + ", " + password + ", " + check );
		if(service.inserRole(username, password, check)) {
			//http://localhost:8080/ServletBasic2/formSuccess.jsp
			response.sendRedirect("http://localhost:8080/ServletBasic2/formSuccess.jsp");
		}
		else {
			// http://localhost:8080/ServletBasic2/formFail.jsp
			response.sendRedirect("http://localhost:8080/ServletBasic2/formFail.jsp");
		}
			
	}

}
