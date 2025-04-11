package com.controller;

import java.io.IOException;

import jakarta.jws.soap.InitParam;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieElWebServlet
 */
@WebServlet("/CookieElServlet")
public class CookieElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = {
				new Cookie("User.cookie", "Tomcat_User"),
				new Cookie("nightMarket", "chill_Guy"),
				new Cookie("information", "funny_programming")
		};
		
		for(Cookie cookie: cookies)
			response.addCookie(cookie);
		
		getServletContext().getRequestDispatcher("/view/cookieEl.jsp").forward(request, response);
	}	

}
