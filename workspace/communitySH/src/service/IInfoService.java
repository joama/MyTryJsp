package service;

import java.util.List;
import domain.Information;

/**
 * Information對應的業務邏輯接口，提供一些與資訊相關的業務邏輯操作的公開的方法宣告
 */
public interface IInfoService {
	// 發布資訊
	public void addInfo(Information information);

	// 刪除資訊
	public void deleteInfo(Information information);

	// 編輯資訊
	public void updateInfo(Information information);

	// 獲取一條資訊
	public Information getInfoByID(String id);

	// 獲取所有資訊的清單
	public List<Information> getAllInfo();

	// 獲取所有類型
	public List<String> getAllTypes();

	// 根據類型獲取資訊列表
	public List<Information> getInfoByType(String type);

	// 根據資訊編號來刪除相應的資訊
	public void deleteInfoById(String id);
}
