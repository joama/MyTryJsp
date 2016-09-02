package service.imp;

import java.util.List;
import dao.ICommentDAO;
import domain.Comment;
import service.ICommentService;

public class CommentService implements ICommentService {
	/**
	 * 定義ICommentDAO類型的屬性，以實現InfoService和IInfoDAO實現類之間的協作
	 */
	private ICommentDAO commentDAO;

	/**
	 * 默認構造函數，在使用Spring和Hibernate的環境中一般需要（反射）。
	 */
	public CommentService() {

	}

	/**
	 * 設置commentDAO屬性，在使用Spring的Setter注入時需要
	 */
	public void setCommentDAO(ICommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	public void addComment(Comment comment) {
		// 如果信息為空，則返回，無需添加
		if (comment == null)
			return;
		// 信息ID不為空，說明該信息在數據庫中已存在，不應該是添加而應該是更新
		if (comment.getId() != null)
			return;
		// 往數據庫中添加信息
		commentDAO.addComment(comment);
	}

	public void deleteComment(Comment comment) {
		// 如果信息為空，則返回
		if (comment == null)
			return;
		// 信息ID為空，說明該信息在數據庫中不存在，無需刪除
		if (comment.getId() == null)
			return;
		// 從數據庫中刪除信息
		commentDAO.deleteComment(comment);
	}

	public void deleteCommentById(String commentId) {
		// 從數據庫中刪除信息
		commentDAO.deleteCommentById(commentId);
	}

	public List<Comment> getAllComment() {
		return commentDAO.getAllComments();
	}

	public List<Comment> getCommentByInfoId(String infoId) {

		return commentDAO.getCommentByInfoId(infoId);
	}

	public Comment getCommentByID(String id) {
		// 如果id為空，則返回
		if (id == null)
			return null;
		return commentDAO.getCommentById(id);
	}

	public void updateComment(Comment comment) {
		// 如果信息為空，則返回
		if (comment == null)
			return;
		// 信息ID為空，說明該信息在數據庫中不存在，不應該是更新，而應該是添加
		if (comment.getId() == null)
			return;
		commentDAO.updateComment(comment);
	}

}
