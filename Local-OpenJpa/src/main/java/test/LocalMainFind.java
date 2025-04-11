package test;



import org.junit.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Customer;

public class LocalMainFind {

	@Test
	public void findMain() {
		
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("OpenJpaUnit", System.getProperties());
	    EntityManager em = emf.createEntityManager();
	    
	    Customer customer = em.find(Customer.class, 1L);
	    
	    System.out.println(customer);
	}
}
