package chap4.info.business;

import java.util.List;

import chap4.info.dao.UserDAO;
import chap4.info.exception.ServiceException;
import chap4.info.persistence.User;

public class UserService {
	// 定義UserDAO類別型的屬性
	private UserDAO userDAO;
	
	// 預設建構式
	public UserService(){
		// 初始化userDAO
		this.userDAO = new UserDAO();
	}
	
	/*
	 * 往資料庫中增加使用者
	 * 如果使用者名稱已存在，則拋出列外;否則增加 
	 */
	public void addUser(User user){
		// 如果使用者為空，則傳回，無需增加
		if(user == null)
			return;
		// 獲得使用者名稱
		String userName = user.getUserName();
		// 從資料庫中查詢使用者名稱為userName的使用者
		User u = userDAO.getUserByUserName(userName);
		// 如果傳回的使用者紀錄數目小於或等於0，則說明該使用者名稱不存在
		if(u != null){
			// 當使用者名稱已存在時拋出例外，以保證資料庫中的使用者名稱唯一
			throw new ServiceException("該使用者名稱已存在，請更換使用者名稱!");
		}else{
			// 往資料庫中增加使用者
			userDAO.makePersistent(user);
		}
	}
	
	// 更新資料庫中的使用者
	public void updateUser(User user){
		// 如果使用者資訊為空，則傳回
		if(user == null)
			return;
		// 使用者ID為空，說明該使用者在資料庫中不存在，不需要更新，直接傳回
		if(user.getId() == null)
			return;
		// 更新資料庫中的使用者資訊
		userDAO.makePersistent(user);
	}
	
	// 獲得使用者ID為id的使用者
	public User getUserByID(String id){
		// 如果id為空，傳回空
		if(id == null)
			return null;
		// 獲得資料庫中id為傳入參數id的使用者
		return userDAO.getById(id);
	}
	
	// 從資料庫中獲得所有使用者，傳回List<User>
	public List<User> getAllUser(){
		return userDAO.getAll();
	}
	
	// 根據使用者名稱獲得使用者ID
	public String getUserIdByName(String userName){
		return userDAO.getUserByUserName(userName).getId();
		
	}
	
	// 從資料庫中刪除使用者
	public void deleteUser(User user){
		// 如果使用者為空，則傳回
		if(user == null)
			return;
		// 使用者ID為空，說明該使用者在資料庫中不存在，無須刪除
		if(user.getId() == null)
			return;
		// 從資料庫中刪除使用者
		userDAO.makeTransient(user);
	}
	
	// 驗證使用者名稱和密碼是否正確，用於登錄和授權
	public boolean validateUser(String userName, String password){
		User user = userDAO.getUserByUserName(userName);
		if(user != null){
			if(user.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}
	
	// 判斷使用者名稱為userName的使用者是否存在
	public boolean isUserExist(String userName){
		User user = userDAO.getUserByUserName(userName);
		return user != null ? true : false;
	}
}
