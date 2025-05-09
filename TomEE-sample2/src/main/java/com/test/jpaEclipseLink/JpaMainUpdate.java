package com.test.jpaEclipseLink;

import com.model.bean.Members;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMainUpdate {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eclipseUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Members member = em.find(Members.class, 1);
		
		//-----------------Transaction--------------------------
		System.out.println("Before: " + member);
		
		et.begin();
		
		member.setName("parker");
		member.setAddress("6-10");		
		
		et.commit();
		
		System.out.println("After: " + member);
		em.close();
		emf.close();
	}

}
