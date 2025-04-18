package dao;

import java.util.List;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import model.Customer;

/**
 * Session Bean implementation class CustomerDaoImpl
 */
@Stateless
public class CustomerDaoImpl implements CustomerDao {

	@Resource(name = "jndi/mysql")
	private DataSource ds;
	
	@Override
	public DataSource getDs() {
		
		return ds;
	}

    //---------------JDBC------------------------
	@Override
	public void add(Customer customer) {
		
		
	}

	@Override
	public void update(Customer customer) {
		
		
	}

	@Override
	public void delete(Customer customer) {
		
	}

	@Override
	public Customer findById(Long id) {
		
		return null;
	}

	@Override
	public List<Customer> find() {

		return null;
	}

	

}
