package chapter2.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import chapter1.diary.bean.Diary;

public class JdbcSQLPrepared {
	public static boolean addDiary(Diary newDiary){
		String driverName = "com.mysql.jdbc.Driver";
		
		String connectionString = "jdbc:mysql://localhost:3306/diary?"
				+ "user=root&password=123456&useUnicode=true&characterEncoding=utf-8";
		
		int count = 0;
		
		try{
			Class.forName(driverName);
		
			Connection connection = DriverManager.getConnection(connectionString);
		
			PreparedStatement preparedStatement = connection.prepareStatement("Insert into diary(title, content, authorName, time) values(?, ?, ?, now())");
		
			String title = newDiary.getTitle();
			String content = newDiary.getContent();
			String authorName = newDiary.getAuthorName();
		
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, content);
			preparedStatement.setString(3, authorName);
		
			count = preparedStatement.executeUpdate();
		
			preparedStatement.close();
		
			connection.close();
		
		
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
			return true;
		}
		
		if (count == 1){
			System.out.println("增加日誌成功!");
		}
		return count == 1;
	}
	
	public static void main(String[] args) {
		Diary diary = new Diary();
		diary.setTitle("第三篇日記");
		diary.setContent("第三篇日記的內容");
		diary.setAuthorName("JavaWeb愛好者");
		
		addDiary(diary);
	}
}
