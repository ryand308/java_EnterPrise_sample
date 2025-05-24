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
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/NoActiveServlet")
public class NoActiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
	private JavaRoleService service;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getUserPrincipal() != null)
			if(!service.findUserActive(request.getUserPrincipal().getName())) // null.getName() => NullpointException
				request.logout();
		
		request.getRequestDispatcher("./WEB-INF/view/loginActivePage.jsp").include(request, response);
		}

}
