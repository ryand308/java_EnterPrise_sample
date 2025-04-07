package com.test.jpaEclipseLink;

import com.model.bean.Members;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;



public class JpaMainCreate {


	public static void main(String[] args) {
		

		EntityManagerFactory emf =Persistence.createEntityManagerFactory("eclipseUnit", System.getProperties());
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Members member = new Members();		
		member.setName("peter");
		member.setGender('F');
		member.setAddress("7-11");
		member.setPhone("111");
		
		em.persist(member);
		
		et.commit();
			
		
		em.close();
		emf.close();
		
	}

}
