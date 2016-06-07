package chapter1.diary.bean;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class User {
	private String name;
	private String gender;
	private int age;

	public static void main(String[] args) {
		User user = new User("JavaWeb愛好者","男",20);
		
		ArrayList<Diary> diaries = new ArrayList<Diary>();
		
		for (int i=1;i<4;++i){
			
			String authorName = user.getName();
			
			String title = "第" + i + "篇日記";
			
			String content = "第" + i + "篇日記的內容";
			
			GregorianCalendar time = new GregorianCalendar();
			
			
			Diary diary = new Diary(authorName, content, title, time);
			
			diaries.add(diary);
		}
		
		for (Diary diary : diaries){
			System.out.println("日記作者:" + diary.getAuthorName());
			System.out.println("日記飄題:" + diary.getTitle());
			System.out.println("日記內容:" + diary.getContent());
			
			GregorianCalendar time = diary.getTime();
			int year = time.get(GregorianCalendar.YEAR);
			int month = time.get(GregorianCalendar.MONTH)+1;
			int day = time.get(GregorianCalendar.DATE);
			int hour = time.get(GregorianCalendar.HOUR_OF_DAY);
			int minute = time.get(GregorianCalendar.MINUTE);
			
			System.out.println("日記時間:" + year + "-" + month + "-" + day + " " + hour + ":" + minute);
			System.out.println("***************************************");
		}
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public User() {
		super();
	}

	public User(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
