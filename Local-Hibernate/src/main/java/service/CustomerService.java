package service;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import model.Customer;

public class CustomerService {

	private CustomerDao dao;
	
	public void findAllCustomer() {
		
		dao = new CustomerDaoImpl();
		var list = dao.getAll();
		
		for(var customer: list)
			System.out.println(customer);
	}
	
	public void addCustomer(String lastName, String firstName, String country) {
		
		dao = new CustomerDaoImpl();
		Customer customer = new Customer();
		customer.setLastName(lastName);
		customer.setFirstName(firstName);
		customer.setCountry(country);
		
		dao.add(customer);
		dao.close();
	}
}
