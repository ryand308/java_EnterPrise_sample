package jsf.model.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import lombok.Data;

//@ManagedBean(name ="studentBean" ) // 舊的宣告方式
@Named( value = "studentBean")
@RequestScoped
@Data
public class StudentBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String country;
	private String languages;
	private String[] interests;
	private List<String> countryOptions;
	
	@PostConstruct
	public void initPre() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "警告:請輸入您的名字", null);
		facesContext.addMessage(null, msg);
	}
	
	//create no-arg constructor
	public StudentBean() {
		super();
		this.countryOptions = new ArrayList<>();
		countryOptions.add("Taiwan");
		countryOptions.add("Brazil");
		countryOptions.add("China");
		countryOptions.add("India");
		countryOptions.add("Turkey");
		countryOptions.add("France");
		countryOptions.add("United Kingdom");
		countryOptions.add("United States");

	}
	

	// getter and setter
	 
}
