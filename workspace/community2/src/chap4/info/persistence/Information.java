package chap4.info.persistence;

import java.util.Date;

// Information���O�A�ΨӥN���T
public class Information {
	private String id;            // ��TID
	private String title;         // ���D
	private String content;       // ���e
	private Date publishingTime;  // �o���ɶ�
	private User publishingUser;  // �o����
	
	public Information(){		
	}
	
	public Information(String title, String content, Date publishingTime, User publishingUser) {
		this.title = title;
		this.content = content;
		this.publishingTime = publishingTime;
		this.publishingUser = publishingUser;
	}
	
	// ��oid
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
	
	// ��o�o���̸�T
	public User getPublishingUser() {
		return publishingUser;
	}
	
	/*
	 * �]�w�o���̪���T 
	 * User�MInformation�O�@��h�����Y-- �@�ӨϥΪ̥i�H�o��h����T
	 * �Ӥ�k�Ψӳ]�wUser�MInformation���p(�@��h���u�h�v���@��)
	 */
	public void setPublishingUser(User publishingUser) {
		this.publishingUser = publishingUser;
	}

	// ����Object���O��toString��k�A�N��T������Ƭ��r��i�{
	@Override
	public String toString() {
		return "���D:" + title + "�A�o���ɶ�:" + publishingTime;
	}

	/*
	 * ����Object���O��hashCode��k
	 * �Ӥ�k�ΨӲ���Information���骺����X(hashcode)
	 * ��Information���O�B��Hibernate���@��h���p�ʤ��u�h�v���@��ɻݭn�Ӥ�k
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
	 * ����Object���O��equals��k
	 * �Ӥ�k�ΨӧP�_���Information����O�_�۵�
	 * �ϥθӤ�k����:A.equals(B)�A�Ǧ^���L��
	 * ��Information���O�B��Hibernate���@��h���p�ʤ��u�h�v���@��ɻݭn�Ӥ�k
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
