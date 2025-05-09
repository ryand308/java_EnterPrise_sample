package com.service;

import java.util.Date;

import com.service.utility.RunUtility;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.AsyncContext;
@ApplicationScoped
public class AsyncRequestProcessor implements Runnable {
	
	// 功能為用於處理較耗時的回應
	private AsyncContext asyncContext;
	
	public AsyncRequestProcessor() {
		super();
	}

	public AsyncRequestProcessor(AsyncContext asyncContext) {
		this.asyncContext = asyncContext;
	}
	
	@Override
	public void run() {
		System.out.println(
			"Request Thread 2:" + "\n" +
			"Name: " + Thread.currentThread().getName() + "\n" +
		    "Time: " + new Date()
		);
		
		RunUtility.run(5);
		
		// ./view/threadResult.jsp or view/threadResult.jsp 是錯誤寫法
		asyncContext.dispatch("/WEB-INF/view/threadResult.jsp");
	}

	public void setAsyncContext(AsyncContext asyncContext) {
		this.asyncContext = asyncContext;
	}	
	

	
}
