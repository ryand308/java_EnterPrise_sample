package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Customer;

public class LocalMainUpdate {

	public static void main(String[] args) {
		
		// declare
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testLocalHibernate");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		Customer customer = em.find(Customer.class, 1L);
		
		//-----------------Transaction--------------------------
		System.out.println("Before: " + customer);
		
		et.begin();
		
		customer.setFirstName("John");
		customer.setLastName("May");
		customer.setCountry("USA");
		
		et.commit();
		
		System.out.println("After: " + customer);
		em.close();	
		emf.close();
	}
}
