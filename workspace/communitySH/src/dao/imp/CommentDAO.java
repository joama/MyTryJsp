package dao.imp;

import java.util.List;
import dao.ICommentDAO;
import domain.Comment;

public class CommentDAO implements ICommentDAO {
	/**
	 * 默認構造函數，在使用Spring和Hibernate的環境中一般需要（反射）。
	 */
	public CommentDAO() {

	}

	public void addComment(Comment comment) {

	}

	public void deleteComment(Comment comment) {

	}

	public void deleteCommentById(String commentId) {

	}

	public List<Comment> getAllComments() {

		return null;
	}

	public List<Comment> getCommentByInfoId(String infoId) {

		return null;
	}

	public Comment getCommentById(String id) {
		return null;
	}

	public List<Comment> getCommentByTitle(String title) {
		return null;
	}

	public void updateComment(Comment comment) {

	}

}
