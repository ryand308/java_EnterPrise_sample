package repository;

import java.util.List;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import model.Customer;

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


	public void delete(Customer customer) {
		if(customer != null)
			em.remove(customer);
	}


	public Customer findById(Long id) {
		Customer customer = em.find(Customer.class, id);
		return customer;
	}


	public List<Customer> find() {

		Query query = em.createNamedQuery("Customer.findAll");
		var list = query.getResultList();
		return list;
	}


}
