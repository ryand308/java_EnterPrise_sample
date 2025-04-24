package controller;

import java.io.IOException;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

@WebServlet("/MemberAddServlet")
public class MemberAddServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Inject
	private MemberService service;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//get parameter
		String name = "Maga";
		char gender = 'M';
		String address = "singapore";
		String phone = "0999-888888";
		
		// method from service
		service.addMember(name, gender, address, phone);
		
		resp.getWriter().append(" Add Member Page: ")
						.append(req.getServerName());
	}

	
}
