package chap4.info.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import chap4.info.persistence.Information;

public class InfoDAO extends GenericHibernateDAO<Information, String>{
	// �غc��
	public InfoDAO() {
		// �I�s�����O���غc���A��l�ƫ��[�ƪ�������
		super(Information.class);
	}
	
	// �ھڸ�T���D��o��T�������
	public List<Information> getInfoByInfoTitle(String title){
		// �إ߬d��
		Criteria criteria = getSession().createCriteria(Information.class);
		// �]�w�d�߷ǫh
		criteria.add(Restrictions.eq("title", title));
		// �Ǧ^�d�ߵ��G
		return criteria.list();
	}
}
