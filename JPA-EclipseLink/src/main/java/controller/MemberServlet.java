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
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	MemberService service;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//encoding for filter
		
		// service methods；business Logic
		request.setAttribute("members", service.showMember());		
		
		// request forward		
		request.getRequestDispatcher("./WEB-INF/view/MemberList.jsp").forward(request, response);
		
		// redirect
//		response.sendRedirect("http://localhost:8080/testEclipseLink");

	}


}
