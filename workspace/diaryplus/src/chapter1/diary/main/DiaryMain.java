package chapter1.diary.main;

import javax.swing.UIManager;
import chapter1.diary.bean.User;
import chapter1.diary.gui.DiaryWindow;
import chapter1.diary.util.DiaryManager;

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
