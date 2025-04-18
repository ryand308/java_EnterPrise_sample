package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.dao.StudentsDao;
import com.model.entity.Students;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class StudentsDaoImpl implements StudentsDao {
	//server.xml 須建立Resource
	@Resource(name = "jdbc/jndi")
	private DataSource ds;
	
	@PersistenceContext( unitName = "myPersistenceUnit") //openJpa 
	EntityManager em;
	
//	public StudentsDaoImpl() {
//		DataSource ds = null;
//		
//		/* 1.做 Naming JNDI配置:context.xml可運行，但在關閉伺服器時，伺服器在service 找不到全域資源；Naming 的配置，無法清理，導致Exception。
//		 * 2.正確做法在 資源須在context.xml 和 server.xml 配置；server.xml <GlobalNamingResources /> 在伺服器上會做搜尋。 
//		 */
//		try {
//			Context ctx = new InitialContext();
//			if(ctx == null)
//				throw new RuntimeException("JNDI not found.");
//			
//			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/jndi");
//			if(ds == null)
//				throw new RuntimeException("DataSource not found.");
//			
//			
//		} catch(NamingException e) {
//			e.printStackTrace();
//		}	
//		
//	}
	
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
		
		String sql = "select * from test.students";  //JDBC 的寫法
		
		var list = new ArrayList<Students>();
		
		try(Statement stmt = ds.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			) {
		
			while(rs.next()) {
				Students student = new Students();				
				student.setId(rs.getInt("ID"));
				student.setStudentId(rs.getInt("學號"));
				student.setName(rs.getString("姓名"));
				student.setGroup(rs.getString("班級"));
				student.setScore(rs.getInt("成績"));
				student.setClub(rs.getInt("社團"));
				
				list.add(student);
			}			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return list;
	}

}
