package chapter2.jdbc.test;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	public static void main(String[] args) {
		String driverName = "com.mysql.jdbc.Driver";
		String connectionString = "jdbc:mysql://localhost:3306/diary?"
				 + "user=root&password=123456&useUnicode=true&characterEncoding=utf-8";
		
		try {
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection(connectionString);
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}
