package com.controller;

import java.io.IOException;

import com.service.StudentServiceStatefulJpa;
import com.service.StudentServiceStatelessJpa;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/StudentPersistenceServlet")
public class StudentPersistenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private StudentServiceStatefulJpa sService;
	@EJB
	private StudentServiceStatelessJpa sService2;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//test transaction
		sService.testBMT();
		
		// call list
		var results = sService.allStudent();
		request.setAttribute("stu1", results);
		
		//output
		request.getRequestDispatcher("./view/studentSqlPersistence.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get Parameter
		String delete = request.getParameter("delete");
		
		// call service method
		sService2.deleteStudent(delete);
		
		response.sendRedirect("http://localhost:8080"+ request.getContextPath() +request.getServletPath());
	}

}
