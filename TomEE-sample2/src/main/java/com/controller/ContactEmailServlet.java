package com.controller;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mail.MailService;

import java.io.IOException;
import java.util.Arrays;

/**
 * Servlet implementation class EmailServlet
 */
@WebServlet("/ContactEmailServlet")
public class ContactEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
	private MailService mailService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		request.getRequestDispatcher("./WEB-INF/view/contactEmail.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get parameter
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String body = request.getParameter("body");
		
		// send Email from service
		mailService.contactEmail(name, subject, body);
		// redirect
		response.sendRedirect("http://localhost:8080" + request.getContextPath() + request.getServletPath());
	}

}
