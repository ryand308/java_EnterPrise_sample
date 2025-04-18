package com.controller;

import java.io.IOException;
import java.util.Date;

import com.service.thread.RunUtility;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RunningServlet")
public class RunningServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//encoding in the filter
		//omit
		
		// output
		response.getWriter().append("<h3>Request Thread 1: </h3>")
							.append("<h3>Name: " + Thread.currentThread().getName() +"<br/>")
							.append("Time: " + new Date() + "</h3>")
							.append("<hr/>");
		
		//service methods。執行耗時的工作 (5秒)；自定義類別
		RunUtility.run(5);
		
		//導向結果至view
		request.getRequestDispatcher("./WEB-INF/view/threadResult.jsp").include(request, response);
	}

}
