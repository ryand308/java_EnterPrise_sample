package com.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.entity.EmployeeLuv2;


public class DatabaseMain {
	static DbConnection db = new DbConnection();
  
	
	public static void main(String[] args) throws SQLException {
		
		
		Statement stmt = db.getConnection().createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from test.employeesofluv2");

		while(rs.next()) {
			System.out.println(rs.getInt("salary"));
		}
			
		
		List<EmployeeLuv2> lists = getAllEmployeeLuv2();
		
		for(EmployeeLuv2 list: lists) {
		System.out.println(list.getFirstName());			
		}
		
		
		
	}
	
	public static List<EmployeeLuv2> getAllEmployeeLuv2() {
		String sql = "select * from test.employeesofluv2";
		var list = new ArrayList<EmployeeLuv2>();
		try(Statement stmt = db.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			){
			while(rs.next()) {
				EmployeeLuv2 emp  = new EmployeeLuv2();
				emp.setId(rs.getInt("id"));
				emp.setLastName(rs.getString("last_name"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setEmail(rs.getString("email"));
				emp.setDepartments(rs.getString("departments"));
				emp.setSalary(rs.getInt("salary"));
				
				list.add(emp);
			}
			
		}
		catch(SQLException exception) {
			exception.printStackTrace();
		}
		return list;
	}	

}
