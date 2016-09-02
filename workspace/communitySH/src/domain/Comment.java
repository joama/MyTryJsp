package domain;

import java.util.Date;

/**
 * 評論類
 */
public class Comment {
	// 評論ID
	private String id;
	// 標題
	private String title;
	// 評論內容
	private String content;
	// 評論時間
	private Date deliveredTime;
	// 評論者
	private User commenter;
	// 所評論的信息
	private Information information;

	/**
	 * 默認構造函數，在使用Spring和Hibernate的環境中一般需要（反射）。
	 */
	public Comment() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Date getDeliveredTime() {
		return deliveredTime;
	}

	public void setDeliveredTime(Date deliveredTime) {
		this.deliveredTime = deliveredTime;
	}

	public User getCommenter() {
		return commenter;
	}

	public void setCommenter(User commenter) {
		this.commenter = commenter;
	}

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

}
