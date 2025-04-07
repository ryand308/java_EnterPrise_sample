package com.service.thread;

import java.util.Date;

import jakarta.servlet.AsyncContext;

public class AsyncRequestProcessor implements Runnable {
	
	// 功能為用於處理較耗時的回應
	private AsyncContext asyncContext;
	
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
		asyncContext.dispatch("/view/threadResult.jsp");
	}	
	


}
