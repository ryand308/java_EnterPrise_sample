package com.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // 實體的物件
@Table(name = "employeesofluv2") // 資料庫的 table.name
public class EmployeeLuv2 implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id // primary key	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "last_name", length = 50)
	private String lastName;
	@Column(name = "first_name", length = 50)
	private String firstName;
	@Column(name = "email", length = 50)
	private String email;
	@Column(name = "departments", length = 50)
	private String departments;
	@Column(name = "salary")
	private int salary;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartments() {
		return departments;
	}

	public void setDepartments(String departments) {
		this.departments = departments;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public EmployeeLuv2() {

	}

	public EmployeeLuv2( String lastName, String firstName, String email, String departments, int salary) {
		super();		
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.departments = departments;
		this.salary = salary;
	}

}
