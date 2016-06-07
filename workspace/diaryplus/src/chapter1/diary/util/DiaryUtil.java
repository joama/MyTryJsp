package chapter1.diary.util;

import chapter1.diary.bean.Diary;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class DiaryUtil {

	/**
	 * 　*把java的可序列化的對象(實現Serializable接口)序列化保存到XML文件裡面,如果想一次保存多個可序列化對象請用集合進行封裝
	 * 　*保存時將會用現在的對象原來的XML文件內容 　*@paramobj要序列化的可序列化的對象 　*@paramfileName帶完全的保存路徑的文件名
	 * 　*@throwsFileNotFoundException指定位置的文件不存在 　*@throwsIOException輸出時發生異常 　*@throwsException其他運行時異常
	 * 　
	 */
	public static void diaryToXml(ArrayList<Diary> diaries)
			throws FileNotFoundException, IOException {
		// 創建輸出文件
		File fo = new File("diaries.xml");
		// 文件不存在,就創建該文件
		if (!fo.exists()) {
			// 先創建文件的目錄
			fo.createNewFile();

		}
		// 創建文件輸出流
		FileOutputStream fos = new FileOutputStream(fo);
		// 創建XML文件對象輸出類實例
		XMLEncoder encoder = new XMLEncoder(fos);
		// 對象序列化輸出到XML文件
		encoder.writeObject(diaries);
		encoder.flush();
		// 關閉序列化工具
		encoder.close();
		// 關閉輸出流
		fos.close();
	}

	/**
	 * 　*讀取由objSource指定的XML文件中的序列化保存的對象,返回的結果經過了List封裝 　*@paramobjSource帶全部文件路徑的文件全名
	 * 　*@return由XML文件裡面保存的對象構成的List列表(可能是一個或者多個的序列化保存的對象) 　*@throwsFileNotFoundException指定的對象讀取資源不存在
	 * 　*@throwsIOException讀取發生錯誤 　*@throwsException其他運行時異常發生 　
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Diary> xmlToDiary() throws FileNotFoundException,
			IOException {
		//ArrayList objList = new ArrayList();
		File fin = new File("diaries.xml");
		FileInputStream fis = new FileInputStream(fin);
		XMLDecoder decoder = new XMLDecoder(fis);
		Object obj = null;
		try {
			obj = decoder.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		fis.close();
		decoder.close();
		return (ArrayList<Diary>)obj;
	}

}
