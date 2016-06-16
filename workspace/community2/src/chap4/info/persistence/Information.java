package chap4.info.persistence;

import java.util.Date;

// Information類別，用來代表資訊
public class Information {
	private String id;            // 資訊ID
	private String title;         // 標題
	private String content;       // 內容
	private Date publishingTime;  // 發布時間
	private User publishingUser;  // 發布者
	
	public Information(){		
	}
	
	public Information(String title, String content, Date publishingTime, User publishingUser) {
		this.title = title;
		this.content = content;
		this.publishingTime = publishingTime;
		this.publishingUser = publishingUser;
	}
	
	// 獲得id
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
	public Date getPublishingTime() {
		return publishingTime;
	}
	public void setPublishingTime(Date publishingTime) {
		this.publishingTime = publishingTime;
	}
	
	// 獲得發布者資訊
	public User getPublishingUser() {
		return publishingUser;
	}
	
	/*
	 * 設定發布者的資訊 
	 * User和Information是一對多的關係-- 一個使用者可以發表多條資訊
	 * 該方法用來設定User和Information關聯(一對多中「多」的一方)
	 */
	public void setPublishingUser(User publishingUser) {
		this.publishingUser = publishingUser;
	}

	// 重載Object類別的toString方法，將資訊物件轉化為字串展現
	@Override
	public String toString() {
		return "標題:" + title + "，發布時間:" + publishingTime;
	}

	/*
	 * 重載Object類別的hashCode方法
	 * 該方法用來產生Information實體的雜湊碼(hashcode)
	 * 當Information類別處於Hibernate中一對多關聯性中「多」的一方時需要該方法
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((publishingTime == null) ? 0 : publishingTime.hashCode());
		return result;
	}

	/*
	 * 重載Object類別的equals方法
	 * 該方法用來判斷兩個Information實體是否相等
	 * 使用該方法類似:A.equals(B)，傳回布林型
	 * 當Information類別處於Hibernate中一對多關聯性中「多」的一方時需要該方法
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Information other = (Information) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (publishingTime == null) {
			if (other.publishingTime != null)
				return false;
		} else if (!publishingTime.equals(other.publishingTime))
			return false;
		return true;
	}

}
