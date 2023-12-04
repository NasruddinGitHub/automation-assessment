package com.automation.assessment.testclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.automation.assessment.exception.AssessmentException;

public class DatabaseTest {

	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String HOST_NAME = "jdbc:mysql://localhost:3306/mydb";
	private static final String USERNAME = "mydbuser";
	private static final String PASSWORD = "mydbpwd";

	@Test
	public void fetchDataFromDb() throws SQLException {
		Connection con = null;
		try {
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(HOST_NAME, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from emp");
			while (rs.next())
				System.out.println(rs.getString(0));

		} catch (Exception e) {
			e.printStackTrace();
			throw new AssessmentException("Exception while fetaching the data from database");
		} finally {
			con.close();
		}

	}

}
