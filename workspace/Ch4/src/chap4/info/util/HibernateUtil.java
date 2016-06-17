package chap4.info.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * 基礎的Hibernate輔助類，用於Hibernate的配置和啟動。
 * 通過靜態的初始化代碼來讀取Hibernate啟動參數，並初始化
 * Configuration和SessionFactory對象。
 *
 * @author TigerYuan
 */
public class HibernateUtil 
{
    // 靜態日誌對象的實例，用來輸出日誌信息
    private static Log log = LogFactory.getLog(HibernateUtil.class);

    // 靜態Configuration和SessionFactory對象的實例（全局唯一的）
    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    static 
    {
        // 從缺省的配置文件創建SessionFactory
        try 
        {
        	// 創建Configuration()對象的實例
        	configuration = new Configuration();
            // 讀取hibernate.properties或者hibernate.cfg.xml文件
            configuration.configure();
            // 使用靜態變量來保持SessioFactory對象的實例
            sessionFactory = configuration.buildSessionFactory();
        } 
        catch (Throwable ex) 
        {
            // 輸出異常信息
            log.error("構建SessionFactory失敗", ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    // 返回全局的Configuration對象的實例
    public static Configuration getConfiguration() 
    {
        return configuration;
    }

    // 返回全局的SessionFactory對象的實例
    public static SessionFactory getSessionFactory() 
    {
        SessionFactory sf = sessionFactory;
        if (sf == null)
            throw new IllegalStateException( "SessionFactory不可訪問" );
        return sf;
    }

    // 關閉當前的SessionFactory並且釋放所有的資源
    public static void shutdown() 
    {
        log.debug("Shutting down Hibernate.");
        // 關閉SessionFactory，同時也就關閉了緩存和連接池
        getSessionFactory().close();

        // 清除靜態變量
        configuration = null;
        sessionFactory = null;
    }

    // 提交當前事務，並開始一個新的事務
    public static void commitAndBeginTransaction()
    {
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().beginTransaction();
    }
}
