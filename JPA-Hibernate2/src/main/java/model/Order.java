package model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Entity implementation class for Entity: Order
 *
 */
@Entity
@Table(name = "orders")
@NamedQuery( name = "Order.findAll", query = "SELECT o.id, o.pay, o.addition FROM Order o")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy =  GenerationType.IDENTITY)
	@Column(name = "order_id")
	private long id;
	@Column(name = "pay")
	private int pay;
	@Column(name = "addition", length = 100)
	private String addition;
	// 雙向連動
	@OneToOne(mappedBy = "order")
	private Customer customer;
	
	public Order() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public String getAddition() {
		return addition;
	}

	public void setAddition(String addition) {
		this.addition = addition;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", pay=" + pay + ", addition=" + addition + "]";
	}
   
	
}
