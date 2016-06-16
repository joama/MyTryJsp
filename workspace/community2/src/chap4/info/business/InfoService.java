package chap4.info.business;

import java.util.List;

import chap4.info.dao.InfoDAO;
import chap4.info.persistence.Information;

public class InfoService {
	// 定義InfoDAO類型的屬性
	private InfoDAO infoDAO;
	
	// 預設建構式
	public InfoService(){
		// 初始化infoDAO
		this.infoDAO = new InfoDAO();
	}
	
	// 往資料庫中增加或更新資訊
	public void addOrUpdateInfo(Information information){
		// 如果資訊為空，則傳回，無需增加或更新
		if(information == null)
			return;
		// 往資料庫中增加或更新資訊
		infoDAO.makePersistent(information);
	}
	
	// 獲得資訊ID為id的資訊
	public Information getInfoByID(String id){
		// 如果id為空，則傳回
		if(id == null)
			return null;
		return infoDAO.getById(id);
	}
	
	// 獲得資料庫中的所有資訊，傳回List<Information>類型
	public List<Information> getAllInfo(){
		return infoDAO.getAll();
	}
	
	// 從資料庫中刪除資訊
	public void deleteInfo(Information information){
		// 如果資訊為空，則傳回
		if(information == null)
			return;
		// 資訊ID為空，說明該資訊在資料庫中不存在，無須刪除
		if(information.getId() == null)
			return;
		// 從資料庫中刪除資訊
		infoDAO.makeTransient(information);
	}
	
	// 從資料庫中刪除訊ID為id的資訊
	public void deleteInfoById(String id){
		Information information = infoDAO.getById(id);
		infoDAO.makeTransient(information);
	}
}
