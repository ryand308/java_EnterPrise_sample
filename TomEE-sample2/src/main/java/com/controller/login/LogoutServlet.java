package com.controller.login;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// HttpSession 
		System.out.println( request.getUserPrincipal() );
		// invaliate()斬session 有點危險；除非是 自建的 session login，建議可使用removeAttribute()，principal 使用 logout();
//		HttpSession session = request.getSession();
//		session.invalidate();
		request.getRequestDispatcher("./WEB-INF/view/logout.jsp").include(request, response);
		
		request.logout();		
		
	}

}
