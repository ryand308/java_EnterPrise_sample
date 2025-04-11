package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.Address;
import com.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ExpressionServlet")
public class ExpressionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// test variable
		request.setAttribute( "myNum", 0);
		request.setAttribute( "myStr", "e2");
		
		// Java bean
		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("凱");
//		Address address = new Address();
//		address.setLocation("Taiwan");
		emp1.setAddress(new Address("Taiwan"));
		request.setAttribute("emp1", emp1);
		
		Employee emp2 = new Employee();
		emp2.setName("Jom");
		
		//Map
		Map<String, Employee> map = new HashMap<>();
		map.put("e1", emp1);
		map.put("e2", emp2);
		request.setAttribute("map", map);
		
		//List
		List<Employee> list = new ArrayList<>();
		list.add(emp1);
		list.add(emp2);
		request.setAttribute("list", list);
		
		//Array
		Employee[] array = new Employee[2];
		array[0] = emp1;
		array[1] = emp2;
		request.setAttribute("array", array);
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/elAccess.jsp");
				
		rd.forward(request, response);
	}

}
