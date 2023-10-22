package com.eb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CP {
	static Connection conn;
	public static Connection createconnection() throws ClassNotFoundException, SQLException {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		String user="root";
		String password="root";
		String url="jdbc:mysql://localhost:3306/employeedata";
		conn=DriverManager.getConnection(url, user, password);
		}catch (Exception e) {
			System.out.println(e);
		}
		return conn;
		
	}

}
