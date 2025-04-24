package model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="customers")
@NamedQuery(name="Customer.findAll", query="SELECT c.id, c.country, c.firstName, c.lastName FROM Customer c")
@NamedQuery(name="CustomerDto.findAll", query="SELECT new dto.CustomerDto(c.id, c.country, c.firstName, c.lastName) FROM Customer c")
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

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "order_id", referencedColumnName = "order_id")
	private Order order; // 變數名稱 決定：mappedBy = "order"
	
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}


	@Override
	public String toString() {
		return "[id=" + id + ", country=" + country + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", order=" + order + "]";
	}


	


}