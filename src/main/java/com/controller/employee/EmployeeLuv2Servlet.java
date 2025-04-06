package com.controller.employee;

import java.io.IOException;

import javax.sql.DataSource;

import com.listener.DataBaseResource;
import com.service.ejb.EmployeeServiceStateful;
import com.service.ejb.EmployeeServiceStateless;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeLuv2Servlet
 */
@WebServlet("/EmployeeLuv2Servlet")
public class EmployeeLuv2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	private EmployeeServiceStateful eService;
    @EJB
    private EmployeeServiceStateless eService2;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB 資料掛載在ServletContext 的 session；只能透過Servlet獲取
		if(DataBaseResource.DB != null) {
			DataSource ds = (DataSource)request.getServletContext().getAttribute(DataBaseResource.DB);
			eService.setDs(ds);			
		}
		
		// service 處理 dao such
		var lists = eService.getFindAll();

		request.setAttribute("emp", lists);
		
		request.getRequestDispatcher("/view/employeeLuv2sql.jsp").forward(request, response);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(DataBaseResource.DB != null) {
			DataSource ds = (DataSource)req.getServletContext().getAttribute(DataBaseResource.DB);
			eService2.setDs(ds);			
		}
		
		//get parameter
		String delete = req.getParameter("delete");
		
		// to service
		eService2.deleteEmployee(delete);
		
		// Redirect
		String url ="http://localhost:8080"+ req.getContextPath() +req.getServletPath();
		System.out.println(url);
		resp.sendRedirect(url);
	}
	

}
