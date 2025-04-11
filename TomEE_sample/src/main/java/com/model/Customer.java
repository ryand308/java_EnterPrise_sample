package com.model;

public class Customer {
	//default value
	private String name = "jack";
	private String email = "jack@mail";
	private String phone = "0000";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
}
