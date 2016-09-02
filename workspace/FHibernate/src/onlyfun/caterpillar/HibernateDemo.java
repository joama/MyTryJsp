package onlyfun.caterpillar;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateDemo {
	public static void main(String[] args) {
        User user = new User(); 
        user.setName("caterpillar"); 
        user.setAge(new Long(30)); 

        // 開啟Session，相當於開啟JDBC的Connection
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        // Transaction表示一組會話操作
        Transaction tx= session.beginTransaction(); 
        // 將物件映射至資料庫表格中儲存
        session.save(user);
        tx.commit(); 
        session.close(); 
        
        System.out.println("新增資料OK!請先用MySQL觀看結果！");
        
        HibernateUtil.shutdown();
    }
}
