package dto;

public class OrderDto {

	private long id;
	
	private int pay;
	
	private String addition;

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
		return "OrderDto [id=" + id + ", pay=" + pay + ", " + (addition != null ? "addition=" + addition : "") + "]";
	}
	
	
}
