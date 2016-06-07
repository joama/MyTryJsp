package chapter1.diary.bean;

import java.util.GregorianCalendar;

public class Diary {
	private String title;
	private String content;
	private String authorName;
	private GregorianCalendar time;
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
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public GregorianCalendar getTime() {
		return time;
	}
	public void setTime(GregorianCalendar time) {
		this.time = time;
	}
	public Diary() {
		super();
	}
	public Diary(String title, String content, String authorName, GregorianCalendar time) {
		super();
		this.title = title;
		this.content = content;
		this.authorName = authorName;
		this.time = time;
	}
}
