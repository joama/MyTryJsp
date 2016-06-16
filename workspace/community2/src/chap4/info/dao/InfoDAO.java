package chap4.info.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import chap4.info.persistence.Information;

public class InfoDAO extends GenericHibernateDAO<Information, String>{
	// 建構式
	public InfoDAO() {
		// 呼叫父類別的建構式，初始化持久化物件類型
		super(Information.class);
	}
	
	// 根據資訊標題獲得資訊物件實體
	public List<Information> getInfoByInfoTitle(String title){
		// 建立查詢
		Criteria criteria = getSession().createCriteria(Information.class);
		// 設定查詢準則
		criteria.add(Restrictions.eq("title", title));
		// 傳回查詢結果
		return criteria.list();
	}
}
