package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="customers")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="country", length = 100)
	private String country;

	@Column(name="first_name", length = 50)
	private String firstName;

	@Column(name="last_name", length = 50)
	private String lastName;

	public Customer() {
	}
	
	
	public Customer(long id, String country, String firstName, String lastName) {
		super();
		this.id = id;
		this.country = country;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", country=" + country + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}

	
}