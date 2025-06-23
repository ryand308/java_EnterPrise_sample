package controller;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.pojo.Student;

@WebServlet("/StudentGsonServlet2")
public class StudentGsonServlet2 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String urlString = "http://localhost:8080/DemoWebService/StudentXmlServlet";
		InputStream inputStream = new URL(urlString).openStream();
		String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
		
		System.out.println(content);
		
		
		Gson gson = new Gson();      
      
        Student student = gson.fromJson(content, Student.class);

		System.out.println(student);
	}

	
}
