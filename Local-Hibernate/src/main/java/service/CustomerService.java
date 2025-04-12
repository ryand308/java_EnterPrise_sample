package service;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
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
		var list = dao.getAll();
		
		for(var customer: list)
			System.out.println(customer);
		
		//hibernate 區域查詢要關閉
		dao.close();
	}
	
	public void addCustomer(String lastName, String firstName, String country) {
		
		dao = instanceDao.get();
		Customer customer = new Customer();
		customer.setLastName(lastName);
		customer.setFirstName(firstName);
		customer.setCountry(country);
		
		dao.add(customer);
		dao.close();
	}
}
