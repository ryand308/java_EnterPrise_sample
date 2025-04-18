package com.dao;

import java.util.List;

import com.model.entity.Students;

import jakarta.ejb.Local;

@Local
public interface StudentsDao {

	void add(Students student);
	void update(Students student);
	void delete(int id);
	Students findById(int id);
	List<Students> getAllStudents();
}
