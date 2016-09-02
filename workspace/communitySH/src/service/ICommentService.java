package service;

import java.util.List;
import domain.Comment;

/**
 * Comment對應的業務邏輯接口，提供一些與信息相關的業務邏輯操作的公開的方法聲明
 */
public interface ICommentService {
	public void addComment(Comment comment);

	public void deleteComment(Comment comment);

	public void updateComment(Comment comment);

	public Comment getCommentByID(String id);

	public List<Comment> getAllComment();

	public List<Comment> getCommentByInfoId(String infoId);

	public void deleteCommentById(String commentId);
}
