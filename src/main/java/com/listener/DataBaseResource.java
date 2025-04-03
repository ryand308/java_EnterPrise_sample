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
		
		//使用 ServletContextListener 初始化資料庫連線池（BasicDataSource）		 
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
