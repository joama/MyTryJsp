package chapter1.diary.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import chapter1.diary.bean.Diary;

public class DiaryManager implements IDiaryManager {

	public static void main(String args[]) {
		DiaryManager d = new DiaryManager();
		d.load();
	}

	@Override
	public ArrayList<Diary> load() {
		ArrayList<Diary> diaries = null;

		try {
			diaries = DiaryUtil.xmlToDiary();
			System.out.println("數量" + diaries.size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return diaries;
	}

	@Override
	public boolean save(ArrayList<Diary> diaries) {

		try {
			DiaryUtil.diaryToXml(diaries);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
