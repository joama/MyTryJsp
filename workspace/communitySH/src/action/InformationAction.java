package action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.Information;
import domain.User;
import service.IInfoService;
import service.IUserService;
import service.imp.InfoService;
import service.imp.UserService;

@SuppressWarnings("serial")
public class InformationAction extends ActionSupport {
	// 定義信息操作業務邏輯接口對象
		private IInfoService infoService = new InfoService();
		// 定義用戶操作業務邏輯接口對象
		private IUserService userService = new UserService();
		// 定義評論操作業務邏輯接口對象
		// private ICommentService commentService;
		// 信息編號
		private String infoId;
		// 用戶名
		private String userName;
		// 信息標題
		private String title;
		// 信息內容
		private String content;
		// 信息類型
		private String type;
		// 評論列表
		// private List<Comment> comments;
		// 用戶編號
		private String userId;
		// 信息實體對象
		private Information information;
		// 信息列表
		private List<Information> informations;
		// 信息列表類型
		private String listType;

		public String execute() throws Exception {
			return SUCCESS;
		}

		/**
		 * 發布信息，發布成功返回到頁面main.jsp
		 * 
		 * @return
		 * @throws String
		 */
		public String add() throws Exception {
			Map<String, Object> session = ActionContext.getContext().getSession();
			User user = (User) session.get("user");
			userName = user.getUserName();
			Information information = new Information();
			information.setTitle(getTitle());
			information.setContent(getContent());
			information.setType(getType());
			SimpleDateFormat dateFormat=new SimpleDateFormat("yy/MM/dd HH:mm");
			information.setPublishingtime(dateFormat.format(new Date(0)));
			information.setPublishiuser(userName);
			infoService.addInfo(information);
			return execute();
		}

		/**
		 * 刪除信息，刪除成功返回到頁面information_list.action
		 * 
		 * @return
		 * @throws String
		 */
		public String delete() throws Exception {
			infoService.deleteInfoById(infoId);
			return execute();
		}

		/**
		 * 編輯信息，發布成功返回到information_list.action
		 * 
		 * @return
		 * @throws String
		 */
		public String edit() throws Exception {
			Information information = infoService.getInfoByID(infoId);
			information.setTitle(title);
			information.setContent(content);
			information.setType(type);
			infoService.updateInfo(information);
			return execute();
		}

		/**
		 * 查看信息詳細內容 ，此處根據inforId初始化了帖子列表，處理成功後跳轉到informationDetail.jsp頁面
		 * 
		 * @return
		 * @throws String
		 */
		public String detail() throws Exception {
			information = infoService.getInfoByID(infoId);
			// comments = commentService.getCommentByInfoId(infoId);
			userId = (String) ActionContext.getContext().getSession().get("userId");
			userName = userService.getUserByID(userId).getUserName();
			return "detail";
		}

		/**
		 * 獲取一類信息的列表，獲取成功後跳轉到informationList.jsp頁面
		 * 
		 * @return
		 * @throws String
		 */
		public String list() throws Exception {
			//listType = new String(listType.getBytes(), "utf-8");
			System.out.println("listType :  " + listType);
			// if(listType.equals("???")){
			// listType="日誌";
			// }else {
			// listType="社區信息";
			// }
			informations = infoService.getInfoByType(listType);
			userId = (String) ActionContext.getContext().getSession().get("userId");
			userName = userService.getUserByID(userId).getUserName();
			return "list";
		}

		/**
		 * 獲取用戶名後跳轉到addInformation.jsp頁面
		 * 
		 * @return
		 * @throws String
		 */
		public String input() throws Exception {
			Map<String, Object> session = ActionContext.getContext().getSession();
			User user = (User) session.get("user");
			userName = user.getUserName();

			return INPUT;
		}

		/**
		 * 編輯信息，獲取當前用戶名和信息詳細內容後，跳轉到editInformation.jsp頁面
		 * 
		 * @return
		 * @throws String
		 */
		public String editInput() throws Exception {
			Map<String, Object> session = ActionContext.getContext().getSession();
			String userId = (String) session.get("userId");
			User user = userService.getUserByID(userId);
			userName = user.getUserName();
			Information information = infoService.getInfoByID(infoId);
			title = information.getTitle();
			content = information.getContent();
			type = information.getType();
			return "edit";
		}

		public IInfoService getInfoService() {
			return infoService;
		}

		public void setInfoService(InfoService infoService) {
			this.infoService = infoService;
		}

		public IUserService getUserService() {
			return userService;
		}

		public void setUserService(IUserService userService) {
			this.userService = userService;
		}

		public String getInfoId() {
			return infoId;
		}

		public void setInfoId(String infoId) {
			this.infoId = infoId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			System.out.println("標題是：  " + title);
			this.title = title;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		/*
		 * public List<Comment> getComments() { return comments; }
		 * 
		 * public void setComments(List<Comment> comments) { this.comments =
		 * comments; }
		 */

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public Information getInformation() {
			return information;
		}

		/*
		 * public void setCommentService(ICommentService commentService) {
		 * this.commentService = commentService; }
		 */

		public String getListType() {
			return listType;
		}

		public void setListType(String listType) {
			this.listType = listType;
		}

		public List<Information> getInformations() {
			return informations;
		}
}
