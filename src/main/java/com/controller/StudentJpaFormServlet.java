package com.controller;

import java.io.IOException;

import com.dao.impl.StudentJpaDaoStateless;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentJpaFormServlet")
public class StudentJpaFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 測試 所以將業務邏輯寫入dao
    @EJB
	private StudentJpaDaoStateless daoService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// output
		request.getRequestDispatcher("./studentJpaForm.jsp").include(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get Parameter
		String studentId = request.getParameter("studentId");
		String name = request.getParameter("name");
		String group = request.getParameter("group");
		String score = request.getParameter("score");
		String club = request.getParameter("club");
		
		String path = "http://localhost:8080"+ request.getContextPath()+request.getServletPath();		
		Cookie cookie = new Cookie("back", path);
		response.addCookie(cookie);
		// service method & Redirect
		if(daoService.addStudent(studentId, name, group, score, club))
			response.sendRedirect("./view/formSuccess.jsp");
		else
			response.sendRedirect("./view/formFail.jsp");
	}

}
