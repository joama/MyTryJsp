package chap4.info.business;

import java.util.List;

import chap4.info.dao.UserDAO;
import chap4.info.exception.ServiceException;
import chap4.info.persistence.User;

public class UserService {
	// 定義UserDAO類型的屬性
	private UserDAO userDAO;
	
	// 默認構造函數
	public UserService() {
		// 初始化userDAO
		this.userDAO = new UserDAO();
	}

	/**
	 * 往數據庫中添加用戶
	 * 如果用戶名已存在，則拋出異常；否則添加
	 */
	public boolean addUser(User user)
	{
		// 如果用戶為空，則返回，無需添加
		if(user == null)
		return false;
			// 獲得用戶名
		String userName = user.getUserName();
		// 從數據庫中查詢用戶名為userName的用戶
		User u = userDAO.getUserByUserName(userName);
		// 如果返回的用戶記錄數目小於等於0，說明該用戶名不存在
		if(u != null)
		{
			
			// 當用戶名已存在時拋出異常，以保證數據庫中用戶名唯一
			throw new ServiceException("該用戶名已存在，請更換用戶名！");
		}
		else
		{
			//往數據庫中添加用戶
			userDAO.makePersistent(user);
			return true;
		}
	}
	
	// 更新數據庫中用戶
	public void updateUser(User user) {
		// 如果用戶信息為空，則返回
		if(user == null){
			return;
		}
		// 用戶ID為空，說明該用戶在數據庫中不存在，不需更新，直接返回
		if(user.getId() == null){
			return;
		}
		// 更新數據庫中用戶信息
		userDAO.makePersistent(user);
	}
	
	// 獲得用戶ID為id的用戶
	public User getUserByID(String id)
	{
		// 如果id為空，返回空
		if(id == null){
			return null;
		}
		// 獲得數據庫中id為傳入參數id的用戶 
		return userDAO.getById(id);
	}
	
	// 從數據庫中獲得所有用戶，返回List<User>
	public List<User> getAllUser() {
		return userDAO.getAll();
	}

	// 根據用戶名獲得用戶ID
	public String getUserIdByName(String userName) {
		return userDAO.getUserByUserName(userName).getId();
	}
	
	// 從數據庫中刪除用戶
	public void deleteUser(User user) {
		// 如果用戶為空，則返回
		if(user == null){
			return;
		}
		// 用戶ID為空，說明該用戶在數據庫中不存在，無需刪除
		if(user.getId() == null){
			return;
		}
		// 從數據庫中刪除用戶
		userDAO.makeTransient(user);
	}
	
	// 驗證用戶名和密碼是否正確，用於登陸和授權
	public boolean validateUser(String userName, String password) {
   User user = userDAO.getUserByUserName(userName);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	// 判斷用戶名為userName的用戶是否存在
	public boolean isUserExist(String userName) {
		User user = userDAO.getUserByUserName(userName);
		return user != null ? true : false;
	}
}


