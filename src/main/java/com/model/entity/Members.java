package com.model.entity;

import java.io.Serializable;

import com.model.converter.GenderAttributeConverter;

import jakarta.persistence.Convert;
//測試佈署 mapping.xml
public class Members implements Serializable{

	private static final long serialVersionUID = 1L;


	private int id;
	
	private String name;

	@Convert(converter = GenderAttributeConverter.class)
	private Character gender;

	private String address;

	private String phone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
