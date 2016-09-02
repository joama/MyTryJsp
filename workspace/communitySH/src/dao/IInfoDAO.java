package dao;

import java.util.List;

import domain.Information;

public interface IInfoDAO {

	// 該方法實現添加一條信息到數據庫中
	public void addInfo(Information info);

	// 該方法獲取所有的信息表
	public List<Information> getAllInfo();

	public List<String> getAllTypes();

	public List<Information> getInfoByType(String type);

	public Information getInfoByID(String id);

	public void deleteInfoById(String id);

}
