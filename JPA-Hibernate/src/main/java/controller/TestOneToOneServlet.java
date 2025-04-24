package controller;

import java.io.IOException;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Order;
import service.CustomerService;
import service.OrderService;

/**
 * Servlet implementation class TestOneToOneServlet
 */
@WebServlet("/TestOneToOneServlet")
public class TestOneToOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private CustomerService service;
	@Inject
    private OrderService service2;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//get parameter
		String county = "USA";
		String firstName = "Lady";
		String lastName = "Gaga";
		
		String addition ="無糖";
		String pay	 = "500";
		
		// 先存 Customer，再存Order，最後更新加入Order物件的Customer；不能包if 判斷式，會出現exception
		service.addCustomer(county, firstName, lastName);
		Order order = service2.addOrder(addition, pay);
		service.addRelationOrder(order.getId(), order);
		
				
		response.sendRedirect("http://localhost:8080/testHibernate/");
		
			
	}

	

}
