package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Customer;

public class LocalMainDelete {

	public static void main(String[] args) {
		
		//declare
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testLocalHibernate");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		Customer customer = em.find(Customer.class, 2L);
		
		//-----------------Transaction--------------------------
		System.out.println("Delete: " + customer);
		
		et.begin();
		
		if(customer != null)
			em.remove(customer);
		
		et.commit();
		
		em.close();
		emf.close();
	}
}
