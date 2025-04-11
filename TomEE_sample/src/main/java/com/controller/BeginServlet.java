package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//@WebServlet("/BeginServlet") 早期的WebServlet 是寫在 web.xml；@ 適合測試與小型開發。同一class annotation 與 web.xml 配置不要並用。
public class BeginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// request from index.html list
		String name = request.getParameter("name");
		
		//-----------------------------------------------
		// servlet 頁面接收到來自 index.html，對信息反映在 /BeginServlet的頁面上，輸出至瀏覽器  
		
		// output in web browser
		PrintWriter out = response.getWriter();
		out.println("Welcome " + name);
		
		out.close();
	}


}
