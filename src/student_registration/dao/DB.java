package student_registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/student_registration";
	private static final String DB_USR = "lionel";
	private static final String DB_PASS = "Mmh28803#";
	
	Connection con = null;
	
	public DB() {
		try {
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL,DB_USR,DB_PASS);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
