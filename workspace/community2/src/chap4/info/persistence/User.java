package chap4.info.persistence;

import java.util.Set;

// User類別，用來表示使用者

public class User {
	private String id;                     // 使用者ID
	private String userName;               // 使用者名稱
	private String password;               // 密碼
	private String realName;               // 真實姓名
	private Set<Information> informations; // 使用者發布的資訊
	
	// 預設建構式，在使用Hibernate的環境中需要
	public User(){
	}
	
	/*
	 * 帶參數的建構式，用來初始化User類別的屬性。 
	 * 該參數列表中不包括id，因為id是由Hibernate來進行初始化的。
	 * id的初始化操作發生在將User物件儲存到資料庫之前的瞬間。
	 */
	
	public User(String userName, String password, String realName) {
		this.userName = userName;
		this.password = password;
		this.realName = realName;
	}

	// 獲得id
	public String getId() {
		return id;
	}

	/*
	 * 設定id 
	 * 之所以不是public而用protected，因為
	 * id是由Hibernate框架產生的，不應該由使用者設定。
	 * Hibernate框架可以執行從protected乃至private權限的所有set方法。
	 */
	protected void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	// 獲得使用者發布的資訊
	public Set<Information> getInformations() {
		return informations;
	}

	/*
	 * 設定使用者發布訊息
	 * User和Information是一對多的關係-- 一個使用者可以發表多條資訊
	 * 該方法用來設定User和Information關聯(一對多中「 一」的一方)
	 * informations是集合(Set)類型，用來容納多條資訊
	 */
	public void setInformations(Set<Information> informations) {
		this.informations = informations;
	}
	
	// 重載Object類別的toString方法，將使用者物件轉化為字串展現
	public String toString(){
		return "使用者名稱:" + userName + " " + "，真實姓名:" + realName;
	}
}
