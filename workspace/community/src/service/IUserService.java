package service;

import domain.User;

public interface IUserService {
	
	public void addUser(User user);
	
	public User getUserByID(String id);
	
	public User validateUser(String userName, String password);
	
	public boolean isUserExist(String userName);
}
