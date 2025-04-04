package com.controller;

import java.io.IOException;

import com.dao.impl.StudentJpaDaoStateful;
import com.dao.impl.StudentJpaDaoStateless;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/StudentPersistenceServlet")
public class StudentPersistenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 測試 所以將業務邏輯寫入dao
	@EJB
	private StudentJpaDaoStateful daoService;
	@EJB
	private StudentJpaDaoStateless daoService2;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//test transaction
		daoService.testBMT();
		
		// call list
		var results = daoService.allStudent();
		request.setAttribute("stu1", results);
		
		//output
		request.getRequestDispatcher("./view/studentSqlPersistence.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get Parameter
		String delete = request.getParameter("delete");
		
		// call service method
		daoService2.deleteStudent(delete);
		
		response.sendRedirect("http://localhost:8080"+ request.getContextPath() +request.getServletPath());
	}

}
