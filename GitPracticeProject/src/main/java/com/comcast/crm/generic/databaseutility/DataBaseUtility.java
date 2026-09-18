package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

	Connection con;

	public void getDbconnection(String url, String username, String password) throws SQLException {

		try {
			// step1: Register database
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// step2: get connection for database
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {

		}
	}

	public void getDbconnection() throws SQLException {

		try {
			// step1: Register database
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// step2: get connection for database
			con = DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm", "root@%", "root");
		} catch (Exception e) {

		}
	}

	public ResultSet executeSelectQuery(String query) {
		ResultSet result = null;
		try {
			Statement stat = con.createStatement();
			result = stat.executeQuery(query);
		} catch (Exception e) {

		}
		return result;
	}

	public int executeNonSelectQuery(String query) {
		int result = 0;
		try {
			Statement stat = con.createStatement();
			result = stat.executeUpdate(query);
		} catch (Exception e) {

		}
		return result;
	}

	public void executeAndgetData(String query, int colIndex, String expData) throws SQLException {
		// step3: create statement
		Statement state = con.createStatement();
		// step4: Execute query/ update query
		ResultSet result = state.executeQuery(query);
		boolean flag = false;
		while (result.next()) {
			String actual = result.getString(colIndex);
			if (actual.contains(expData)) {
				flag = true;
				break;
			}
		}
		if (flag == true) {
			System.out.println("-- data is verified --");
		} else {
			System.out.println("-- data is not present --");
		}
	}

	public void closeDBconnection() throws SQLException {
		// step5: close DB connection
		con.close();
	}

}
