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
 * �Ω�i��Hibernate����B�z��Servlet�z�˵{��
 * */
public class HibernateFilter implements Filter{
	private static Log log = LogFactory.getLog(HibernateFilter.class);
	
	/*
	 * �z�˫������D�n��k
	 * �Ω��{Hibernate������}�l�M�����A�ó]�wrequest�s�X
	 * */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException{
		// �]�wrequest�s�X
		request.setCharacterEncoding("UTF-8");
		
		// �o��SessionFactory���󪺹���
		SessionFactory sf = HibernateUtil.getSessionFactory();
		try{
			log.debug("�}�l�@�Ӹ�Ʈw���");
			// �}�l�@�ӷs�����
			sf.getCurrentSession().beginTransaction();
			
			log.debug("Request Path:\t" + ((HttpServletRequest)request).getServletPath());
			
			// �I�s�U�@�ӿz�˵{��(�~��B�zrequest)
			chain.doFilter(request, response);
			
			log.debug("�����Ʈw���");
			// ������
			sf.getCurrentSession().getTransaction().commit();
		}catch(Throwable ex){
			ex.printStackTrace();
			try{
				log.debug("�ߥX�ҥ~��չϫ�_��Ʈw���");
				// ��_���
				sf.getCurrentSession().getTransaction().rollback();
			}catch(Throwable rbEx){
				log.error("��_�������!", rbEx);
			}
			// �ߥX�ҥ~
			throw new ServletException(ex);
		}
	}
	/*
	 * �z�˵{������l�Ƥ�k
	 * �i�HŪ���]�w�ɮפ��]�w���]�w�Ѽ�
	 * */
	public void init(FilterConfig filterConfig) throws ServletException{}
	
	/*
	 * �z�˵{�����P����k
	 * �Ω�����z�˵{���ҥӽЪ��귽
	 * */
	public void destory(){}
}
