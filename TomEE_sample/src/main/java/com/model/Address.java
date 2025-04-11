package com.model;

public class Address {
	private String location;
	
	

	public Address() {
		super();
	}

	public Address(String location) {
		super();
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return " (location=" + location + ")";
	}
	
	
}
