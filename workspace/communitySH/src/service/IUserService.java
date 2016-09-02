package service;

import java.util.List;
import domain.User;

/**
 * User對應的業務邏輯接口，提供一些與信息相關的業務邏輯操作的公開的方法聲明
 */
public interface IUserService {

	// 添加註冊用戶信息到數據庫
	public void addUser(User user);

	// 根據用戶編號獲取用戶信息
	public User getUserByID(String id);

	// 驗證用戶登錄名和密碼是否合法
	public User validateUser(String userName, String password);

	// 驗證用戶名是否已經存在
	public boolean isUserExist(String userName);

	public String getUserIdByName(String userName);


}
