package com.controller.student;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.service.ejb.StudentJpaServiceStateless;

/**
 * Servlet implementation class StudentJpaUpdateServlet
 */
@WebServlet("/StudentJpaUpdateServlet")
public class StudentJpaUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 測試 所以將業務邏輯寫入dao
    @EJB
	private StudentJpaServiceStateless service;
    private String update = null;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get Parameter
		update = request.getParameter("update");
		
		// set Attribute
		if(update != null)
			request.setAttribute("student", service.findStudent(update));
		else
			response.sendRedirect("http://localhost:8080/ServletBasic/StudentPersistenceServlet"); //防止無id 更新
			
		// output
		request.getRequestDispatcher("./view/studentJpaUpdate.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// getParameter
		String studentId = request.getParameter("studentId");
		String name = request.getParameter("name");
		String group = request.getParameter("group");
		String score = request.getParameter("score");
		String club = request.getParameter("club");
		
		// service method
		String id = update;
		service.updateStudent(studentId, name, group, score, club, id);
		
		// Redirect
		response.sendRedirect("http://localhost:8080/ServletBasic/StudentPersistenceServlet");
	}

}
