package com.controller;

import java.io.IOException;

import javax.sql.DataSource;

import com.dao.impl.EmployeeLuv2DaoStateless;
import com.listener.DataBaseResource;
import com.model.entity.EmployeeLuv2;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeLuv2UpdateServlet
 */
@WebServlet("/EmployeeLuv2UpdateServlet")
public class EmployeeLuv2UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private EmployeeLuv2DaoStateless daoService;
	private String update = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(DataBaseResource.DB != null) {
			DataSource ds = (DataSource)request.getServletContext().getAttribute(DataBaseResource.DB);
			daoService.setDs(ds);
		}
		// get parameter
		update = request.getParameter("update");
		
		// service
		if(update != null)
			request.setAttribute("employee", daoService.selectEmployee(update));
		else
			response.sendRedirect("http://localhost:8080/ServletBasic/EmployeeLuv2Servlet"); //防止無id 更新
		
		// output
		request.getRequestDispatcher("./view/employeeUpdate.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(DataBaseResource.DB != null) {
			DataSource ds = (DataSource)request.getServletContext().getAttribute(DataBaseResource.DB);
			daoService.setDs(ds);
		}
		
		// get parameter
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String department = request.getParameter("department");
		String salary = request.getParameter("salary");
		
		String id = update;	
		// service
		daoService.updateEmployee(lastName, firstName, email, department, salary, id);
		
		// redirect	回表單
		response.sendRedirect("http://localhost:8080/ServletBasic/EmployeeLuv2Servlet");
		
	}

}
