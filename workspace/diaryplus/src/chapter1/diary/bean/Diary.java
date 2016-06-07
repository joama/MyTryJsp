package chapter1.diary.bean;

import java.util.GregorianCalendar;

public class Diary {

	private String title;
	private String content;
	private GregorianCalendar time;
	private String authorName;

	public Diary() {
		super();
	}

	public Diary(String title, String content, GregorianCalendar time,
			String authorName) {

		super();
		this.title = title;
		this.content = content;
		this.time = time;
		this.authorName = authorName;
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

	public GregorianCalendar getTime() {
		return time;
	}

	public void setTime(GregorianCalendar time) {
		this.time = time;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
