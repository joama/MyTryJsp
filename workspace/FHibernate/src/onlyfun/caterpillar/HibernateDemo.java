package onlyfun.caterpillar;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateDemo {
	public static void main(String[] args) {
        User user = new User(); 
        user.setName("caterpillar"); 
        user.setAge(new Long(30)); 

        // �}��Session�A�۷��}��JDBC��Connection
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        // Transaction��ܤ@�շ|�ܾާ@
        Transaction tx= session.beginTransaction(); 
        // �N����M�g�ܸ�Ʈw��椤�x�s
        session.save(user);
        tx.commit(); 
        session.close(); 
        
        System.out.println("�s�W���OK!�Х���MySQL�[�ݵ��G�I");
        
        HibernateUtil.shutdown();
    }
}
