package service;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import model.Customer;

@ApplicationScoped
public class CustomerService {
	@Inject
	private Instance<CustomerDaoImpl> instanceDao;
	private CustomerDao dao;
	
	public void findAllCustomer() {
		
		dao = instanceDao.get();
		var list = dao.find();
		for(var customer: list)
			System.out.println(customer);
	}
	
	public void AddCustomer(String lastName, String firstName, String country) {
		
		Customer customer = new Customer();
		customer.setLastName(lastName);
		customer.setFirstName(firstName);
		customer.setCountry(country);
		
		dao.add(customer);
		dao.close();
	}
}
