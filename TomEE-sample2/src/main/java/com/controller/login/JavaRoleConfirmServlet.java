package com.controller.login;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.repository.JavaRoleRepository;
import login.service.JavaRoleService;

import java.io.IOException;

/**
 * Servlet implementation class JavaRoleConfirmServlet
 */
@WebServlet("/JavaRoleConfirmServlet")
public class JavaRoleConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
	private JavaRoleService service;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 此網頁只能 role: Admin 才能進入		
		// get list from service；service.findAllUser() 如果回傳list<JavaRole> 有重要資料(密碼等)外洩風險
		
		System.out.println(service.findAllUser());
		request.setAttribute("userList", service.findAllUser());
		
		// dispatcher web
		request.getRequestDispatcher("./WEB-INF/view/javaRoleConfirm.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get parameter
		String user = request.getParameter("user");		
		String active = request.getParameter("active");
		
		System.out.println(user + ", " + active);
		
		service.updateActive(user, active);
		
		response.sendRedirect("http://localhost:8080" + request.getContextPath() + request.getServletPath());
	}

}
