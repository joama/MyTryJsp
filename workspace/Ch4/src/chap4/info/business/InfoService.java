package chap4.info.business;

import java.util.List;

import chap4.info.dao.InfoDAO;
import chap4.info.persistence.Information;

public class InfoService {

	//定義InfoDAO類型的屬性
	private InfoDAO infoDAO;
	
	// 默認構造函數
	public InfoService() {
		// 初始化infoDAO
		this.infoDAO = new InfoDAO();
	}

	// 往數據庫中添加或更新信息
	public void addOrUpdateInfo(Information information) {
		// 如果信息為空，則返回，無需添加或更新
		if (information == null)
			return;
		// 往數據庫中添加或更新信息
		infoDAO.makePersistent(information);
	}

	// 獲得信息ID為id的信息
	public Information getInfoByID(String id) {
		// 如果id為空，則返回
		if(id == null)
			return null;
		return infoDAO.getById(id);
	}
	
	// 獲得數據庫中所有信息，返回List<Information>類型
	public List<Information> getAllInfo() {
		return infoDAO.getAll();
	}

	// 從數據庫中刪除信息
	public void deleteInfo(Information information) {
		// 如果信息為空，則返回
		if(information == null)
			return;
		// 信息ID為空，說明該信息在數據庫中不存在，無需刪除
		if(information.getId() == null)
			return;
		// 從數據庫中刪除信息
		infoDAO.makeTransient(information);
	}

	// 從數據庫中刪除信息ID為id的信息
	public void deleteInfoById(String id) {
		Information information=infoDAO.getById(id);
		infoDAO.makeTransient(information);
	}
}

