package com.test.jdbcMysql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateMain {

	public static void main(String[] args) {
		
		LocalDateTime dateTime = LocalDateTime.now();
		Timestamp time = Timestamp.valueOf(dateTime);
		System.out.println(time.toString());
		
		String sql = "insert into test.testtimestamp (`date`) values (?)";
		
		DbConnection db = new DbConnection();
		
		try(PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
			pstmt.setTimestamp(1, time);
			
			pstmt.executeUpdate();
		}catch( SQLException e) {
			e.printStackTrace();
		}
	}
}
