package com.test.jpaEclipseLink;

import com.model.bean.Members;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaMainFind {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eclipseUnit");
		EntityManager em = emf.createEntityManager();
		
		Members member = em.find(Members.class, 1);
		Members member2 = em.find(Members.class, 2);
		Members member3 = em.find(Members.class, 3);
		
		Members[] members = {member, member2, member3};
		
		for(Members m: members)
			if(m != null)
				System.out.println(m);

		/*
		 * entityManagerFactory
		 * entityManager
		 * 不能.close();
		 */
	}

}
