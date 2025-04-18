package service;

import java.util.List;

import com.google.gson.Gson;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import model.Customer;
import repository.CustomerRepository;

@ApplicationScoped
public class CustomerService {

	@Inject
	private CustomerRepository repository;
	
	public List<?> findCustomer() {	
		
		var list = repository.find();
		
		return list;
	}
	
	public void addCustomer(String country, String firstName, String lastName) {
		
		Customer customer = new Customer();
		customer.setCountry(country);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		
		repository.add(customer);
	}
	
//-----------------------------Json------------------------------------------------
	
	public StringBuilder findCustomerJson() {
		Gson gson = new Gson();
		StringBuilder data = new StringBuilder();
		// 定義 javaScript 變數 "customers"
		data.append("<script> const customers = \'")
			.append(gson.toJson(repository.find()))
			.append("\'</script>");		
		
		return data;
	}
}
