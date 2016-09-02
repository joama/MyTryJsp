package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domain.User;
import dao.IUserDAO;

public class UserDAO implements IUserDAO {

	/**
	 * 往數據中添加數據
	 */
	public void addUser(User user) {

		Connection conn = new DatabaseDAO().getConnection();
		PreparedStatement pstmt = null;

		try {
			String sql = "insert into User(Username,Password,Realname,Gender,Age,PersonalSignature) "
					+ "values('"
					+ user.getUserName()
					+ "','"
					+ user.getPassWord()
					+ "','"
					+ user.getRealName()
					+ "','"
					+ user.getGender()
					+ "',"
					+ user.getAge()
					+ ",'"
					+ user.getPersonlSignature() + "')";

			System.out.println("sql語句  " + sql);
			pstmt = conn.prepareStatement(sql);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 從數據庫中查詢id為參數值id的用戶
	 */
	public User getUserById(String id) {

		DatabaseDAO myDB = new DatabaseDAO();
		User us = new User();
		try {
			String sql = "select * from user where id='" + id + "'";
			ResultSet rs = myDB.getResultSet(sql);
			if (rs.next()) {

				us.setId(rs.getString("id"));
				us.setGender(rs.getString("Gender"));
				us.setAge(rs.getInt("Age"));
				us.setPassWord(rs.getString("PassWord"));
				us.setPersonlSignature(rs.getString("PersonalSignature"));
				us.setRealName(rs.getString("Realname"));
				us.setUserName(rs.getString("Username"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				myDB.releaseConnection();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		return us;

	}

	public List<User> getUserByUserName(String userName) {
		System.out.println("得到姓名  " + userName);
		DatabaseDAO myDB = new DatabaseDAO();
		User user = new User();
		List<User> list = new ArrayList<User>();
		String sql = "select * from user where username ='" + userName + "'";
		try {
			ResultSet mySet = myDB.getResultSet(sql);
			while (mySet.next()) {
				user.setId(mySet.getString("Id"));
				user.setUserName(mySet.getString("UserName"));
				user.setPassWord(mySet.getString("Password"));
				user.setRealName(mySet.getString("RealName"));
				user.setGender(mySet.getString("Gender"));
				user.setAge(mySet.getInt("Age"));
				user.setPersonlSignature(mySet.getString("PersonalSignature"));
				list.add(user);
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} finally {
			try {
				myDB.releaseConnection();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		System.out.println(list.size());
		return list;
	}

}
