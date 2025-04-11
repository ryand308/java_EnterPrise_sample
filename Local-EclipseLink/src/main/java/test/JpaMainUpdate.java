package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Member;

public class JpaMainUpdate {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testLocalEclipseLink");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Member member = em.find(Member.class, 1);
		
		//-----------------Transaction--------------------------
		System.out.println("Before: " + member);
		
		et.begin();
		
		member.setName("Ryan");			
		
		et.commit();
		
		System.out.println("After: " + member);
		em.close();
		emf.close();
	}

}
