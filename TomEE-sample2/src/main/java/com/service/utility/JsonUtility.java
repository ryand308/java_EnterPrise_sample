package com.service.utility;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JsonUtility {

	public JsonObject data(String name) {
		
		JsonObject json = new JsonObject();
		json.addProperty("name", name);
		json.addProperty("price", 2000);
		
		JsonArray courses = new JsonArray();
		courses.add("OCAJP");
		courses.add("OCPJP");
		json.add("courses", courses);
		
		return json;
	}
}
