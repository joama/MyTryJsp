package chap4.info.persistence;

import java.util.Date;

/**
 * @author TigerYuan
 * Information類，用來表徵信息
 */
public class Information {
	private String id;				//信息ID
	private String title;			//標題
    private String content;			//內容
	private Date publishingTime;	//發布時間
	private User publishingUser;	//發布者	
	
	
	public Information() {
		
	}

	public Information(String title, String content, 
			Date publishingTime, User publishingUser) {
		this.content = content;
		this.publishingTime = publishingTime;
		this.publishingUser = publishingUser;
		this.title = title;
	}

	// 獲得id
	public String getId() {
		return id;
	}

	protected void setId(String id) {
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

	
	
	// 獲得信息的發布者
	public User getPublishingUser() {
		return publishingUser;
	}

	/**
	 * 設置信息的發布者
	 * User和Information是一對多的關係——一個用戶可以發表多條信息
	 * 該方法用來設置User和Information關聯（一對多中“多”的一方）
	 */
	public void setPublishingUser(User publishingUser) {
		this.publishingUser = publishingUser;
	}

	// 重載Object類的toString方法,將信息對象轉化為字符串展現
	public String toString()
	{
		return "標題：" + title + " " + "，發布時間：" + publishingTime;
	}

	/**
	 * 重載Object類的hashCode方法
	 * 該方法用來生成Information實例的哈希碼（hashCode）
	 * 當Information類處於Hibernate中一對多關係中多的一方時需要該方法
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + 
			((publishingTime == null) ? 0 : publishingTime.hashCode());
		return result;
	}

	/**
	 * 重載Object類的equals方法
	 * 該方法用來判斷兩個Information實例是否相等
	 * 使用方法類似：A.equals(B)，返回布爾型
	 * 當Information類處於Hibernate中一對多關係中多的一方時需要該方法
	 */
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

