package controller;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.json.Json;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import model.jaxb.Student;

/**
 * Servlet implementation class StudentXmlServlet
 */
@WebServlet("/StudentXmlServlet")
public class StudentXmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// encode content type
		// request encoding
    	req.setCharacterEncoding("utf-8");
    	
    	// response ContentType
    	resp.setCharacterEncoding("utf-8");
    	resp.setContentType("text/html; charset=utf-8");
    	
    	// out put
    
    	try {
    		Student student =  this.convertObject();
			
			// 轉 jackSon json
			ObjectMapper objectMapper  = new ObjectMapper();
			String json = objectMapper.writeValueAsString(student);
			resp.getWriter().print(json);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// encode content type
		// request encoding
    	request.setCharacterEncoding("utf-8");
    	
    	// response ContentType
    	response.setCharacterEncoding("utf-8");
    	response.setContentType("text/html; charset=utf-8");
    	
    	// get parameter {id, name, phone}
		String id = request.getParameter("id");
		String studentId = request.getParameter("studentId");
		String score = request.getParameter("score");
		String name = request.getParameter("name");
		String group = request.getParameter("group");
		String club = request.getParameter("club");
		// convert to xml
		try {
			this.convertXml(id, studentId, score, name, group, club);
		} catch (JAXBException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// out put 
		response.getWriter().append("create success");
	}

	//Java Object To XML Using JAXB
	private void convertXml(String id,String studentId,String score, String name, String group, String club) throws JAXBException, IOException {
		// 如果空值；結束
		if(Stream.of(id, studentId, score, name, group, club).anyMatch(item -> item == null || item.matches("")))
			return;
		int sI = Integer.parseInt(id); 
		int sId = Integer.parseInt(studentId);
		int sScore =  Integer.parseInt(score);
		int sClub = Integer.parseInt(club);
		Student student = new Student(sI, sId, sScore, name, group, sClub);
		
		// 序列化
		JAXBContext context = JAXBContext.newInstance(Student.class);
		File file = new File("D:\\java_eclipse\\eclipse-enterprise\\DemoWebService\\src\\main\\webapp\\student.xml");
		
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(student, file);
			
	}
	//XML to Java Object  Using JAXB
	private Student convertObject() throws JAXBException {
		
		// 反序列化
		JAXBContext context = JAXBContext.newInstance(Student.class);
		File file = new File("D:\\java_eclipse\\eclipse-enterprise\\DemoWebService\\src\\main\\webapp\\student.xml");
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Student student = (Student) unmarshaller.unmarshal(file);
		
		return student;
	}
}
