package model.jaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@XmlType(propOrder = {"id", "studentId", "score", "name", "group", "club"}) // 順序
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
	
	
	private int id;
	private int studentId;
	private int score;
	private String name;
	private String group;
	private int club;
	
	@XmlElement(name = "idNumber") // 轉換成稱
	public int getStudentId() {
		return this.studentId;
	}
}
