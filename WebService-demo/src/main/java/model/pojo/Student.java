package model.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable{
	
	//{"club":101,"group":"1 年 2 班","id":1,"name":"王小明","score":92,"studentId":10001}; 資料來源mysql: test.students;
	private int id;
//	@JsonProperty( namespace = "student_id") 如果json 的key 對應
	private int studentId;
	private int score;
	private String name;
	private String group;
	private int club;
	
}
