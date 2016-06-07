package chapter1.diary.util;

import java.util.ArrayList;

import chapter1.diary.bean.Diary;

public interface IDiaryManager {
	// 保存日記文件
	// 如果保存成功則返回true, 保存失敗則返回false
	public abstract boolean save(ArrayList<Diary> diaries);

	// 讀取保存的日記文件
	// 如果日記文件存在且讀取成功, 返回日記列表
	// 如果日記文件不存在或讀取失敗，返回空
	public abstract ArrayList<Diary> load();

}
