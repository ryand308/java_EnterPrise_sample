package model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
@NamedQuery( name = "customer.findAll", query = "SELECT c FROM Customer c")
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column( name = "last_name", length = 50)
	private String lastName;
	@Column( name = "first_name", length = 50)
	private String firstName;
	@Column (name = "country", length = 100)
	private String country;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", country=" + country
				+ "]";
	}
	
	
}
