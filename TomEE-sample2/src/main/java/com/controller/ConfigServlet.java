package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.config.AppConfig;

import jakarta.inject.Inject;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//@WebServlet("/ConfigServlet")
public class ConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject // 當共用物件使用 new 來建立，會無法實現共享，在別的類別拿來使用時又在 new 一個新的物件雖然擁有相同著值，卻生成兩個相同的物件。(浪費系統資源)
    private AppConfig aConfig;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// servlet 的信息配置；非@ annotation: web.xml 的配置要寫 init(ServletConfig sConfig)
		ServletConfig config = this.getServletConfig();
		
		// getInitParameter() 須從 web.xml 配置中獲得；其doGet()輸出不會產生 localhost:8080?driver="value"
		String driver = config.getInitParameter("driver");
		
		// 測試注入
		System.out.println(aConfig.getTest());
		
		
		//------------------- output ------------------------- 
		PrintWriter out = response.getWriter();
		
		out.println("Class.forName() = " + driver);
		
		out.close();
	}
	

}
