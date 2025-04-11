package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Customer;

public class LocalMainAdd {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testLocalHibernate");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Customer customer = new Customer();
		customer.setCountry("Japan");
		customer.setFirstName("Tommy");
		customer.setLastName("yama");
		
		em.persist(customer);
		
		et.commit();
		
		em.close();
		emf.close();
		
	}

}
