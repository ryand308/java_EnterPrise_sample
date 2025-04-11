package com.listener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ThreadPoolLauncher
 *
 */
@WebListener
public class ThreadPoolLauncher implements ServletContextListener {


    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	// 建立 thread pool，其thread將用於處理耗時的工作
    	ExecutorService es = Executors.newCachedThreadPool();
    	//將 thread pool 放在 ServletContext內，讓所有程式均可取得並利用
    	sce.getServletContext().setAttribute("threads", es);
    }


    public void contextDestroyed(ServletContextEvent sce)  { 

    	ExecutorService es = (ExecutorService)sce.getServletContext().getAttribute("threads");
    	// 網站應用程式關閉時，將先關閉thread pool
    	es.shutdown();
    }
	
}
