package chapter2.diary.db;

import java.util.ArrayList;

import chapter2.diary.bean.Diary;

public interface IDiaryManager {
	// 得到數據庫中的所有日記
	public ArrayList<Diary> getAllDiaries();
	
	// 存儲一個日記到數據庫中
	public boolean addDiary(Diary diary);
	
	// 刪除數據庫中的一個日記
	public boolean deleteDiary(int id);
	
	// 更新數據庫中的一個日記
	public boolean updateDiary(Diary diary);
}
