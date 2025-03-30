package com.service;

import java.util.List;

import javax.sql.DataSource;

import com.dao.StudentsDao;
import com.dao.impl.StudentsDaoImpl;

import jakarta.annotation.Resource;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateful;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

/**
 * Session Bean implementation class StudentServiceStateful
 */
@Stateful
@LocalBean
public class StudentServiceStateful {
	//server.xml 須建立Resource
	@Resource(name = "jdbc/jndi")
    private DataSource dataSource;
	
	@Inject
	Instance<StudentsDaoImpl> daoInstance;
	StudentsDao sDao;
	
    public StudentServiceStateful() {
        // TODO Auto-generated constructor stub
    }

    public List<?> searchAll() {
    	
    	sDao = daoInstance.get();
    	
    	var list = sDao.getAllStudents();
    	
    	return list;
    }
}
