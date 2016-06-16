package chap4.info.util;

import org.apache.commons.logging.Log;
import org.apache.commons.loggin.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * �򥻪�Hibernate���U���O�A�Ω�Hibernate���]�w�M�ҰʡC
 * �z�L�R�A����l�Ƶ{���X��Ū��Hibernate�ҰʰѼơA�ê�l��Configuration�MSessionFactory��H�C
 * */
public class HibernateUtil {
	// �R�A��x���󪺹���A�Ψӿ�X��x��T
	private static org.infinispan.util.logging.Log log = LogFactory.getLog(HibernateUtil.class);
	
	// �R�AConfiguration�MSessionFactory���󪺹���(���쬰�@��)
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	
	static{
		// �q�w�]���]�w�ɮ׫إ�SessionFactory
		try{
			// �إ�Configuration()���󪺹���
			configuration = new Configuration();
			// Ū��hibernate.properties�Ϊ�hibernate.cfg.xml�ɮ�
			configuration.configure();
			// �ϥ��R�A�ܼƨӫO��SessionFactory���󪺹���
			sessionFactory = configuration.buildSessionFactory();
		}catch(Throwable ex){
			// ��X�ҥ~��T
			log.error("�إ�SessionFactory����", ex);
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	// �Ǧ^���쪺Configuration���󪺹���
	public static Configuration getConfiguration(){
		return configuration;
	}
	
	// �Ǧ^���쪺SessionFactory���󪺹���
	public static SessionFactory getSessionFactory(){
		SessionFactory sf = sessionFactory;
		if(sf == null)
			throw new IllegalStateException("SessionFactory���i�I�s");
		return sf;
	}

	// �����ثe��SessionFactory�åB����Ҧ����귽
	public static void shutdown(){
		log.debug("Shutting down Hibernate.");
		// ����SessoinFactory�A�P�ɤ]�N�����F�w���x�s�M�s����
		getSessionFactory().close();
		
		// �M���R�A�ܼ�
		configuration = null;
		sessoinFactory = null;
	}
	
	// ����ثe����A�ö}�l�@�ӷs�����
	public static void commitAndBeginTransaction(){
		sessionFactory.getCurrentSession().getTransaction().commit();
		sessionFactory.getCurrentSession().beginTransaction();
	}
}
