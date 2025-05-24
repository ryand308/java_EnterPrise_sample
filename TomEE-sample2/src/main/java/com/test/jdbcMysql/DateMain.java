package com.test.jdbcMysql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class DateMain {

	public static void main(String[] args) {
		
		LocalDateTime dateTime = LocalDateTime.now();
		Timestamp time = Timestamp.valueOf(dateTime);
		System.out.println(time.toString());
		
		
		
		String sql = "insert into test.testtimestamp (`name`) values (?)";
		
		DbConnection db = new DbConnection();
		
		try(PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
			pstmt.setString(1, "John");			
			
			pstmt.executeUpdate();
		}catch( SQLException e) {
			e.printStackTrace();
		}
	}
}
