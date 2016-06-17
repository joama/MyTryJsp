package chap4.info.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import chap4.info.persistence.Information;


public class InfoDAO extends GenericHibernateDAO<Information, String> {
	// 構造函數
	public InfoDAO() {
		// 調用父類的構造函數，初始化持久對象類型
		super(Information.class);
	}

	// 根據信息標題獲得信息對象實例
	public List<Information> getInfoByInfoTitle(String title) {
		// 創建查詢
		Criteria criteria = getSession().createCriteria(Information.class);
		// 設置查詢條件
		criteria.add(Restrictions.eq("title", title));
		// 返回查詢結果
		return criteria.list();
	}
}
