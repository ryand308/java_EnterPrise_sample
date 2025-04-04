package com.dao.impl;

import java.util.List;

import com.dao.StudentsDao;
import com.model.entity.Students;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Dependent // 這是 CDI 的 Scope，讓 CDI 容器管理這個 Bean
public class StudentJpaDaoImpl implements StudentsDao {
	//成功注入 
	@PersistenceContext(unitName = "myPersistenceUnit")
	private EntityManager em;
	
	//getter	
	public Students getStudents() {
		return new Students();
	}	
	
	//method
	@Override
	@Transactional
	public void add(Students student) {
		em.persist(student);
	}

	@Override
	@Transactional
	public void update(Students student) {
		em.merge(student);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Students student = this.findById(id);
		if(student != null)
			em.remove(student);
	}

	@Override
	@Transactional
	public Students findById(int id) {		
		return em.find(Students.class, id);
	}

	@Override
	@Transactional
	public List<Students> getAllStudents() {
		// 需使用 JPQL 語法
		Query query = em.createQuery("SELECT s FROM Students s", Students.class);
		List<Students> results = query.getResultList();
		
		return results;
	}

}
