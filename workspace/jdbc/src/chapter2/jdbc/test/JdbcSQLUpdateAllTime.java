package chapter2.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSQLUpdateAllTime {
	public static void testUpdate(){
		String driverName = "com.mysql.jdbc.Driver";
		String connectionString = "jdbc:mysql://localhost:3306/diary?"
				+ "user=root&password=123456&useUnicode=true&characterEncoding=utf-8";
	
		try {
			Class.forName(driverName);
		
			Connection connection = DriverManager.getConnection(connectionString);
		
			Statement statement = connection.createStatement();
		
			String insertSQL = " UPDATE diary SET time = NOW()" ;
		
			int count = statement.executeUpdate(insertSQL);
		
			System.out.println("成功修改了" + count + "筆記錄");
		
			statement.close();
		
			connection.close();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		testUpdate();
	}
	
}
