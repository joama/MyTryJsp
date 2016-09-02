package dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IInfoDAO;
import domain.*;

/**
 * Information類對應的DAO
 */
public class InfoDAO implements IInfoDAO {
	/**
	 * 默認構造函數
	 */
	public InfoDAO() {

	}

	/**
	 * 往數據庫中添加信息
	 */
	public void addInfo(Information information) {

		// 初始化數據庫訪問類
		DatabaseDAO myDB = new DatabaseDAO();
		// 構造SQL語句
		String sql = "insert into information"
				+ "(Title,Content,PublishingTime,PublishingUser,Type) values('"
				+ information.getTitle() + "','" + information.getContent()
				+ "','" + information.getPublishingtime() + "','"
				+ information.getPublishiuser() + "','" + information.getType()
				+ "')";

		System.out.println("sql語句  " + sql);
		try {
			// 執行SQL語句
			myDB.executeSQL(sql);
		}
		// 處理SQL語句執行過程中可能產生的異常
		catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		}
	}

	/**
	 * 從數據庫中獲得所有信息
	 */
	public List<Information> getAllInfo() {

		// 初始化sql查詢語句
		String sql = "select * from information";
		// 調用相關方法，並返回查詢結果
		return getInfoBySqlString(sql);
	}

	public List<Information> getInfoByType(String type) {
		// 初始化sql查詢語句
		String sql = "select * from information  where Type='" + type + "'";

		// 初始化數據庫訪問類
		DatabaseDAO myDB = new DatabaseDAO();
		// 定義信息列表，預備返回對象
		List<Information> list = new ArrayList<Information>();
		try {
			// 執行sql查詢語句，並獲取查詢結果集
			ResultSet mySet = myDB.getResultSet(sql);
			while (mySet.next()) {

				// 定義信息類對象，用來封裝查詢數據
				Information information = new Information();
				// 設置信息類對象的Id字段值
				information.setId(mySet.getString("id"));
				// 設置信息類對象的標題字段值
				information.setTitle(mySet.getString("title"));
				// 設置信息類對象的信息內容字段值
				information.setContent(mySet.getString("content"));
				// 設置信息類對象的發布時間字段值
				information
						.setPublishingtime(mySet.getString("publishingTime"));
				// 定義一個用戶類對象，該對象用來為信息類對象的用戶字段賦值

				// 設置信息類對象的用戶字段值
				information.setPublishiuser(mySet.getString("publishingUser"));
				// 設置信息類對象的日誌類型字段值
				information.setType(mySet.getString("type"));
				// 把信息類對象加入返回數據集中
				list.add(information);
			}
		}
		// 處理異常
		catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				// 釋放數據庫操作類的數據庫連接對象
				myDB.releaseConnection();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}

		// 返回結果
		return list;

	}

	public void deleteInfoById(String id) {

		// 初始化sql查詢語句
		String sql = "delete from information  where Id='" + id + "'";

		// 初始化數據庫訪問類
		DatabaseDAO myDB = new DatabaseDAO();
		try {
			// 執行sql查詢語句
			myDB.executeSQL(sql);

		}
		// 處理異常
		catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {

		}
	}

	public Information getInfoByID(String id) {

		// 初始化sql查詢語句
		String sql = "select * from information  where Id='" + id + "'";

		// 初始化數據庫訪問類
		DatabaseDAO myDB = new DatabaseDAO();
		// 定義信息類對象，用來封裝查詢數據
		Information information = new Information();
		try {
			// 執行sql查詢語句，並獲取查詢結果集
			ResultSet mySet = myDB.getResultSet(sql);
			if (mySet.next()) {
				// 設置信息類對象的Id字段值
				information.setId(mySet.getString("Id"));
				// 設置信息類對象的標題字段值
				information.setTitle(mySet.getString("Title"));
				System.out.println(mySet.getString("Title"));
				// 設置信息類對象的信息內容字段值
				information.setContent(mySet.getString("Content"));
				// 設置信息類對象的發布時間字段值
				information
						.setPublishingtime(mySet.getString("PublishingTime"));
				// 定義一個用戶類對象，該對象用來為信息類對象的用戶字段賦值

				// 設置信息類對象的用戶字段值
				information.setPublishiuser(mySet.getString("PublishingUser"));
				// 設置信息類對象的日誌類型字段值
				information.setType(mySet.getString("Type"));
				// 把信息類對象加入返回數據集中
			}
		}
		// 處理異常
		catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				// 釋放數據庫操作類的數據庫連接對象
				myDB.releaseConnection();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		// 返回結果
		return information;

	}

	/**
	 * 從數據庫中獲得所有信息分類
	 */
	public List<String> getAllTypes() {

		// 初始化sql查詢語句
		String sql = "select distinct(Type)  from information";
		// 初始化數據庫訪問類
		DatabaseDAO myDB = new DatabaseDAO();
		List<String> list = new ArrayList<String>();
		try {
			// 執行sql查詢語句，並獲取查詢結果集
			ResultSet mySet = myDB.getResultSet(sql);
			while (mySet.next()) {

				list.add(mySet.getString("Type"));
			}
		}
		// 處理異常
		catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				// 釋放數據庫操作類的數據庫連接對象
				myDB.releaseConnection();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		// 返回結果
		return list;
	}

	/**
	 * 該方法通過執行一條查詢的SQL語句來獲取查詢結果，並把查詢結果封裝成信息列表返
	 * 
	 * @param sql
	 * @return
	 */
	public List<Information> getInfoBySqlString(String sql) {
		// 初始化數據庫訪問類
		DatabaseDAO myDB = new DatabaseDAO();
		// 定義信息列表，預備返回對象
		List<Information> list = new ArrayList<Information>();
		try {
			// 執行sql查詢語句，並獲取查詢結果集
			ResultSet mySet = myDB.getResultSet(sql);
			while (mySet.next()) {
				// 定義信息類對象，用來封裝查詢數據
				Information information = new Information();
				// 設置信息類對象的Id字段值
				information.setId(mySet.getString("Id"));
				// 設置信息類對象的標題字段值
				information.setTitle(mySet.getString("Title"));
				// 設置信息類對象的信息內容字段值
				information.setContent(mySet.getString("Content"));
				// 設置信息類對象的發布時間字段值
				information
						.setPublishingtime(mySet.getString("PublishingTime"));
				// 定義一個用戶類對象，該對象用來為信息類對象的用戶字段賦值

				// 設置信息類對象的用戶字段值
				information.setPublishiuser(mySet.getString("PublishingUser"));
				// 設置信息類對象的日誌類型字段值
				information.setType(mySet.getString("Type"));
				// 把信息類對象加入返回數據集中
				list.add(information);
			}
		}
		// 處理異常
		catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				// 釋放數據庫操作類的數據庫連接對象
				myDB.releaseConnection();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		// 返回結果
		return list;
	}

}
