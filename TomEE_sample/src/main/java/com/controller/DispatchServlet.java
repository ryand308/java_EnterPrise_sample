package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatchServlet
 */
@WebServlet("/DispatchServlet")
public class DispatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 當 網頁(/DispatchServlet)轉向 do 
//		response.setContentType("text/html; charset=utf-8");
		
		// 直接輸入 localhost:8080/BasicServlet/DispatchServlet 會直接接doGet
		
		//-------------output--------------------
		PrintWriter out = response.getWriter();
		out.println("welcome servlet");
		
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 接收存為"utf-8"編碼
//		request.setCharacterEncoding("utf-8");
		
		// 回傳給瀏覽器接收
//		response.setContentType("text/html; charset=utf-8");
		
		//接收變數
		String username =  request.getParameter("username");
		String password = request.getParameter("password");
				
		
		if(username.equals("admin") && password.equals("1234")) {			
			doGet(request, response);			
		}
		else {//false (在/DispatchServlet 合併 LoginForm.html )			

			// 最好的情況是將前後端最完整分離
			RequestDispatcher rd0 = request.getRequestDispatcher("component/error.html");
			rd0.include(request, response);
			// 合併
			RequestDispatcher rd1 = request.getRequestDispatcher("/loginForm.html");
			rd1.include(request, response);
			
		}
		
	}

}
