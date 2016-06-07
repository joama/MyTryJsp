package chapter1.diary.main;

import javax.swing.UIManager;

import chapter1.diary.bean.User;
import chapter1.diary.gui.DiaryWindow;

public class DiaryMain {
	public static void main(String[] args) {
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		
		User user = new User("JavaWeb �R�n��", "�k" , 20);
		
		DiaryWindow diaryWindow = new DiaryWindow(user);
		diaryWindow.setVisible(true);
	}

}
