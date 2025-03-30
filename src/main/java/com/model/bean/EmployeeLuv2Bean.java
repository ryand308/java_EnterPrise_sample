package com.model.bean;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

/**
 * Session Bean implementation class EmployeeLuv2Bean
 */
@Stateless
@LocalBean
public class EmployeeLuv2Bean {

	//field	
	private int id;	
	private String lastName;	
	private String firstName;	
	private String email;	
	private String departments;	
	private int salary;
	
    public EmployeeLuv2Bean() {
        // TODO Auto-generated constructor stub
    }

	public EmployeeLuv2Bean(String lastName, String firstName, String email, String departments, int salary) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.departments = departments;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

    
}
