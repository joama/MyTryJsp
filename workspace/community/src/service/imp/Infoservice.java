package service.imp;

import java.util.List;

import dao.IInfoDAO;
import dao.imp.InfoDAO;
import domain.Information;
import service.IInfoService;

public class Infoservice implements IInfoService{

	private IInfoDAO infoDAO = new InfoDAO();
	
	public Infoservice(){
		
	}
	
	@Override
	public void addInfo(Information information){
		
		if (information.getTitle() == null)
			return;
		
		/*if (information.getId() != null)
			return;*/
		
		infoDAO.addInfo(information);
	}
	
	public List<Information> getAllInfo(){
		return infoDAO.getAllInfo();
	}
}
