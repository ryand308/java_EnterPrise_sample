package test;

import java.util.ArrayList;

import com.google.gson.Gson;

import model.Customer;
import model.Order;

public class GsonTest {

	public static void main(String[] args) {
		
		Gson gson = new Gson();
		
		Customer customer = new Customer();
		
		System.out.println(customer);
		System.out.println(gson.toJson(customer));
		
		customer.setId(1L);
		customer.setFirstName("Mary");
		customer.setLastName("Jan");
		customer.setCountry("UK");
		
		Order order = new Order();
		order.setId(1L);
		order.setAddition("no sugar");
		order.setPay(100);
		
		customer.setOrder(order);
		
		String json = gson.toJson(order);
		System.out.println(json);
		
		System.out.println("-----------------------");
		var list = new ArrayList<Customer>();
		list.add(customer);
		System.out.println(list);
		System.out.println(gson.toJson(list));
	}
}
