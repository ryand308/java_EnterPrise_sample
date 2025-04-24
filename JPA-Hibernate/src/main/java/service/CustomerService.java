package service;

import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import model.Customer;
import model.Order;
import repository.CustomerRepository;
import repository.OrderRepository;

@ApplicationScoped
public class CustomerService {

	@Inject
	private CustomerRepository repository;
	@Inject
	private OrderRepository orderRepository;
	
	public List<?> findAllCustomer() {	
		
		var list = repository.find();
		
		return list;
	}
	
	public boolean addCustomer(String country, String firstName, String lastName) {
		
		if(Stream.of(country, firstName, lastName).anyMatch(param -> param.trim().matches("")))
			return false;
		//pojo
		Customer customer = new Customer();
		Order order = new Order();
		
		customer.setCountry(country);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);		
		repository.add(customer); // 在新增物件後，會產生 id
		
		long id = customer.getId();
		// 使 customer & order 間的forign key 對應
		if(orderRepository.findById(id) == null)
			orderRepository.add(order);	
		else
			order.setId(id); //將資料 格式化
//			order = orderRepository.findById(id); 獲取舊資料
		
		// OneToOne
		repository.addOrder(id, order);
		
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
//-----------------------------One To One ------------------------------------------------
	public void addRelationOrder( long id, Order order) {		
		System.out.println("id: " + id + ", Order: " + order);
		
		repository.addOrder(id, order);	

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
		Customer customer = repository.findById(id);

		customer.setOrder(null);// order 在 gson 轉換會出現exception

		StringBuilder javaScript = new StringBuilder();
		javaScript.append("<script>")
				  .append("const singleCustomer = \'")
				  .append(gson.toJson(customer) + "\'; ")
				  .append("let customer = JSON.parse(singleCustomer); ")
				  .append("</script>");
		
		return javaScript;

	}
}
