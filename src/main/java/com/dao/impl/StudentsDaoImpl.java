package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.dao.StudentsDao;
import com.model.entity.Students;

import jakarta.enterprise.context.Dependent;

@Dependent
public class StudentsDaoImpl implements StudentsDao {
	
	private DataSource dataSource;	

	public StudentsDaoImpl() {		
		this.dataSource = getDataSource();
	}
	
	private DataSource getDataSource() {
		DataSource ds = null;
		
		/* 1.做 Naming JNDI配置:context.xml可運行，但在關閉伺服器時，伺服器在service 找不到全域資源；Naming 的配置，無法清理，導致Exception。
		 * 2.正確做法在 資源須在context.xml 和 server.xml 配置；server.xml <GlobalNamingResources /> 在伺服器上會做搜尋。 
		 */
		try {
			Context ctx = new InitialContext();
			if(ctx == null)
				throw new RuntimeException("JNDI not found.");
			
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/jndi");
			if(ds == null)
				throw new RuntimeException("DataSource not found.");
			
			
		} catch(NamingException e) {
			e.printStackTrace();
		}
		
		return ds;
	}
	@Override
	public void add(Students student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Students student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Students findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Students> getAllStudents() {

		String sql = "select * from test.students";
		
		var list = new ArrayList<Students>();
		
		try(Statement stmt = dataSource.getConnection().createStatement();
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
