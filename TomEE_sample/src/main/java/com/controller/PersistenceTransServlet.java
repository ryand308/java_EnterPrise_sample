package com.controller;

import java.io.IOException;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.UserTransaction;

/**
 * Servlet implementation class PersistenceTransServlet
 */
@WebServlet("/PersistenceTransServlet")
public class PersistenceTransServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @PersistenceContext( unitName = "myPersistenceUnit")
	private EntityManager em;
	
	@Resource			 // transaction 作用在servlet 手動
	private UserTransaction ut;  // 取得事務管理器；內部的DB 以連線
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 手動測試
		try {
			ut.begin();
			// 測試Transaction
			System.out.println("Transaction's BMT Test");
			ut.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		} 	
		
		response.getWriter().append("<h3>網頁測試 Persistence & Transaction。出現為設定正常</h3> ");
	}

	

}
