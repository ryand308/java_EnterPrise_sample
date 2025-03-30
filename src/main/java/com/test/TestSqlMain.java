package com.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.entity.Students;

public class TestSqlMain {

	public static void main(String[] args) {

		
		var list = getAllStudents();
		System.out.println("db success");
		for(Students s: list) {
			System.out.println(s.getName());
		}
		
	}

	public static List<Students> getAllStudents() {

		DbConnection db = new DbConnection();
		String sql = "select * from test.students";

		var list = new ArrayList<Students>();

		try (Statement stmt = db.getConnection().createStatement();) {

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Students student = new Students();
				student.setId(rs.getInt("ID"));
				student.setStudentId(rs.getInt("學號"));
				student.setName(rs.getString("姓名"));
				student.setGroup(rs.getString("班級"));
				student.setScore(rs.getInt("成績"));
				student.setClub(rs.getInt("社團"));

				list.add(student);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return list;
	}
}