package dao.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDAO {
	private Connection conn = null;

	/**
	 * 獲取數據庫連接對象
	 * 
	 * @return 數據庫連接對象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConnection() {
		Connection conn = null;
		// 加載數據庫驅動

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/community", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("數據庫連接成功！");
		return conn;
	}

	/**
	 * 關閉類中的連接對象
	 * 
	 * @throws SQLException
	 */
	public void releaseConnection() throws SQLException {
		this.conn.close();
		this.conn = null;
	}

	/**
	 * 執行一個SQL查詢語句，並返回查詢的結果集
	 * 
	 * @param SQL查詢語句
	 * @return 數據庫查詢結果集
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ResultSet getResultSet(String querySQL) throws SQLException,
			ClassNotFoundException {
		System.out.println("sql語句" + querySQL);
		if (conn == null) {
			this.conn = getConnection();
		}
		Statement stm = conn.createStatement();

		// 執行SQL查詢語句並返回查詢結果集
		ResultSet thisRST = stm.executeQuery(querySQL);
		return thisRST;
	}

	/**
	 * 直接執行一條對數據庫修改（包括增刪改）的SQL語句
	 * 
	 * @param SQL語句
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void executeSQL(String SQL) throws SQLException,
			ClassNotFoundException {
		if (conn == null) {
			this.conn = getConnection();
		}
		Statement stm = conn.createStatement();

		// 執行給定的SQL語句
		stm.executeUpdate(SQL);

		// 關閉連接對象
		this.conn.close();
		this.conn = null;
	}

}
