package dao;

import java.util.List;

import javax.sql.DataSource;

import dto.CustomerDto;
import jakarta.ejb.Local;

@Local
public interface CustomerDao {	
	
	void add(CustomerDto customer);
	void update(CustomerDto customer);
	void delete(CustomerDto customer);
	
	CustomerDto findById(Long id);
	List<CustomerDto> find();
	// test DataSource Object
	DataSource getDs();
}
