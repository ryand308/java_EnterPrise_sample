package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.entity.EmployeeLuv2;


public class DatabaseMain3 {
	static DbConnection db = new DbConnection();
  
	
	public static void main(String[] args) throws SQLException {
		
		EmployeeLuv2 emp = new EmployeeLuv2("Black", "Snow", "mapa@gmail.com", "HR", 98000);
		emp.setId(24);
		update(emp);
		System.out.println("add successful");
	}

	
	public static void update(EmployeeLuv2 e) {
		String sql = "update test.employeesofluv2 set "
				+ "`last_name` = ?, `first_name`= ?, `email` = ?, `departments` = ?, `salary` = ? where `id` = ?";
		
		try(Connection conn = db.getConnection();
		    PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setString(1, e.getLastName());
			pstmt.setString(2, e.getFirstName());
			pstmt.setString(3, e.getEmail());
			pstmt.setString(4, e.getDepartments());
			pstmt.setInt(5, e.getSalary());
			pstmt.setInt(6, e.getId());
			
			pstmt.execute();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}

	}
}
