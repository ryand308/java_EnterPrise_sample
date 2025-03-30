package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleTestServlet
 */
@WebServlet(urlPatterns = "/LifeCycleTestServlet", initParams = @WebInitParam(name = "myParam", value = "my Parameter test"))
public class LifeCycleTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@PostConstruct
	public void initial() {
		System.out.println("The container calls the initial method during execution.");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("Original init() hooks!");
	}

	
	@Override
	public void destroy() {		
		System.out.println("call original destroy() method.");
	}
	
	@PreDestroy
	public void fracture() {
		System.out.println("The container calls the fracture() method, when the servers are shutting down.");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"resource/css/lifeCycleList.css\" />");
		
		
		
		RequestDispatcher dp = request.getRequestDispatcher("./view/lifeCycleList.html");
		dp.include(request, response);
	}

}
