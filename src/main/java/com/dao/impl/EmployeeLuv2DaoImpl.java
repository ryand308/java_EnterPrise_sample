package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.dao.EmployeeLuv2Dao;
import com.model.entity.EmployeeLuv2;

import jakarta.enterprise.context.Dependent;

@Dependent  // DAO implementation - 每次使用都創建新實例，可手動設定 DataSource (依賴)
public class EmployeeLuv2DaoImpl implements EmployeeLuv2Dao {
	
	// field
	private DataSource ds;	
	
	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	
	public EmployeeLuv2 getEmployeeLuv2() {
		return new EmployeeLuv2();
	}
	
	public void showEmployeeLuv2(EmployeeLuv2 e) {
		System.out.printf("%s %8s %25s %15s %10d %n", e.getLastName(), e.getFirstName(),
				e.getEmail(), e.getDepartments(), e.getSalary());
	}
	
	// implements Dao
	@Override
	public void add(EmployeeLuv2 e) {
		String sql = "INSERT INTO employeesofluv2 (last_name, first_name, email, departments, salary) VALUES ( ?, ?, ?, ?, ?)";
		
		try(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setString(1, e.getLastName());
			pstmt.setString(2, e.getFirstName());
			pstmt.setString(3, e.getEmail());
			pstmt.setString(4, e.getDepartments());
			pstmt.setInt(5, e.getSalary());
			
			//沒寫導致 DB 出現stateless ,stateful nullPointerException 
			pstmt.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void update(EmployeeLuv2 e) {
		String sql = "update test.employeesofluv2 set "
				+ "`last_name` = ?, `first_name`= ?, `email` = ?, `departments` = ?, `salary` = ? where `id` = ?";
		
		try(Connection conn = ds.getConnection();
		    PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setString(1, e.getLastName());
			pstmt.setString(2, e.getFirstName());
			pstmt.setString(3, e.getEmail());
			pstmt.setString(4, e.getDepartments());
			pstmt.setInt(5, e.getSalary());
			pstmt.setInt(6, e.getId());
			
			int rowsAffected = pstmt.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String sql = "delete from test.employeesofluv2 where `id` = ?";
		
		try(PreparedStatement pstmt = ds.getConnection().prepareStatement(sql);) {
			
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public EmployeeLuv2 findById(int id) {
		String sql = "SELECT * FROM test.employeesofluv2 where `id` = ?";		
		EmployeeLuv2 emp = this.getEmployeeLuv2();
		
		try(PreparedStatement pstmt = ds.getConnection().prepareStatement(sql)) {
			
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				emp.setLastName(rs.getString("last_name"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setEmail(rs.getString("email"));
				emp.setDepartments(rs.getString("departments"));
				emp.setSalary(rs.getInt("salary"));
				
				emp.setId(rs.getInt("id")); // 雖然找尋用不到，但在修改會需要；將物件內容完整
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return emp;
	}
	
	@Override
	public List<EmployeeLuv2> getAllEmployeeLuv2() {
		String sql = "select * from test.employeesofluv2";
		var list = new ArrayList<EmployeeLuv2>();
		
		try(Statement stmt = ds.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			){
			while(rs.next()) {
				EmployeeLuv2 emp = new EmployeeLuv2();
				emp.setId(rs.getInt(1));
				emp.setLastName(rs.getString(2));
				emp.setFirstName(rs.getString(3));
				emp.setEmail(rs.getString(4));
				emp.setDepartments(rs.getString(5));
				emp.setSalary(rs.getInt(6));
				
				list.add(emp);
			}
			
		}
		catch(SQLException exception) {
			exception.printStackTrace();
		}
		return list;
	}

}
