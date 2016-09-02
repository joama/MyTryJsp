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
	// �w�q�H���ާ@�~���޿豵�f��H
		private IInfoService infoService = new InfoService();
		// �w�q�Τ�ާ@�~���޿豵�f��H
		private IUserService userService = new UserService();
		// �w�q���׾ާ@�~���޿豵�f��H
		// private ICommentService commentService;
		// �H���s��
		private String infoId;
		// �Τ�W
		private String userName;
		// �H�����D
		private String title;
		// �H�����e
		private String content;
		// �H������
		private String type;
		// ���צC��
		// private List<Comment> comments;
		// �Τ�s��
		private String userId;
		// �H�������H
		private Information information;
		// �H���C��
		private List<Information> informations;
		// �H���C������
		private String listType;

		public String execute() throws Exception {
			return SUCCESS;
		}

		/**
		 * �o���H���A�o�����\��^�쭶��main.jsp
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
		 * �R���H���A�R�����\��^�쭶��information_list.action
		 * 
		 * @return
		 * @throws String
		 */
		public String delete() throws Exception {
			infoService.deleteInfoById(infoId);
			return execute();
		}

		/**
		 * �s��H���A�o�����\��^��information_list.action
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
		 * �d�ݫH���ԲӤ��e �A���B�ھ�inforId��l�ƤF���l�C��A�B�z���\������informationDetail.jsp����
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
		 * ����@���H�����C��A������\������informationList.jsp����
		 * 
		 * @return
		 * @throws String
		 */
		public String list() throws Exception {
			//listType = new String(listType.getBytes(), "utf-8");
			System.out.println("listType :  " + listType);
			// if(listType.equals("???")){
			// listType="��x";
			// }else {
			// listType="���ϫH��";
			// }
			informations = infoService.getInfoByType(listType);
			userId = (String) ActionContext.getContext().getSession().get("userId");
			userName = userService.getUserByID(userId).getUserName();
			return "list";
		}

		/**
		 * ����Τ�W������addInformation.jsp����
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
		 * �s��H���A�����e�Τ�W�M�H���ԲӤ��e��A�����editInformation.jsp����
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
			System.out.println("���D�O�G  " + title);
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
