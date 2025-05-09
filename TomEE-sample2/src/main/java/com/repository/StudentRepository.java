package com.repository;

import java.util.List;

import com.model.entity.Students;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Stateless
@LocalBean
public class StudentRepository {
	//成功注入 
	@PersistenceContext(unitName = "myPersistenceUnit", type =  PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	//getter	
	public Students getStudents() {
		return new Students();
	}	
	
	//method
	@Transactional
	public void add(Students student) {
		em.persist(student);
	}

	@Transactional
	public void update(Students student) {
		em.merge(student);
	}

	@Transactional
	public void delete(int id) {
		Students student = this.findById(id);
		if(student != null)
			em.remove(student);
	}

	@Transactional
	public Students findById(int id) {		
		return em.find(Students.class, id);
	}

	@Transactional
	public List<Students> findAll() {
		// 需使用 JPQL 語法
		Query query = em.createQuery("SELECT s FROM Students s", Students.class);
		List<Students> results = query.getResultList();
		
		return results;
	}

}
