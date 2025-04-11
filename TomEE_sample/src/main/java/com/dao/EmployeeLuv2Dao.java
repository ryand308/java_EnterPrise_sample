package com.dao;

import java.util.List;

import com.model.entity.EmployeeLuv2;

public interface EmployeeLuv2Dao {
	
	void add(EmployeeLuv2 e);
	void update(EmployeeLuv2 e);
	void delete(int id);
	EmployeeLuv2 findById(int id);
	List<EmployeeLuv2> getAllEmployeeLuv2();
}
