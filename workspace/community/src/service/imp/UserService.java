package service.imp;

import java.util.List;

import dao.IUserDAO;
import dao.imp.UserDAO;
import domain.User;
import service.IUserService;

public class UserService implements IUserService{

	private IUserDAO userDAO = new UserDAO();
	
	public UserService(){
		
	}
	
	public void addUser(User user){
		
		if(user == null)
			return;
		
		if(user.getId() != null)
			return;
		
		String userName = user.getUserName();
		
		List<User> users = userDAO.getUserByUserName(userName);
		
		if(users.size() <= 0){
			
			userDAO.addUser(user);
		} else {
			
			throw new RuntimeException("該使用者名稱已存在,請更換使用者名稱!");
		}
	}
	
	public User getUserByID(String id){
		
		if (id == null)
			return null;
		return userDAO.getUserByID(id);
	}
	
	public User validateUser(String userName, String password){
		
		List<User> users = userDAO.getUserByUserName(userName);
		if (users != null && users.size() != 0) {
			if (users.get(0).getPassword().equals(password)){
				
				return users.get(0);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	public boolean isUserExist (String userName){
		List<User> users = userDAO.getUserByUserName(userName);
		if(users.size() != 0)
			return true;
		else
			return false;
	}
}
