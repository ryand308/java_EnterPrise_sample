package controller;

import java.io.IOException;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

/**
 * Servlet implementation class MemberFindServlet
 */
@WebServlet("/MemberFindServlet")
public class MemberFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	MemberService service;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get methods from service
		service.findMember();

		//output
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}



}
