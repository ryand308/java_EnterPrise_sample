package com.listener;

import org.apache.commons.dbcp2.BasicDataSource;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class DataBaseResource implements ServletContextListener {
	public static final String DB = "DB";
	/**
	 * Default constructor.
	 */
	public DataBaseResource() {
		// TODO Auto-generated constructor stub
	}

	public void contextInitialized(ServletContextEvent sce) {
		/*使用 ServletContextListener 初始化資料庫連線池（BasicDataSource）
		 * 1.透過 Listener 在應用啟動時就把連線池建好，這是好做法。
		 * 2.把 DataSource 存到 ServletContext，方便所有 Servlet 存取，等於做了簡單的「手動 JNDI」。
		 * 
		 * 非常標準的分層邏輯（Servlet→Service→DAO），解耦、可測試、好維護。
		 */

		ServletContext servletContext = sce.getServletContext();
		BasicDataSource ds = new BasicDataSource();
		
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("12345678");
		ds.setUrl("jdbc:mysql://localhost:3306/test");
		
		//set connection pool in ServletContext
		servletContext.setAttribute( DB, ds);
		
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

}
