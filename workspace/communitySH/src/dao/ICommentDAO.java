package dao;

import java.util.List;
import domain.Comment;

/**
 * Comment類對應的DAO接口，提供一些與信息相關的數據庫CRUD操作的公開的方法聲明
 */
public interface ICommentDAO {
	public void addComment(Comment comment);

	public Comment getCommentById(String id);

	public void updateComment(Comment comment);

	public void deleteComment(Comment comment);

	public List<Comment> getCommentByTitle(String title);

	public List<Comment> getAllComments();

	public List<Comment> getCommentByInfoId(String infoId);

	public void deleteCommentById(String commentId);
}
