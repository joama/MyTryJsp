package chapter2.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSQLTest {
	public static void testInsert(){
		String driverName = "com.mysql.jdbc.Driver";
		String connectionString = "jdbc:mysql://localhost:3306/diary?"
				+ "user=root&password=123456&useUnicode=true&characterEncoding=utf-8";
		
		try{
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection(connectionString);
			
			Statement statement = connection.createStatement();
			String insertSQL = "INSERT INTO diary(title, content, authorName, time) VALUES('一篇日記', '寥寥數字', '匿名', NOW())";
			int count = statement.executeUpdate(insertSQL);		
			System.out.println("成功插入了" + count + "筆記錄");
			statement.close();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		testInsert();
	}
}
