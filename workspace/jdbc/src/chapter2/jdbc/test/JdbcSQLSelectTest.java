package chapter2.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.GregorianCalendar;

public class JdbcSQLSelectTest {
		public static void testInsert() {}
		
		public static void testSelect(){
			String driverName = "com.mysql.jdbc.Driver";
			String connectionString = "jdbc:mysql://localhost:3306/diary?"
					+ "user=root&password=123456&useUnicode=true&characterEncoding=utf-8";
			
			try {
				Class.forName(driverName);
				
				Connection connection = DriverManager.getConnection(connectionString);
				
				Statement statement = connection.createStatement();
				
				String selectSQL = "SELECT * FROM diary";
				ResultSet resultSet = statement.executeQuery(selectSQL);
				
				while(resultSet.next()){
					int id = resultSet.getInt("id");
					
					String authorName = resultSet.getString("authorName");
					
					String title = resultSet.getString("title");
					
					String content = resultSet.getString("content");
					
					Date time = resultSet.getTime("time");
					
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(time);
					
					int year = gc.get(GregorianCalendar.YEAR);
					int month = gc.get(GregorianCalendar.MONTH);
					int day = gc.get(GregorianCalendar.DATE);
					int hour = gc.get(GregorianCalendar.HOUR_OF_DAY);
					int minute = gc.get(GregorianCalendar.MINUTE);
					
					System.out.println("第" + id + "篇日記的作者:" + authorName);
					System.out.println("第" + id + "篇日記的標題:" + title);
					System.out.println("第" + id + "篇日記的內容:" + content);
					System.out.println("第" + id + "篇日記的時間:" + year + "-" + month
							+ "-" + day + " " + hour + ":" + minute);
				}
				
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
			testSelect();
		}
}
