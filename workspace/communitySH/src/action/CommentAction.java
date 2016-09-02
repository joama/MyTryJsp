package action;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import domain.Comment;
import domain.Information;
import domain.User;
import service.ICommentService;
import service.IInfoService;
import service.IUserService;

public class CommentAction implements Action{
	private ICommentService commentService;
	private IInfoService infoService;
	private IUserService userService;
	private String infoId;
	private String title;
	private String content;
	private String commentId;
	
	/*
	 * 發表評論，發表成功後傳回到information_detail.action
	 * @return
	 * @throws Excepton
	 * */
	public String add() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String userId = (String)session.get("userId");
		User user = userService.getUserByID(userId);
		Information information = infoService.getInfoByID(infoId);
		Comment comment = new Comment();
		comment.setTitle(title);
		comment.setContent(content);
		comment.setCommenter(user);
		comment.setInformation(information);
		comment.setDeliveredTime(new Date());
		commentService.addComment(comment);
		return SUCCESS;
	}
	
	/*
	 * 轉換到發表評論頁面，傳遞的參數為屬性infoId的值
	 * @return
	 * @throws Exception
	 * */
	public String input() throws Exception
	{
		return INPUT;
	}
	
	/*
	 * 評論的刪除，刪除成功後傳回到information_detail.actoin
	 * @return
	 * @throws Exception
	 * */
	public String delete() throws Exception{
		commentService.deleteCommentById(commentId);
		return SUCCESS;
	}
	
	
	public ICommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}

	public IInfoService getInfoService() {
		return infoService;
	}

	public void setInfoService(IInfoService infoService) {
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
