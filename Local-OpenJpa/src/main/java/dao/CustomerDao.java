package dao;

import java.util.List;

import model.Customer;

public interface CustomerDao {

	void add(Customer customer);
	void update(Customer customer);
	void delete(Long id);
	
	Customer findById(Long id);
    List<Customer> find();
    
    void close();
}
