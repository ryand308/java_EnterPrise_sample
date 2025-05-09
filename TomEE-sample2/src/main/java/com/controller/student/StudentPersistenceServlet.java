package com.controller.student;

import java.io.IOException;

import com.service.ejb.StudentJpaServiceStateful;
import com.service.ejb.StudentJpaServiceStateless;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/StudentPersistenceServlet")
public class StudentPersistenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 測試 所以將業務邏輯寫入dao
	@Inject
	private StudentJpaServiceStateful service;
	@Inject
	private StudentJpaServiceStateless service2;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//test transaction
		service.testBMT();
		
		// call list
		var results = service.allStudent();
		request.setAttribute("stu1", results);
		
		//output
		request.getRequestDispatcher("./WEB-INF/view/studentSqlPersistence.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get Parameter
		String delete = request.getParameter("delete");
		
		// call service method
		service2.deleteStudent(delete);
		
		response.sendRedirect("http://localhost:8080"+ request.getContextPath() +request.getServletPath());
	}

}
