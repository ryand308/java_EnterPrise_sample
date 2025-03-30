package com.controller;

import java.io.IOException;
import java.util.List;

import com.model.entity.Students;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.UserTransaction;


@WebServlet("/StudentPersistenceServlet")
public class StudentPersistenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "myPersistenceUnit")
	EntityManager em;
	@Resource
	UserTransaction ut;  // 取得事務管理器
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//JPQL 使用是 類別名稱( 轉到 Service)
		Query query = em.createQuery("SELECT s FROM Students s", Students.class);
		List<Students> results = query.getResultList();
		
		// output
//		for(var r: results)
//			System.out.printf("ID:%3d  學號:%5d  姓名:%3s  班級:%s 成績:%3d 社團:%d%n",r.getId(), r.getStudentId(), r.getName(), r.getGroup(), r.getScore(), r.getClub());

		request.setAttribute("stu1", results);
		
		request.getRequestDispatcher("./view/studentSqlPersistence.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
