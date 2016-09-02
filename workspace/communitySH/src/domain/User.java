package domain;

public class User {

	private String id;
	private String userName;
	private String passWord;
	private String realName;
	private String gender;
	private int age;
	
	private String personlSignature;
	
	public String getPersonlSignature() {
		return personlSignature;
	}
	public void setPersonlSignature(String personlSignature) {
		this.personlSignature = personlSignature;
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
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
