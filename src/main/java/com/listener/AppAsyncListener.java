package com.listener;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.AsyncEvent;
import jakarta.servlet.AsyncListener;
import jakarta.servlet.ServletResponse;

public class AppAsyncListener implements AsyncListener{

	@Override
	public void onComplete(AsyncEvent event) throws IOException {
		// 完成
		System.out.println("AppAsyncListener onComplete: " + new Date());
	}

	@Override
	public void onError(AsyncEvent event) throws IOException {
		// 出錯
		System.out.println("AppAsyncListener onError.");
		
	}

	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
		// 啟動
		System.out.println("AppAsyncListener onStartAsync.");
	}

	@Override
	public void onTimeout(AsyncEvent event) throws IOException {
		// 超出時間
		System.out.println("AppAsyncListener onTimeout.");
		
		ServletResponse resp = event.getAsyncContext().getResponse();
		
		resp.getWriter().print("TimeOut Error in Processing.");
		
	}

}
