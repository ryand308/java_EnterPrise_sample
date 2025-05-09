package com.controller;

import java.io.IOException;

import com.google.gson.JsonObject;
import com.service.utility.JsonUtility;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/AjaxQueryServlet")
public class AjaxQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
	private JsonUtility utility;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// get parameter
		String name = request.getParameter("name");
		
		// service
		JsonObject json;
		if(name == null || name.matches(""))
			json = utility.data("none");
		else
			json = utility.data(name);
		
		try { // 1 秒後傳值
			Thread.sleep(1000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		// output
		response.getWriter().append(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
