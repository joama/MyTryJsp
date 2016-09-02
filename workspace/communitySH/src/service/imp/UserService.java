package service.imp;

import java.util.List;
import dao.IUserDAO;
import dao.imp.UserDAO;
import domain.User;
import service.IUserService;

/**
 * 用戶服務類，用來處理業務邏輯
 */
public  class UserService implements IUserService {
	/**
	 * 定義IUserDAO類型的屬性，以實現UserService和IUserDAO實現類之間的協作
	 */
	private IUserDAO userDAO = new UserDAO();

	/**
	 * 默認構造函數
	 */
	public UserService() {

	}

	/**
	 * 往數據庫中添加用戶 如果用戶名不存在，則添加，否則不添加
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		// 如果用戶為空，則返回，無需添加
		if (user.getUserName() == null)
			return;

		// 獲得用戶名
		String userName = user.getUserName();
		// 從數據庫中查詢用戶名為userName的用戶
		List<User> users = userDAO.getUserByUserName(userName);
		// 如果返回的用戶記錄數目小於等於0，說明該用戶名不存在
		if (users.size() <= 0) {
			// 往數據庫中添加用戶
			userDAO.addUser(user);
		} else {
			// 拋出異常
			throw new RuntimeException("該用戶名已存在，請更換用戶名！");
		}
	}

	/**
	 * 根據參數id查詢數據庫中用戶
	 * 
	 * @param id
	 * @return 返回查詢所得用戶
	 */
	public User getUserByID(String id) {
		// 如果id為空，則返回
		if (id == null)
			return null;
		return userDAO.getUserById(id);
	}

	/**
	 * 驗證用戶的合法性
	 * 
	 * @param 用戶名
	 *            ，密碼
	 * @return 用戶合法返回true，否則返回false
	 */
	public User validateUser(String userName, String password) {

		// 調用數據訪問方法獲取用戶名對應的用戶信息
		List<User> users = userDAO.getUserByUserName(userName);
		if (users != null && users.size() != 0) {
			if (users.get(0).getPassWord().equals(password)) {
				// 如果用戶名和密碼合法，則返回用戶的完整信息，否則返回null
				return users.get(0);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * 驗證用戶名是否已經存在
	 * 
	 * @param 用戶名
	 * @return 存在則返回true，否則返回false
	 */
	public boolean isUserExist(String userName) {
		List<User> users = userDAO.getUserByUserName(userName);
		if (users.size() != 0)
			return true;
		else
			return false;
	}

	@Override
	public String getUserIdByName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
}
