package chap4.info.dao;

import org.hibernate.Query;

import chap4.info.persistence.User;

public class UserDAO extends GenericHibernateDAO<User, String>{
	// �غc��
	public UserDAO() {
		// �I�s�����O���غc���A��l�ƫ��[�ƪ�������
		super(User.class);
	}
	
	// �ھڨϥΪ̦W����o�ϥΪ̪������
	public User getUserByUserName(String userName){
		// �إ�HQL�d��
		Query query = getSession().getNamedQuery("getUserByUserName");
		// �]�wHQL�d�߻y�y�Ѽ�
		query.setString(0, userName);
		// �Ǧ^�d�ߵ��G
		return (User) query.uniqueResult();
	}
}
