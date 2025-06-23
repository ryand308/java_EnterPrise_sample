package controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.pojo.Student;

@WebServlet("/StudentJacksonServlet2")
public class StudentJacksonServlet2 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String urlString = "http://localhost:8080/DemoWebService/StudentXmlServlet";
		InputStream inputStream = new URL(urlString).openStream();
		String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
		
		System.out.println(content);
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		Student student = objectMapper.readValue(content, Student.class); //如果 只是單一物件;
		
		System.out.println(student);
		
		
	}

	
}
