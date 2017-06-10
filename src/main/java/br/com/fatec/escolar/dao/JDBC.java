package br.com.fatec.escolar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class JDBC {
	private final static String JDBC_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final static String JDBC_URL = "jdbc:sqlserver://localhost:1433/Escola";
	
	private final static String JDBC_USERID = "host";
	private final static String JDBC_PASSWORD = "host";
	private Connection con;
	private static JDBC jdbc;
	private JDBC() { 		
	}
	public Connection getConnection() throws SQLException {
		if (con == null) {
			try {
				Class.forName( JDBC_CLASS );
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (con == null || (con != null && !con.isValid(3))) { 
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=alexandre;password=123456;databaseName=Escola");
		}
		return con;
	}
	public static JDBC getInstance() { 
		if (jdbc == null) { 
			jdbc = new JDBC();
		}
		return jdbc;
	}

}
