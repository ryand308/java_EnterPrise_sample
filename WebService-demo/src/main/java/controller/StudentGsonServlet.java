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

@WebServlet("/StudentGsonServlet")
public class StudentGsonServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String urlString = "http://localhost:8080/ServletBasic3/api/student/find";
		InputStream inputStream = new URL(urlString).openStream();
		String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
		
		System.out.println(content);
		
		
		Gson gson = new Gson();
        Type studentListType = new TypeToken<List<Student>>() {}.getType();
        // toJson 方法是把 有資料的物件轉換成 json's data is Type of String.
        List<Student> students = gson.fromJson(content, studentListType);

		students.forEach(System.out::println);
		// 以session Attribute "students" 傳導到jsp ，分層顯示給客戶端瀏覽；(url寫在後端，可隱藏客戶端server在連接的端口)
		// 客戶端所接收的是 Servlet nio 出來的data，而不是直接透過 串接database 的server ，顯示資料
		
		req.setAttribute("students", students);
		/* out put */
		req.getRequestDispatcher("studentSql.jsp").forward(req, resp);
	}

	
}
