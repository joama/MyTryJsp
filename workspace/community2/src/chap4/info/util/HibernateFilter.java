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

/*
 * 用於進行Hibernate交易處理的Servlet篩檢程式
 * */
public class HibernateFilter implements Filter{
	private static Log log = LogFactory.getLog(HibernateFilter.class);
	
	/*
	 * 篩檢城市的主要方法
	 * 用於實現Hibernate交易的開始和完成，並設定request編碼
	 * */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException{
		// 設定request編碼
		request.setCharacterEncoding("UTF-8");
		
		// 得到SessionFactory物件的實體
		SessionFactory sf = HibernateUtil.getSessionFactory();
		try{
			log.debug("開始一個資料庫交易");
			// 開始一個新的交易
			sf.getCurrentSession().beginTransaction();
			
			log.debug("Request Path:\t" + ((HttpServletRequest)request).getServletPath());
			
			// 呼叫下一個篩檢程式(繼續處理request)
			chain.doFilter(request, response);
			
			log.debug("提交資料庫交易");
			// 提交交易
			sf.getCurrentSession().getTransaction().commit();
		}catch(Throwable ex){
			ex.printStackTrace();
			try{
				log.debug("拋出例外後試圖恢復資料庫交易");
				// 恢復交易
				sf.getCurrentSession().getTransaction().rollback();
			}catch(Throwable rbEx){
				log.error("恢復交易失敗!", rbEx);
			}
			// 拋出例外
			throw new ServletException(ex);
		}
	}
	/*
	 * 篩檢程式的初始化方法
	 * 可以讀取設定檔案中設定的設定參數
	 * */
	public void init(FilterConfig filterConfig) throws ServletException{}
	
	/*
	 * 篩檢程式的銷毀方法
	 * 用於釋放篩檢程式所申請的資源
	 * */
	public void destory(){}
}
