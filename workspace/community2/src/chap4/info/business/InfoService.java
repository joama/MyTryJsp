package chap4.info.business;

import java.util.List;

import chap4.info.dao.InfoDAO;
import chap4.info.persistence.Information;

public class InfoService {
	// �w�qInfoDAO�������ݩ�
	private InfoDAO infoDAO;
	
	// �w�]�غc��
	public InfoService(){
		// ��l��infoDAO
		this.infoDAO = new InfoDAO();
	}
	
	// ����Ʈw���W�[�Χ�s��T
	public void addOrUpdateInfo(Information information){
		// �p�G��T���šA�h�Ǧ^�A�L�ݼW�[�Χ�s
		if(information == null)
			return;
		// ����Ʈw���W�[�Χ�s��T
		infoDAO.makePersistent(information);
	}
	
	// ��o��TID��id����T
	public Information getInfoByID(String id){
		// �p�Gid���šA�h�Ǧ^
		if(id == null)
			return null;
		return infoDAO.getById(id);
	}
	
	// ��o��Ʈw�����Ҧ���T�A�Ǧ^List<Information>����
	public List<Information> getAllInfo(){
		return infoDAO.getAll();
	}
	
	// �q��Ʈw���R����T
	public void deleteInfo(Information information){
		// �p�G��T���šA�h�Ǧ^
		if(information == null)
			return;
		// ��TID���šA�����Ӹ�T�b��Ʈw�����s�b�A�L���R��
		if(information.getId() == null)
			return;
		// �q��Ʈw���R����T
		infoDAO.makeTransient(information);
	}
	
	// �q��Ʈw���R���TID��id����T
	public void deleteInfoById(String id){
		Information information = infoDAO.getById(id);
		infoDAO.makeTransient(information);
	}
}
