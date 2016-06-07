package dao.imp;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IUserDAO;
import domain.User;

public class UserDAO implements IUserDAO{

	public UserDAO(){
		
	}
	
	public void addUser (User user){
		
		//IDatabaseDAO myDB = new DatebaseDAO();
		/*
		Connection conn = null;
		try {
			conn = new DatabaseDAO().getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement pstmt = null;
		*/
		DatabaseDAO myDB = new DatabaseDAO();
		
		String sql = "insert into user(UserName,Password,RealName,Gender,Age,PersonalSignature) "
				+ "values('"
				+user.getUserName()
				+"','"
				+ user.getPassword()
				+ "','"
				+ user.getRealName()
				+ "','"
				+ user.getGender()
				+ "',"
				+ user.getAge()
				+ ",'"
				+ user.getPersonalSignature() + "')";
		
		/*
			System.out.println("sql語句" + sql);
			pstmt = conn.prepareStatement(sql);

			pstmt.executeUpdate();
		*/
		try
		{	
			myDB.executeSQL(sql);
		}
		catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}catch (ClassNotFoundException cnfEx){
			cnfEx.printStackTrace();
		}/*finally {
		}
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
	}
	
	public User getUserByID(String id){
		
		DatabaseDAO myDB = new DatabaseDAO();
		/*
		Connection conn = null;
		try {
			conn = new DatabaseDAO().getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User us = new User();
		*/
		User user = new User();
		
			String sql = "select * from user where Id ='"+id+"'";
		try{
			ResultSet mySet = myDB.getResultSet(sql);
			
			//pstmt = conn.prepareStatement(sql);
			//rs = pstmt.executeQuery();
			
			while (mySet.next()) {

				user.setId(mySet.getString("Id"));
				
				user.setUserName(mySet.getString("Username"));
				
				user.setPassword(mySet.getString("Password"));
				
				user.setRealName(mySet.getString("Realname"));
				
				user.setGender(mySet.getString("Gender"));
				
				user.setAge(mySet.getInt("Age"));
				
				user.setPersonalSignature(mySet.getString("PersonalSignature"));	
			}
		}catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch(ClassNotFoundException cnfEx){
			cnfEx.printStackTrace();
		}finally {
			try {
				//conn.close();
				//pstmt.close();
				//rs.close();
				
				myDB.releaseConnection();
				
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		return user;
	}
	
		
		
	public List<User> getUserByUserName(String userName){
		//IDatebaseDAO myDB = new DatebaseDAO();
		
		System.out.println("眔﹎  " + userName);
		DatabaseDAO myDB = new DatabaseDAO();
		User user = new User();
		List<User> list = new ArrayList<User>();
		String sql = "select * from user where UserName ='"+userName+"'";
		
		try{
			ResultSet mySet = myDB.getResultSet(sql);
			while(mySet.next()){
				user.setId(mySet.getString("Id"));
				
				user.setUserName(mySet.getString("UserName"));
				
				user.setPassword(mySet.getString("Password"));
				
				user.setRealName(mySet.getString("RealName"));
				
				user.setGender(mySet.getString("Gender"));
				
				user.setAge(mySet.getInt("Age"));
				
				user.setPersonalSignature(mySet.getString("PersonalSignature"));
				
				list.add(user);
			}
		}catch(SQLException sqlEx){
			sqlEx.printStackTrace();
		}catch(ClassNotFoundException cnfEx){
			cnfEx.printStackTrace();
		}finally{
			try{
				myDB.releaseConnection();
			}catch(SQLException sqlEx){
				sqlEx.printStackTrace();
			}
		}
		System.out.println(list.size());
		return list;
	}
}
