package repository;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
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
public class CustomerRepository {

	@PersistenceContext( unitName = "testHibernate")
	private EntityManager em;
	
    public CustomerRepository() {
        // TODO Auto-generated constructor stub
    }


	public void add(Customer customer) {
		em.persist(customer);
	}


	public void update(Customer customer) {
		em.merge(customer);
		
	}


	public void delete(long id) {
		Customer customer = this.findById(id);
		if(customer != null)
			em.remove(customer);
	}


	public Customer findById(long id) {
		Customer customer = em.find(Customer.class, id);
		return customer;
	}


	public List<Customer> find() {

		Query query = em.createNamedQuery("Customer.findAll");
		var list = query.getResultList();
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
