package com.service.ejb;

import java.util.stream.Stream;

import com.dao.StudentsDao;
import com.model.entity.Students;
import com.repository.StudentRepository;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

/**
 * Session Bean implementation class StudentServiceStatelessJpa
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER) // 自動模式；可寫可不寫。
public class StudentJpaServiceStateless {
    
	// call Dao。 EntityManager 透過 CDI 自動注入 DAO；在呼叫 methods時 
	@Inject
	private StudentRepository repository;
	
	//EJB 已經是 Container-Managed Transactions (CMT)；自動(容器)管理Transaction 機制，可寫可不寫@Transactional
    public boolean addStudent(String studentId, String name, String group, String score, String club) {

    	Students student = repository.getStudents();
    	
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
    	
    	repository.add(student);
    	return true;
    }
	
	public void deleteStudent(String delete) {    	
    	
    	repository.delete(Integer.parseInt(delete));
    }

	public Students findStudent(String update) {		
		
    	Students student = repository.findById(Integer.parseInt(update));
    	
    	return student;
	}
	
	public void updateStudent(String studentId, String name, String group, String score, String club, String id) {	
    	
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

		repository.update(student);
		
	}
}
