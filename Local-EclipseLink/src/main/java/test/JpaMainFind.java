package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Member;

public class JpaMainFind {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testLocalEclipseLink");
		EntityManager em = emf.createEntityManager();
		
		Member member = em.find(Member.class, 1);
		Member member2 = em.find(Member.class, 2);
		Member member3 = em.find(Member.class, 3);
		
		Member[] members = {member, member2, member3};
		
		for(Member m: members)
			if(m != null)
				System.out.println(m);


	}

}
