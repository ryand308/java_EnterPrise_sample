package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/LifecycleServlet")
public class LifecycleServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
	ServletConfig config = null;

	// 初始化 servlet。servlet 生命週期的方法，只會Web 容器調用一次
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		// 被瀏覽器呼叫
		System.out.println("servlet is initialized; servlet 被初始化。");
	}
	
	// 為進入的請求提供響應。在每次請求時被Web 容器調用
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// 回傳網頁格式
		//resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>你好 Servlet</h1>");
	}
	
	// 返回 servletConfig 的對象
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}
	
	// 返回 servlet 信息，如版本、作者等。
	@Override
	public String getServletInfo() {
		
		return "copyright";
	}
	
	// 銷毀。只被調用一次，表示servlet 正在被銷毀
	@Override
	public void destroy() {
		System.out.println("servlet 結束顯示在Console.");
	}

}
