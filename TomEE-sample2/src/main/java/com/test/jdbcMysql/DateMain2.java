package com.test.jdbcMysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;



public class DateMain2 {

	public static void main(String[] args) {
		
		LocalDateTime dateTime = LocalDateTime.now();
		Timestamp time = Timestamp.valueOf(dateTime);
		System.out.println(time.toString());
		
		String sql = "SELECT * FROM test.testtimestamp where `id` = 1";
		
		DbConnection db = new DbConnection();
		Timestamp time2 = null;
		
		try(Statement stmt = db.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);)
		{
			while(rs.next()) {
				time2 = rs.getTimestamp(2);				
			}		
		
		}catch( SQLException e) {
			e.printStackTrace();
		}
		
		LocalDateTime dateTime2 = time2.toLocalDateTime();
		System.out.println(dateTime2);
		
		System.out.println(dateTime.isBefore(dateTime2));
		
	}
}
