package com.springboot.workers.jdbcexample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
private static final String url = "jdbc:mysql://localhost:3307/my_org";
private static final String username = "root";
private static final String password = "password";
private static Connection conn = null;

private DatabaseConnection() {

}

public static Connection getConnection() {
    if (conn == null) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database server "
                    + conn.getMetaData().getDatabaseProductName()
                    + " version: "
                    + conn.getMetaData().getDatabaseProductVersion());
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    return conn;
}

public static void closeConnection() {
    	if (conn != null) {
        	try {
        		conn.close();
        	} catch (SQLException e) {
            	System.out.println(e);
        	}
    	}
	}
}