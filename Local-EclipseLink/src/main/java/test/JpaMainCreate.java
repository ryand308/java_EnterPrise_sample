package test;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Member;



public class JpaMainCreate {

	public static void main(String[] args) {
		
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("testLocalEclipseLink", System.getProperties());
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Member member = new Member();		
		member.setName("peter");
		member.setGender('F');
		member.setAddress("beijing");
		member.setPhone("0999-888888");
		
		em.persist(member);
		
		et.commit();
			
		
		em.close();
		emf.close();
		
	}

}
