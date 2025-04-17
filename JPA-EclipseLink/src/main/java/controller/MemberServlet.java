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
	private MemberService service;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//encoding for filter
		
		// service methods；business Logic
		request.setAttribute("members", service.showMember());		
		
		// request forward		
		request.getRequestDispatcher("./WEB-INF/view/MemberList.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String delete = req.getParameter("delete");
		service.deleteMember(delete);
		
		resp.sendRedirect("http://localhost:8080"+ req.getContextPath() +req.getServletPath());
	}

	
}
