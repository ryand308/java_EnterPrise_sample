package jsf.model.bean;

import java.io.Serializable;
import java.util.Random;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;
import lombok.NoArgsConstructor;

/** @ViewScoped Managed Bean。
 * 它表示 Bean 的生命週期會持續到目前這個 JSF 頁面（View）結束為止；
 * 也就是部關閉伺服器的條件下，每次重新開啟網頁 init() 都會開啟。
 */

@Named("userNumber")
@ViewScoped 
@NoArgsConstructor
@Data
public class UserNumberBean implements Serializable {
	
    private static final long serialVersionUID = 1L;
    private Integer randomInt;
    private Integer user;

    private int maximum;
    private int minimum;
    
    // lifeCycle
    @PostConstruct
    public void initial() {
    	user = null;
    	maximum = 99;
    	minimum = 0;
    	Random randomGR = new Random();
    	randomInt = randomGR.nextInt(maximum + 1);
    	// Print number to server log
    	System.out.println("Duke's number: " + randomInt);    	
    }

    // method
    public String result() {
        if (user == null) 
            return "";   
        
    	maximum = (user > randomInt)? user: maximum;
    	minimum = (user < randomInt)? user: minimum;
    	
    	return "Sorry, " + user + " is incorrect.";
        
    }
    
    public String responseListener() {
    	if (user == null || (user.compareTo(randomInt) != 0))
            return "success";       
        else         	
        	return "guessResponse";       
        
    }
    public String response() {
    	return responseListener();
    }

    // no-arg constructor

    
    // getter & setter

  
	
}
