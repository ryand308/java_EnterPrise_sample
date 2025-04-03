package com.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Students implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	
	@Column(name = "學號")	
	private int studentId;
	@Column(name = "姓名")	
	private String name;
	@Column(name = "班級")	
	private String group;
	@Column(name = "成績")
	private int score;
	@Column(name = "社團")	
	private int club;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getClub() {
		return club;
	}
	public void setClub(int club) {
		this.club = club;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", studentId=" + studentId + ", name=" + name + ", group=" + group + ", score="
				+ score + ", club=" + club + "]";
	}
	
	
	
}
