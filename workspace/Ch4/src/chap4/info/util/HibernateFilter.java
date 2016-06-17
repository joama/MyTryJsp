package chap4.info.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

/**
 * 用於進行Hibernate事務處理的Servlet過濾器
 * @author TigerYuan
 */
public class HibernateFilter implements Filter {

    private static Log log = LogFactory.getLog(HibernateFilter.class);

    /**
     * 過濾器的主要方法
     * 用於實現Hibernate事務的開始和提交，並設置request編碼
     */
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)throws IOException, ServletException 
    {
    	// 設置request編碼
    	request.setCharacterEncoding("GBK");
    	
    	// 得到SessionFactory對象的實例
    	SessionFactory sf = HibernateUtil.getSessionFactory();
        try 
        {
            log.debug("開始一個數據庫事務");
            // 開始一個新的事務
            sf.getCurrentSession().beginTransaction();

            log.debug( "Request Path:\t" +((HttpServletRequest)request).getServletPath() );
            // 調用下一個過濾器 (繼續處理request)
            chain.doFilter(request, response);
            
            log.debug("提交數據庫事務");
            // 提交事務
            sf.getCurrentSession().getTransaction().commit();
        } 
        catch (Throwable ex) 
        {
        	ex.printStackTrace();
            try 
            {            	
                log.debug("拋出異常後試圖回滾數據庫事務");
                // 回滾事務
                sf.getCurrentSession().getTransaction().rollback();
            } 
            catch (Throwable rbEx) 
            {
                log.error("回滾拋出異常後的事務失敗!", rbEx);
            }

            // 拋出異常
            throw new ServletException(ex);
        }
    }

    /**
     * 過濾器的初始化方法
     * 可以讀取配置文件中設置的配置參數
     */
    public void init(FilterConfig filterConfig) throws ServletException {
    	
    	
    }

    /**
     * 過濾器的銷毀方法
     * 用於釋放過濾器所申請的資源
     */
    public void destroy() {
    	
    }
    
    
}

