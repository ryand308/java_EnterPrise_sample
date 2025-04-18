package filter;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class DbDeregisterListener implements ServletContextListener {


    public void contextDestroyed(ServletContextEvent sce)  { 
        // 有在 Servers 寫 JNDI 都要配置driver.deregister
    	Enumeration<Driver> drivers = DriverManager.getDrivers();
    	Driver driver = null;
    	
    	while(drivers.hasMoreElements()) {
    		try {
    			driver = drivers.nextElement();
    			DriverManager.deregisterDriver(driver);
    		} catch(SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	//Tomcat 不會自動關閉這個執行緒，所以需要手動關閉它，避免記憶體洩漏。
    	AbandonedConnectionCleanupThread.checkedShutdown();
    	System.out.println("mysql success final.");
    }    
	
}
