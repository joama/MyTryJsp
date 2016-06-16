package chap4.info.util;

import org.apache.commons.logging.Log;
import org.apache.commons.loggin.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * 基本的Hibernate輔助類別，用於Hibernate的設定和啟動。
 * 透過靜態的初始化程式碼來讀取Hibernate啟動參數，並初始化Configuration和SessionFactory對象。
 * */
public class HibernateUtil {
	// 靜態日誌物件的實體，用來輸出日誌資訊
	private static org.infinispan.util.logging.Log log = LogFactory.getLog(HibernateUtil.class);
	
	// 靜態Configuration和SessionFactory物件的實體(全域為一的)
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	
	static{
		// 從預設的設定檔案建立SessionFactory
		try{
			// 建立Configuration()物件的實體
			configuration = new Configuration();
			// 讀取hibernate.properties或者hibernate.cfg.xml檔案
			configuration.configure();
			// 使用靜態變數來保持SessionFactory物件的實體
			sessionFactory = configuration.buildSessionFactory();
		}catch(Throwable ex){
			// 輸出例外資訊
			log.error("建立SessionFactory失敗", ex);
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	// 傳回全域的Configuration物件的實體
	public static Configuration getConfiguration(){
		return configuration;
	}
	
	// 傳回全域的SessionFactory物件的實體
	public static SessionFactory getSessionFactory(){
		SessionFactory sf = sessionFactory;
		if(sf == null)
			throw new IllegalStateException("SessionFactory不可呼叫");
		return sf;
	}

	// 關閉目前的SessionFactory並且釋放所有的資源
	public static void shutdown(){
		log.debug("Shutting down Hibernate.");
		// 關閉SessoinFactory，同時也就關閉了緩衝儲存和連接池
		getSessionFactory().close();
		
		// 清除靜態變數
		configuration = null;
		sessoinFactory = null;
	}
	
	// 提交目前交易，並開始一個新的交易
	public static void commitAndBeginTransaction(){
		sessionFactory.getCurrentSession().getTransaction().commit();
		sessionFactory.getCurrentSession().beginTransaction();
	}
}
