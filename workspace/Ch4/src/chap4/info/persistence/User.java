package chap4.info.persistence;

import java.util.Set;

/**
 * @author TigerYuan
 * User類，用來表徵用戶
 */
public class User {
	private String id;						//用戶ID
	private String userName;				//用戶名
	private String password;				//密碼
	private String realName;				//真實姓名
	private Set<Information> informations;	//用戶發布的信息
	
	// 默認構造函數，在使用Hibernate的環境中需要。
	public User() {
	}

	/**
	 * 帶參數的構造函數，用來初始化User類的屬性。
	 * 該參數列表中不包括id，是因為id是由Hibernate來進行初始化的。
	 * id的初始化操作發生在將User對象保存到數據庫之前的瞬間。
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

	/**
	 * 設置id
	 * 之所以不是可視範圍用protected而沒用public，是因為，
	 * id是由Hibernate框架生成，不應該由用戶設置。Hibernate
	 * 框架可以訪問從protected乃至private可視範圍的set方法。
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
	// 獲得用戶發布的信息
	public Set<Information> getInformations() {
		return informations;
	}

	/**
	 * 設置用戶發布的信息
	 * User和Information是一對多的關係——一個用戶可以發表多條信息
	 * 該方法用來設置User和Information關聯（一對多中“一”的一方）
	 * informations是集合（Set）類型，用來容納多條信息
	 */
	public void setInformations(Set<Information> informations) {
		this.informations = informations;
	}

	// 重載Object類的toString方法,將用戶對象轉化為字符串展現	
	public String toString() {
		return "用戶名：" + userName + " " + "，真實姓名：" + realName;
	}
}

