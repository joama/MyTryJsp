package chp04;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Database {
	
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration = configuration.configure();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Apple apple = new Apple();
		apple.setColor("red");
		apple.setSize(20.0f);
		apple.setWeight(0.5f);
		
		session.save(apple);
		
		Apple apple2 = new Apple();
		apple2.setColor("red");
		apple2.setSize(15.0f);
		apple2.setWeight(0.4f);
		
		session.save(apple2);
		
		String id = apple.getId();
		String id2 = apple2.getId();
		
		Apple newApple = null;
		newApple = (Apple)session.get(Apple.class, id);
		System.out.println("蘋果1的id為:" + newApple.getId()
						+ "'顏色為:" + newApple.getColor()
						+ "'大小為:" + newApple.getSize()
						+ "'重量為:" + newApple.getWeight());
		
		newApple = (Apple)session.get(Apple.class, id2);
		System.out.println("蘋果2的id為:" + newApple.getId()
				+ "'顏色為:" + newApple.getColor()
				+ "'大小為:" + newApple.getSize()
				+ "'重量為:" + newApple.getWeight());
		
		newApple.setColor("green");
		session.update(newApple);
		newApple = (Apple)session.get(Apple.class, id2);
		System.out.println("蘋果2的id為:" + newApple.getId()
					+ "'顏色為:" + newApple.getColor()
					+ "'大小為:" + newApple.getSize()
						+ "'重量為:" + newApple.getWeight());
		
		
		newApple = (Apple)session.get(Apple.class, id);
		session.delete(newApple);
		newApple = (Apple)session.get(Apple.class, id2);
		session.delete(newApple);
		
		transaction.commit();
		
		session.close();
				
	}
}
