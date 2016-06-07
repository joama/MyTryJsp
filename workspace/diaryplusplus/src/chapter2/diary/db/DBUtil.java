package chapter2.diary.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * 數據庫連接訪問類
 * 
 * @author wei.xiang
 *
 */
public class DBUtil {

	private final static String dirver_name = "com.mysql.jdbc.Driver";
	private final static String conn_url = "jdbc:mysql://localhost:3306/diary";
	private final static String user = "root";
	private final static String pwd = "123456";
		
	/**
	 * 創建數據庫連接
	 * 
	 * @return Connection 返回數據庫連接
	 * 
	 */
	public static Connection getConn(){
		
		Connection conn = null;
		try {			
			Class.forName(dirver_name);			
			conn = DriverManager.getConnection(conn_url,user,pwd);			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	
	
	/**
	 * 
	 * 關閉數據裡連接
	 * 
	 * @param conn
	 */
	public static void closeConn(ResultSet rs,PreparedStatement pstmt, Connection conn){
		try {
			
			if(rs!=null) rs.close();
			
			if(pstmt!=null) pstmt.close();
			
			if(conn!=null && conn.isClosed()==false) conn.close();
			
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args) {
		
		DBUtil.getConn();
	}
}