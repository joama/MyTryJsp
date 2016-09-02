package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import domain.Information;
import domain.User;
import service.ICommentService;
import service.IInfoService;
import service.IUserService;

public class Main implements Action{

	private IUserService userService;
	private IInfoService infoService;
	private ICommentService commentService;
	private String userId;
	private String userName;
	private Map<String, List<Information>> informations = new HashMap<String, List<Information>>();
	
	/*
	 * 使用者登錄成功後執行的方法，分類獲取所有資訊清單
	 * */
	public String execute() throws Exception {
		// 從工作階段中讀取userId
		Map<String, Object> session = ActionContext.getContext().getSession();
		String userId = (String)session.get("userId");
		if(userId != null){
			this.userId = userId;
			User user = userService.getUserByID(userId);
			// 獲取使用者名稱並賦予userName屬性，該職位於值推疊物件中
			userName = user.getUserName();
		}
		// 獲取資訊的所有類型清單
		List<String> types = infoService.getAllTypes();
		// 針對每種類型，獲取資訊List並壓入Map物件，該物件位於值推疊物件中
		for(int i = 0; i< types.size(); i++){
			String type = types.get(i);
			informations.put(type, infoService.getInfoByType(type));
		}
		return SUCCESS;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IInfoService getInfoService() {
		return infoService;
	}

	public void setInfoService(IInfoService infoService) {
		this.infoService = infoService;
	}

	public ICommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Map<String, List<Information>> getInformations() {
		return informations;
	}

	public void setInformations(Map<String, List<Information>> informations) {
		this.informations = informations;
	}

}
