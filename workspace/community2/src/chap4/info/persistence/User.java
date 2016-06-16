package chap4.info.persistence;

import java.util.Set;

// User���O�A�ΨӪ�ܨϥΪ�

public class User {
	private String id;                     // �ϥΪ�ID
	private String userName;               // �ϥΪ̦W��
	private String password;               // �K�X
	private String realName;               // �u��m�W
	private Set<Information> informations; // �ϥΪ̵o������T
	
	// �w�]�غc���A�b�ϥ�Hibernate�����Ҥ��ݭn
	public User(){
	}
	
	/*
	 * �a�Ѽƪ��غc���A�ΨӪ�l��User���O���ݩʡC 
	 * �ӰѼƦC�����]�Aid�A�]��id�O��Hibernate�Ӷi���l�ƪ��C
	 * id����l�ƾާ@�o�ͦb�NUser�����x�s���Ʈw���e�������C
	 */
	
	public User(String userName, String password, String realName) {
		this.userName = userName;
		this.password = password;
		this.realName = realName;
	}

	// ��oid
	public String getId() {
		return id;
	}

	/*
	 * �]�wid 
	 * ���ҥH���Opublic�ӥ�protected�A�]��
	 * id�O��Hibernate�ج[���ͪ��A�����ӥѨϥΪ̳]�w�C
	 * Hibernate�ج[�i�H����qprotected�D��private�v�����Ҧ�set��k�C
	 */
	protected void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	// ��o�ϥΪ̵o������T
	public Set<Information> getInformations() {
		return informations;
	}

	/*
	 * �]�w�ϥΪ̵o���T��
	 * User�MInformation�O�@��h�����Y-- �@�ӨϥΪ̥i�H�o��h����T
	 * �Ӥ�k�Ψӳ]�wUser�MInformation���p(�@��h���u �@�v���@��)
	 * informations�O���X(Set)�����A�ΨӮe�Ǧh����T
	 */
	public void setInformations(Set<Information> informations) {
		this.informations = informations;
	}
	
	// ����Object���O��toString��k�A�N�ϥΪ̪�����Ƭ��r��i�{
	public String toString(){
		return "�ϥΪ̦W��:" + userName + " " + "�A�u��m�W:" + realName;
	}
}
