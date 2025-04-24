package dto.mapper;

import dto.CustomerDto;
import model.Customer;

public class CustomerMapper{


	public static CustomerDto customerToDto(Customer customer) {
		
		CustomerDto dto = new CustomerDto(	customer.getId(),
											customer.getCountry(),
											customer.getFirstName(),
											customer.getLastName());

		return dto;
	}
	
	public static Customer dtoToCustomer(CustomerDto dto) {
	
		Customer customer = new Customer( dto.getId(),
										  dto.getCountry(),
										  dto.getFirstName(),
										  dto.getLastName());
		return customer;
	}		
}
