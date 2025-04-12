package dao;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.Customer;

@Dependent
public class CustomerDaoImpl implements CustomerDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("testLocalHibernate");
	private EntityManager em = emf.createEntityManager();
	
	private EntityTransaction et = em.getTransaction();	
	
	@Override
	public void add(Customer customer) {

		et.begin();
		if(customer != null)
			em.persist(customer);
		et.commit();

	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAll() {

		Query query = em.createNamedQuery("Customer.findAll");
		var list = query.getResultList();
		return list;
	}

	public void close() {
		em.close();
		emf.close();
	}
}