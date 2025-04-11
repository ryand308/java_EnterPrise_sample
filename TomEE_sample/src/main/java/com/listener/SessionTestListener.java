package com.listener;

import java.util.Enumeration;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionRemove
 *
 */
@WebListener
public class SessionTestListener implements HttpSessionListener {


    public SessionTestListener() {
        // TODO Auto-generated constructor stub
    }


    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }


    public void sessionDestroyed(HttpSessionEvent se)  { 
       
		Enumeration<String> total = se.getSession().getAttributeNames();
    	
    	while(total.hasMoreElements())
    		System.out.println("屬性：" + total.nextElement());
    }
	
}
