package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig(
		location = "D:\\java_eclipse\\uploaded", 
		maxFileSize = 1024*1024*200,	//資料上限大小：200MB
		fileSizeThreshold = 1024*1024*2)//緩衝：2MB

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/component/header.html").include(request, response);
		getServletContext().getRequestDispatcher("/component/uploadFile.html").include(request, response);
	}



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part p1 = request.getPart("desc");
		BufferedReader r = new BufferedReader(new InputStreamReader(p1.getInputStream()));
		String desc = r.readLine();
		
		//session 
		HttpSession session = request.getSession();
		session.setAttribute("desc", desc);
		
		// (取得上傳的檔案)
		Part p2 = request.getPart("data");
		String file = p2.getSubmittedFileName();
		
		//將上傳檔案 儲存至路徑中"D:\\java_eclipse\\uploaded"
		p2.write(file);
		
		response.getWriter().println("檔案：" + file + " 。上傳成功");
		
		// 轉跳
		response.sendRedirect("./view/uploadSuccess.jsp");
		
	}	

	
}
