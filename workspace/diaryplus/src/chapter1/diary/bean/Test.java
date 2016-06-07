package chapter1.diary.bean;

import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Test {
	
	public static void main(String[] args) {
		
		// 用帶參數的構造函數創建一個User類的對象
		User user = new User("java愛好者","男",20);
		
		// 創建一個ArrayList，用於容納Diary
		ArrayList<Diary> diaries = new ArrayList<Diary>();
		
		for(int i=1;i<4;i++){
			// 作者姓名
			String authorName = user.getName();
			// 日記標題
			String title = "第" + i + "篇日記";
			// 日記內容
			String content = "第" + i + "篇日記的內容";
			// 日記時間
			GregorianCalendar time = new GregorianCalendar();

			// 創建一個日記
			Diary diary = new Diary(authorName, content, time, title);
			// 將日記放入diaries中
			diaries.add(diary);

		}
		
		// 依次輸出diaries中所有日記的信息
		for (Diary diary : diaries) {
			System.out.println("日記作者:" + diary.getAuthorName());
			System.out.println("日記標題:" + diary.getTitle());
			System.out.println("日記內容:" + diary.getContent());

			// 得到創建日記時間的年、月、日、時、分
			GregorianCalendar time = diary.getTime();
			int year = time.get(GregorianCalendar.YEAR);
			int month = time.get(GregorianCalendar.MONTH)+1;
			int day = time.get(GregorianCalendar.DATE);
			int hour = time.get(GregorianCalendar.HOUR_OF_DAY);
			int minute = time.get(GregorianCalendar.MINUTE);

			System.out.println("日記時間:" + year + "-" + month + "-" + day + " " + hour + ":" + minute);
			System.out.println("****************************");
	}

	}
}
