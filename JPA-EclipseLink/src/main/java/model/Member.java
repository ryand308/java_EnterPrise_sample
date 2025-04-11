package model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the members database table.
 * 
 */

@Entity
@Table(name="members")
@NamedQuery(name = "Member.findAll",  query = "SELECT m FROM Member m")
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy =  GenerationType.IDENTITY)
	private int id;
	@Column(name = "address", length = 100)
	private String address;
	@Column(name = "name", length = 50)
	private String name;
	@Column(name = "phone", length = 100)
	private String phone;
	@Column(name = "sex", length = 8)
	private char sex;

	public Member() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", address=" + address + ", name=" + name + ", phone=" + phone + ", sex=" + sex
				+ "]";
	}

	
}