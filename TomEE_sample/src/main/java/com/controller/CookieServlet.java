package com.controller;

import java.io.IOException;

import com.config.AppConfig;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {	
       
	@Inject
	AppConfig aConfig;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 測試注入
		System.out.println(aConfig.getTest());
		
		// 收集表單的變數
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String msg = request.getParameter("msg");
		
		Cookie[] cookie = { 
				new Cookie("fname", fname),
				new Cookie("lname", lname),
				new Cookie("msg", msg)
		};
		// setMaxAge(10) 在瀏覽器保存10秒
		for(Cookie c: cookie) {
			c.setMaxAge(30);
			response.addCookie(c);
		}
		
		// 需要轉跳網址；
		response.sendRedirect("/ServletBasic/view/cookieInfo.jsp");
	}

}
