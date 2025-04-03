package com.dao.impl;

import java.util.List;

import com.dao.StudentsDao;
import com.model.entity.Students;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Dependent
public class StudentJpaDaoImpl implements StudentsDao {
	// 再來考慮是設定方式；constructor or setter form EJB of service
	private EntityManager em;
	//setter
	public void setEm(EntityManager em) {
		this.em = em;
	}
	//getter
	public Students getStudents() {
		return new Students();
	}	
	
	//method
	@Override
	public void add(Students student) {
		em.persist(student);
	}

	@Override
	public void update(Students student) {
		em.merge(student);
	}

	@Override
	public void delete(int id) {
		Students student = this.findById(id);
		if(student != null)
			em.remove(student);
	}

	@Override
	public Students findById(int id) {		
		return em.find(Students.class, id);
	}

	@Override
	public List<Students> getAllStudents() {
		// 需使用 JPQL 語法
		Query query = em.createQuery("SELECT s FROM Students s", Students.class);
		List<Students> results = query.getResultList();
		
		return results;
	}

}
