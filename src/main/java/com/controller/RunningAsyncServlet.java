package com.controller;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;

import com.listener.AppAsyncListener;
import com.service.thread.AsyncRequestProcessor;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RunningAsyncServlet
 */
@WebServlet(urlPatterns = "/RunningAsyncServlet", asyncSupported = true)
public class RunningAsyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//功能為使用非同步技術分離處理 request 和 response 的 thread
		
		// output
		response.getWriter().append("<h3>Request async Thread 1: </h3>")
							.append("<h3>Name: " + Thread.currentThread().getName() +"<br/>")
							.append("Time: " + new Date() + "</h3>")
							.append("<hr/>");
		System.out.println("Request Thread 1.");
		
		AsyncContext asyncCtx = request.startAsync();
		asyncCtx.addListener(new AppAsyncListener());
		//代表設定 非同步操作最多允許執行 9 秒（9000 毫秒）
		asyncCtx.setTimeout(9000);
		
		ExecutorService es = (ExecutorService) request.getServletContext().getAttribute("threads");
		es.execute(new AsyncRequestProcessor(asyncCtx));
	}

}
