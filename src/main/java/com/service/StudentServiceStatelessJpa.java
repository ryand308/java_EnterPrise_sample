package com.service;

import java.util.stream.Stream;

import com.dao.StudentsDao;
import com.dao.impl.StudentJpaDaoImpl;
import com.model.entity.Students;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

/**
 * Session Bean implementation class StudentServiceStatelessJpa
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER) // 自動模式；可寫可不寫，可使用@Transactional
public class StudentServiceStatelessJpa {

	@PersistenceContext(unitName = "myPersistenceUnit")
	private EntityManager em;
    
	// call Dao；dao 被EntityManger取代
	@Inject
	private Instance<StudentJpaDaoImpl> daoInstance;
	private StudentsDao sDao;
	
	@Transactional
    public boolean addStudent(String studentId, String name, String group, String score, String club) {
    	sDao = daoInstance.get();
    	((StudentJpaDaoImpl)sDao).setEm(em);
    	Students student = ((StudentJpaDaoImpl)sDao).getStudents();
    	
    	String[] total = {studentId, name, group, score, club};
    	//fail
    	if(Stream.of(total).anyMatch(t -> t.trim().matches("")))
    		return false;
		
    	// student.set
    	student.setStudentId(Integer.parseInt(studentId));
    	student.setName(name);
    	student.setGroup(group);
    	student.setScore(Integer.parseInt(score));
    	student.setClub(Integer.parseInt(club));
    	
    	sDao.add(student);
    	return true;
    }
	
	@Transactional
	public void deleteStudent(String delete) {
    	sDao = daoInstance.get();
    	((StudentJpaDaoImpl)sDao).setEm(em);
    	
    	sDao.delete(Integer.parseInt(delete));
    }

	@Transactional
	public Students findStudent(String update) {
		sDao = daoInstance.get();
    	((StudentJpaDaoImpl)sDao).setEm(em);
		
    	Students student = sDao.findById(Integer.parseInt(update));
    	
    	return student;
	}
	
	@Transactional
	public void updateStudent(String studentId, String name, String group, String score, String club, String id) {	
		sDao = daoInstance.get();
    	((StudentJpaDaoImpl)sDao).setEm(em);
    	
    	Students student = this.findStudent(id);
    	
    	if(!studentId.trim().matches("") && studentId.matches("\\d+"))
    		student.setStudentId(Integer.parseInt(studentId));
    	
    	if(!name.trim().matches(""))    		
    		student.setName(name);
    	
    	if(!group.trim().matches(""))
    		student.setGroup(group);
    	
    	if(!score.trim().matches("") && score.matches("\\d+"))
    		student.setScore(Integer.parseInt(score));
    	
    	if(!club.trim().matches("") && club.matches("\\d+"))
    		student.setClub(Integer.parseInt(club));
    	
//    	sDao.update(students);
		sDao.update(student);
		
	}
}
