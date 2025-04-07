package com.test.jpaEclipseLink;

import com.model.bean.Members;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMainDelete {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eclipseUnit");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		Members member = em.find(Members.class, 3);
		
		System.out.println("Delete: " + member);
		
		et.begin();
		
		if(member != null)
			em.remove(member);
		
		et.commit();
		
		em.close();
		emf.close();
		
	}

}
