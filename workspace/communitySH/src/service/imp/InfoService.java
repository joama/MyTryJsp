package service.imp;

import java.util.List;
import dao.IInfoDAO;
import dao.imp.InfoDAO;
import domain.Information;
import service.IInfoService;

/**
 * Information類對應的業務邏輯類 提供業務邏輯操作
 */
public class InfoService implements IInfoService {
	/**
	 * 定義IInfoDAO類型的屬性，以實現InfoService和IInfoDAO實現類之間的協作
	 */
	private IInfoDAO infoDAO = new InfoDAO();

	/**
	 * 默認構造函數
	 */
	public InfoService() {

	}

	/**
	 * 往數據庫中添加信息
	 */

	public void addInfo(Information information) {
		// 如果信息為空，則返回，無需添加
		if (information.getTitle() == null)
			return;
		// 信息ID不為空，說明該信息在數據庫中已存在，不應該是添加而應該是更新
		// 往數據庫中添加信息
		infoDAO.addInfo(information);
	}

	/**
	 * 活的數據庫中所有信息，返回List<Information>類型
	 */
	public List<Information> getAllInfo() {
		return infoDAO.getAllInfo();
	}

	public void deleteInfo(Information information) {
		// TODO Auto-generated method stub

	}

	public void deleteInfoById(String id) {

		infoDAO.deleteInfoById(id);

	}

	public List<String> getAllTypes() {

		return infoDAO.getAllTypes();
	}

	public Information getInfoByID(String id) {

		return infoDAO.getInfoByID(id);
	}

	public List<Information> getInfoByType(String type) {
		return infoDAO.getInfoByType(type);
	}

	public void updateInfo(Information information) {
		// TODO Auto-generated method stub

	}

}
