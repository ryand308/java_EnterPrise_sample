package test;

import java.util.ArrayList;

import com.google.gson.Gson;

import model.Customer;

public class GsonTest {

	public static void main(String[] args) {
		
		Gson gson = new Gson();
		
		Customer customer = new Customer();
		
		System.out.println(customer);
		System.out.println(gson.toJson(customer));
		
		customer.setId(1);
		customer.setFirstName("Mary");
		customer.setLastName("Jan");
		customer.setCountry("UK");
		
		System.out.println(gson.toJson(customer));
		
		System.out.println("-----------------------");
		var list = new ArrayList<Customer>();
		list.add(customer);
		System.out.println(list);
		System.out.println(gson.toJson(list));
	}
}
