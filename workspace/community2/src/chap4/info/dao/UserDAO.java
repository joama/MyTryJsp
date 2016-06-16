package chap4.info.dao;

import org.hibernate.Query;

import chap4.info.persistence.User;

public class UserDAO extends GenericHibernateDAO<User, String>{
	// 建構式
	public UserDAO() {
		// 呼叫父類別的建構式，初始化持久化物件類型
		super(User.class);
	}
	
	// 根據使用者名稱獲得使用者物件實體
	public User getUserByUserName(String userName){
		// 建立HQL查詢
		Query query = getSession().getNamedQuery("getUserByUserName");
		// 設定HQL查詢語句參數
		query.setString(0, userName);
		// 傳回查詢結果
		return (User) query.uniqueResult();
	}
}
