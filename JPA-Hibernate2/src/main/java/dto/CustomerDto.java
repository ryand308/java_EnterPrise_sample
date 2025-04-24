package dto;

import jakarta.enterprise.context.Dependent;

@Dependent
public class CustomerDto {

	private long id;
	
	private String country;
	
	private String firstName;
	
	private String lastName;
	
	

	public CustomerDto() {
		super();
	}

	public CustomerDto(long id, String country, String firstName, String lastName) {
		super();
		this.id = id;
		this.country = country;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", " + (country != null ? "country=" + country + ", " : "")
				+ (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (lastName != null ? "lastName=" + lastName : "") + "]";
	}
	
	
}
