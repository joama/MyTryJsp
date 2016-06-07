package domain;

public class User {
	
	private String id;
	
	private String userName;
	
	private String password;
	
	private String realName;
	
	private String gender;
	
	private Integer age;
	
	private String personalSignature;

	
	public User(){
		
	}
	
	
	public User(String id, String userName, String password, String realName, String gender, Integer age,
			String personalSignature) {
		this.age = age;
		this.gender = gender;
		this.password = password;
		this.personalSignature = personalSignature;
		this.realName = realName;
		this.userName = userName;
	
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
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


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String getPersonalSignature() {
		return personalSignature;
	}


	public void setPersonalSignature(String personalSignature) {
		this.personalSignature = personalSignature;
	}
	
	
	
	
}
