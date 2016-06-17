package chap4.info.dao;

import org.hibernate.Query;

import chap4.info.persistence.User;

public class UserDAO extends GenericHibernateDAO<User, String> {
	// 構造函數
	public UserDAO()
	{
		// 調用父類的構造函數，初始化持久對象類型
		super(User.class);
	}

	// 根據用戶名獲得用戶對象實例
	public User getUserByUserName(String userName) {
		// 創建HQL查詢
		Query query = getSession().getNamedQuery("getUserByUserName");
		// 設置HQL查詢語句參數
		query.setString(0, userName);
		// 返回查詢結果
		return (User) query.uniqueResult();
	}
}

