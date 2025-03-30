package com.config;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped //由容器(containers)管理，範圍可控制
public class AppConfig {
	
	private String test = "測試";
	
	public String getTest() {
		return test;
	}
}
