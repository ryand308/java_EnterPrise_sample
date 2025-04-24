package repository;

import java.util.List;

import dto.CustomerDto;
import dto.mapper.CustomerMapper;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import model.Customer;
import model.Order;

/**
 * Session Bean implementation class CustomerDaoImpl
 */
@Stateless
@LocalBean
public class CustomerRepository implements Repository<CustomerDto, Long>{

	@PersistenceContext( unitName = "testHibernate")
	private EntityManager em;
	
    public CustomerRepository() {
        // TODO Auto-generated constructor stub
    }


	public CustomerDto add(CustomerDto customerDto) {
		Customer customer = CustomerMapper.dtoToCustomer(customerDto);
		em.persist(customer);
		
		return CustomerMapper.customerToDto(customer);
	}


	public CustomerDto update(CustomerDto customerDto) {
		Customer customer = CustomerMapper.dtoToCustomer(customerDto); // order = null;
		Order order= em.find(Customer.class, customer.getId()).getOrder();
		customer.setOrder(order);
		em.merge(customer);
		return CustomerMapper.customerToDto(customer);
	}


	public void delete(Long id) {
		Customer customer = em.find(Customer.class, id);

		if(customer != null)
			em.remove(customer);
	}


	public CustomerDto findById(Long id) {
		Customer customer = em.find(Customer.class, id);
		
		CustomerDto dto = CustomerMapper.customerToDto(customer);
		return dto;
	}


	public List<CustomerDto> find() {

		Query query = em.createNamedQuery("CustomerDto.findAll");
		List<CustomerDto> list = query.getResultList();

		return list;
	}

	// ------------   @OneToOne   ---------------------------
	
	public void addOrder(long id, Order order) {		
		Customer customer = em.find(Customer.class, id);
		customer.setOrder(order);
		// 更新作用在 session bean
		em.merge(customer);
		
	}
}
