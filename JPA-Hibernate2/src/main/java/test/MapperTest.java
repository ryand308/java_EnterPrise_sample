package test;

import dto.CustomerDto;
import dto.mapper.CustomerMapper;
import model.Customer;

public class MapperTest {

	public static void main(String[] args) {

		CustomerDto dto = new CustomerDto();
		dto.setId(1);
		dto.setCountry("tt");
		dto.setFirstName("yy");
		dto.setLastName("jj");
		
		System.out.println(dto);
		
		Customer customer = CustomerMapper.dtoToCustomer(dto);
		System.out.println(customer);
		

	}

}
