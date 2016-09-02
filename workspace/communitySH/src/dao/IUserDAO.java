package dao;

import java.util.List;

import domain.User;

public interface IUserDAO {

	// 添加一個用戶到數據庫中
	public void addUser(User user);

	// 根據用戶編號獲取用戶信息，以User對象的形式返回
	public User getUserById(String id);

	// 根據用戶名獲取用戶信息，以User對象返回
	public List<User> getUserByUserName(String userName);

}
