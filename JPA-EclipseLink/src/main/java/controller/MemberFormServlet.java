package controller;

import java.io.IOException;
import java.util.Arrays;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

/**
 * Servlet implementation class MemberFormServlet
 */
@WebServlet("/MemberFormServlet")
public class MemberFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
	private MemberService service;
    private String id = null;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		id = request.getParameter("update"); // null 用於update
		if(id != null) {
			System.out.println(service.findMember(id));
			request.setAttribute("member", service.findMember(id));			
		}
		
		request.getRequestDispatcher("./WEB-INF/view/MemberForm.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get Parameter			
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		// check value
		String[] total = {name, sex, address, phone, id};
		System.out.println(Arrays.toString(total));
		
		// get method from service
		if( id != null ) {
			service.updateMember(id, name, sex, address, phone);
			response.sendRedirect("http://localhost:8080/testEclipseLink/MemberServlet");
		}
		else if(service.addMember(name, sex, address, phone))
			response.sendRedirect("http://localhost:8080/testEclipseLink/formSuccess.html");
		else
			response.sendRedirect("http://localhost:8080/testEclipseLink/formFailure.html");
	}

}
