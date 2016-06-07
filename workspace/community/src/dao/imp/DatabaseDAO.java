package dao.imp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDAO {
	private Connection conn = null;
	/*
	@return
	@throws ClassNotFoundException
	@throws SQLException
	*/
	public Connection getConnection() throws ClassNotFoundException,SQLException{
		Connection conn = null;
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		
		String connstr = "jdbc:mysql://localhost:3306/community?useUnicode=true&characterEncoding=utf-8";
		
		String user = "root";
		String password = "123456";
		
		conn = DriverManager.getConnection(connstr, user, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("數據庫連接成功！");
		return conn;
	}
	
	public void releaseConnection() throws SQLException{
		this.conn.close();
		this.conn = null;
	}
	
	public ResultSet getResultSet(String querySQL) throws SQLException,ClassNotFoundException{
		System.out.println("sql語句" + querySQL);
		if(conn == null){
			this.conn = getConnection();
		}
		Statement stm = conn.createStatement();
		
		ResultSet thisRST = stm.executeQuery(querySQL);
		return thisRST;
	}
	
	public void executeSQL(String SQL) throws SQLException, ClassNotFoundException{
		if(conn == null){
			this.conn = getConnection();
		}
		Statement stm = conn.createStatement();
		
		stm.executeUpdate(SQL);
		
		this.conn.close();
		this.conn = null;
	}
	
	public static void main(String[] args) {
		
		DatabaseDAO myDb = new DatabaseDAO();
		
		try
		{
		myDb.conn = myDb.getConnection();
		
		myDb.releaseConnection();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
}
