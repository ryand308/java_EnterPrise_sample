package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.entity.EmployeeLuv2;


public class DatabaseMain2 {
	static DbConnection db = new DbConnection();
  
	
	public static void main(String[] args) throws SQLException {
		
		EmployeeLuv2 emp = new EmployeeLuv2("Deep", "Seek", "china@gmail.com", "Engineering", 35000);
		emp.setId(16);
		add(emp);
		System.out.println("add successful");
	}

	
	public static void add(EmployeeLuv2 e) {
		String sql = "INSERT INTO employeesofluv2 (`id`, `last_name`, `first_name`, `email`, `departments`, `salary`) VALUES (?, ?, ?, ?, ?, ?);";
		
		try(Connection conn = db.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, e.getId());
			pstmt.setString(2, e.getLastName());
			pstmt.setString(3, e.getFirstName());
			pstmt.setString(4, e.getEmail());
			pstmt.setString(5, e.getDepartments());
			pstmt.setInt(6, e.getSalary());
			
			pstmt.executeUpdate();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
