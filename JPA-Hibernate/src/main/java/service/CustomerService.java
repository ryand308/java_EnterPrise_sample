package service;

import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import model.Customer;
import repository.CustomerRepository;

@ApplicationScoped
public class CustomerService {

	@Inject
	private CustomerRepository repository;
	
	public List<?> findAllCustomer() {	
		
		var list = repository.find();
		
		return list;
	}
	
	public boolean addCustomer(String country, String firstName, String lastName) {
		
		if(Stream.of(country, firstName, lastName).anyMatch(param -> param.trim().matches("")))
			return false;
		
		Customer customer = new Customer();
		customer.setCountry(country);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		
		repository.add(customer);
		return true;
	}
	
	public void deleteCustomer(String delete) {
		
		long id = Long.parseLong(delete);
		// 不要使用傳物件delete 會Exception
		repository.delete(id);
		
	}
	
	public void updateCustomer(String  update, String country, String firstName, String lastName) {
		long id = Long.parseLong(update);
		//pojo
		Customer customer = repository.findById(id);
		customer.setId(id);
		if(!country.trim().matches(""))
			customer.setCountry(country);
		if(!firstName.trim().matches(""))
			customer.setFirstName(firstName);
		if(!lastName.trim().matches(""))
			customer.setLastName(lastName);
			
		repository.update(customer);
		
	}
//-----------------------------Json & JavaScript------------------------------------------------
	
	public StringBuilder findAllCustomerJson() {
		Gson gson = new Gson();
		StringBuilder javaScript = new StringBuilder();
		// 定義 javaScript 變數 "customers"
		javaScript.append("<script>")
			.append("const customers = \'")
			.append(gson.toJson(repository.find()) + "\';")
			.append("const customer = JSON.parse(customers); ")
			.append("</script>");		
		
		return javaScript;
	}
	
	public StringBuilder idNullDeclare() {		
		StringBuilder javaScript = new StringBuilder();
		javaScript.append("<script>")
			.append("const customer = null") 
            .append("</script>");
		
		return javaScript;
	}
	
	public StringBuilder findCustomerJson(String update) {
		long id = Long.parseLong(update);
		Gson gson = new Gson();
		StringBuilder javaScript = new StringBuilder();
		// 定義 javaScript 變數 "singleCustomer"
		javaScript.append("<script>")
				  .append("const singleCustomer = \'")
				  .append(gson.toJson(repository.findById(id)) + "\'; ")
				  .append("let customer = JSON.parse(singleCustomer); ")
				  .append("</script>");
		
		return javaScript;
	}
}
