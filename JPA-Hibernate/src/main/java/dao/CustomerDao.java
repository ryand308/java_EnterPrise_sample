package dao;

import java.util.List;

import javax.sql.DataSource;

import jakarta.ejb.Local;
import model.Customer;

@Local
public interface CustomerDao {	
	
	void add(Customer customer);
	void update(Customer customer);
	void delete(Customer customer);
	
	Customer findById(Long id);
	List<Customer> find();
	// test DataSource Object
	DataSource getDs();
}
