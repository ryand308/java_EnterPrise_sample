package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Customer;

public class LocalMainFind {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testLocalHibernate");
		EntityManager em = emf.createEntityManager();
		
		Customer customer = em.find(Customer.class, 1L);
		
		System.out.println(customer);

	}

}
