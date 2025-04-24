package service;

import java.util.stream.Stream;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import model.Order;
import repository.OrderRepository;

@ApplicationScoped
public class OrderService {
	@Inject
	private OrderRepository repository;
	
	public Order addOrder(String addition, String pay) {
		
		if(Stream.of(addition, pay).anyMatch(s -> s.trim().matches("")))
			return null;
		
		int money = Integer.parseInt(pay);
		Order order = new Order();
		order.setPay(money);
		order.setAddition(addition);
		repository.add(order);
		
		return order;
	}
}
