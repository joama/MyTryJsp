package chapter2.diary.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import chapter2.diary.bean.Diary;

public class DiaryManager implements IDiaryManager {
	
	@Override
	public boolean addDiary(Diary diary) {
		// TODO Auto-generated method stub
	
		Connection connection = DBUtil.getConn();
		try {
				Statement statment = connection.createStatement();
				String insertSQL = "insert into diary(title,content,authorname,time) values(?,?,?,now())";
				ResultSet resultSet = statment.executeQuery(insertSQL);

				while (resultSet.next()) {
					// 得到日記的id
					int id = resultSet.getInt("id");
					// 得到日記的作者姓名
					String authorName = resultSet.getString("authorName");
					// 得到日記的標題
					String title = resultSet.getString("title");
					// 得到日記的內容
					String content = resultSet.getString("content");
					// 得到創建日記的時間
					Date time = resultSet.getTime("time");

				}
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		return false;
	}

	@Override
	public boolean deleteDiary(int id) {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getConn();
		String deleteSQL = "DELETE from diary WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
		preparedStatement.setInt(1, id);
		// execute delete SQL statement
		preparedStatement.executeUpdate();

	@Override
	public ArrayList<Diary> getAllDiaries() {
		ArrayList<Diary> diaries = new ArrayList<Diary>();
		Connection connection = DBUtil.getConn();
		try {
			Statement statment = connection.createStatement();
			String selectSQL = "SELECT * FROM diary";
			ResultSet resultSet = statment.executeQuery(selectSQL);

			while (resultSet.next()) {
				// 得到日記的id
				int id = resultSet.getInt("id");
				// 得到日記的作者姓名
				String authorName = resultSet.getString("authorName");
				// 得到日記的標題
				String title = resultSet.getString("title");
				// 得到日記的內容
				String content = resultSet.getString("content");
				// 得到創建日記的時間
				Date time = resultSet.getTime("time");
				// 將Date類型轉化為GregorianCalendar類型
				GregorianCalendar gc = new GregorianCalendar();
				diaries.add(new Diary(id, title, content, gc, authorName));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return diaries;
	}

	@Override
	public boolean updateDiary(Diary diary) {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getConn();
		try {
			Statement statment = connection.createStatement();
			String selectSQL = "SELECT * FROM diary";
			ResultSet resultSet = statment.executeQuery(selectSQL);

			while (resultSet.next()) {
				// 得到日記的id
				int id = resultSet.getInt("id");
				// 得到日記的作者姓名
				String authorName = resultSet.getString("authorName");
				// 得到日記的標題
				String title = resultSet.getString("title");
				// 得到日記的內容
				String content = resultSet.getString("content");
				// 得到創建日記的時間
				Date time = resultSet.getTime("time");
				// 將Date類型轉化為GregorianCalendar類型
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
