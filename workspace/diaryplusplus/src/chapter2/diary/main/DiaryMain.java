package chapter2.diary.main;

import javax.swing.UIManager;
import chapter2.diary.bean.User;
import chapter2.diary.gui.DiaryWindow;
import chapter2.diary.db.DiaryManager;

;
public class DiaryMain {

	public static void main(String[] args) {
		try {

			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		User user = new User("JavaWeb愛好者", "男", 20);
		DiaryManager diarymanager = new DiaryManager();
		DiaryWindow diaryWindow = new DiaryWindow(user, diarymanager);

		diaryWindow.setVisible(true);

	}
}
