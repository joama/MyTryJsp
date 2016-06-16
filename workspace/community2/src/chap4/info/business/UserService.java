package chap4.info.business;

import java.util.List;

import chap4.info.dao.UserDAO;
import chap4.info.exception.ServiceException;
import chap4.info.persistence.User;

public class UserService {
	// �w�qUserDAO���O�����ݩ�
	private UserDAO userDAO;
	
	// �w�]�غc��
	public UserService(){
		// ��l��userDAO
		this.userDAO = new UserDAO();
	}
	
	/*
	 * ����Ʈw���W�[�ϥΪ�
	 * �p�G�ϥΪ̦W�٤w�s�b�A�h�ߥX�C�~;�_�h�W�[ 
	 */
	public void addUser(User user){
		// �p�G�ϥΪ̬��šA�h�Ǧ^�A�L�ݼW�[
		if(user == null)
			return;
		// ��o�ϥΪ̦W��
		String userName = user.getUserName();
		// �q��Ʈw���d�ߨϥΪ̦W�٬�userName���ϥΪ�
		User u = userDAO.getUserByUserName(userName);
		// �p�G�Ǧ^���ϥΪ̬����ƥؤp��ε���0�A�h�����ӨϥΪ̦W�٤��s�b
		if(u != null){
			// ��ϥΪ̦W�٤w�s�b�ɩߥX�ҥ~�A�H�O�Ҹ�Ʈw�����ϥΪ̦W�ٰߤ@
			throw new ServiceException("�ӨϥΪ̦W�٤w�s�b�A�Ч󴫨ϥΪ̦W��!");
		}else{
			// ����Ʈw���W�[�ϥΪ�
			userDAO.makePersistent(user);
		}
	}
	
	// ��s��Ʈw�����ϥΪ�
	public void updateUser(User user){
		// �p�G�ϥΪ̸�T���šA�h�Ǧ^
		if(user == null)
			return;
		// �ϥΪ�ID���šA�����ӨϥΪ̦b��Ʈw�����s�b�A���ݭn��s�A�����Ǧ^
		if(user.getId() == null)
			return;
		// ��s��Ʈw�����ϥΪ̸�T
		userDAO.makePersistent(user);
	}
	
	// ��o�ϥΪ�ID��id���ϥΪ�
	public User getUserByID(String id){
		// �p�Gid���šA�Ǧ^��
		if(id == null)
			return null;
		// ��o��Ʈw��id���ǤJ�Ѽ�id���ϥΪ�
		return userDAO.getById(id);
	}
	
	// �q��Ʈw����o�Ҧ��ϥΪ̡A�Ǧ^List<User>
	public List<User> getAllUser(){
		return userDAO.getAll();
	}
	
	// �ھڨϥΪ̦W����o�ϥΪ�ID
	public String getUserIdByName(String userName){
		return userDAO.getUserByUserName(userName).getId();
		
	}
	
	// �q��Ʈw���R���ϥΪ�
	public void deleteUser(User user){
		// �p�G�ϥΪ̬��šA�h�Ǧ^
		if(user == null)
			return;
		// �ϥΪ�ID���šA�����ӨϥΪ̦b��Ʈw�����s�b�A�L���R��
		if(user.getId() == null)
			return;
		// �q��Ʈw���R���ϥΪ�
		userDAO.makeTransient(user);
	}
	
	// ���ҨϥΪ̦W�٩M�K�X�O�_���T�A�Ω�n���M���v
	public boolean validateUser(String userName, String password){
		User user = userDAO.getUserByUserName(userName);
		if(user != null){
			if(user.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}
	
	// �P�_�ϥΪ̦W�٬�userName���ϥΪ̬O�_�s�b
	public boolean isUserExist(String userName){
		User user = userDAO.getUserByUserName(userName);
		return user != null ? true : false;
	}
}
