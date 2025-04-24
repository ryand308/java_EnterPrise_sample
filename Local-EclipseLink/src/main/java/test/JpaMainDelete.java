package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Member;

public class JpaMainDelete {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testLocalEclipseLink");
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		Member member = em.find(Member.class, 3);

		System.out.println("Delete: " + member);

		et.begin();

		if(member != null) {
			em.remove(member);
		}

		et.commit();

		em.close();
		emf.close();

	}

}
