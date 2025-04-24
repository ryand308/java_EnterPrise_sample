package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dto.CustomerDto;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import model.Customer;

/**
 * Session Bean implementation class CustomerDaoImpl
 */
@Stateless
public class CustomerDaoImpl implements CustomerDao {

	@Resource(name = "jndi/mysql")
	private DataSource ds;
	@Inject
	private Instance<CustomerDto> dto;
	
	@Override
	public DataSource getDs() {
		
		return ds;
	}

    //---------------JDBC------------------------
	@Override
	public void add(CustomerDto customer) {
		
		
	}

	@Override
	public void update(CustomerDto customer) {
		
		
	}

	@Override
	public void delete(CustomerDto customer) {
		
	}

	@Override
	public CustomerDto findById(Long id) {
		
		return null;
	}

	@Override
	public List<CustomerDto> find() {
		String sql = "select * from company.customers";
		var list = new ArrayList<CustomerDto>();
		try(Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				// 在dao tier 處理本應在 service tier 才處理的業務；這樣會把ResultSet 當物件往上層傳
				CustomerDto customer = dto.get();
				customer.setId(rs.getLong(1));
				customer.setCountry(rs.getString(2));
				customer.setFirstName(rs.getString(3));
				customer.setLastName(rs.getString(4));
				list.add(customer);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	

}
