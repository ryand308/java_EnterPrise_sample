package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.model.Address;
import com.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.jsp.PageContext;

/**
 * Servlet implementation class ScopeServlet
 */
@WebServlet("/ScopeServlet")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//test request
		Employee emp1 = new Employee();
		emp1.setName("Bill");
		emp1.setAddress(new Address("Japan"));
		request.setAttribute("e1", emp1);
		
		// test object
		Employee emp2 = new Employee();
		emp2.setId(1);
		emp2.setName("Jim");
		Address address = new Address();
		address.setLocation("Taiwan");
		emp2.setAddress(address);
		
		//test session
		HttpSession session = request.getSession();
		session.setAttribute("e2", emp2);
		
		// PageContext class 僅存在jsp
		var names = new ArrayList<String>();
		names.add("Levis");
		names.add("roots");
		
		//設定屬性到請求範疇 REQUEST_SCOPE
		request.setAttribute("names", names); 
		request.setAttribute("mark", "hi requestSope");
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/elScope.jsp");
		rd.forward(request, response);
	}


}
