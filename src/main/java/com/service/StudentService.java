package com.service;

import java.util.List;

import com.dao.StudentsDao;
import com.dao.impl.StudentsDaoImpl;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * Session Bean implementation class StudentDaoStateful
 */
@ApplicationScoped
public class StudentService {
	//server.xml 須建立Resource
	
	@EJB	
	private StudentsDaoImpl sDaoImpl;
	private StudentsDao sDao;

    public List<?> searchAll() {
    	
    	sDao = sDaoImpl;
    	
    	var list = sDao.getAllStudents();
    	
    	return list;
    }
}
