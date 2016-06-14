package chp04;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DataBase {

	public static void main(String[] args) {

		Configuration cf = new Configuration();

		cf = cf.configure();
		SessionFactory factory = cf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		// 得到第一個蘋果，並保存
		Apple apple = new Apple();
		apple.setId("Apple1");
		apple.setColor("紅色");
		apple.setSize(1.23f);
		apple.setWeight(5.0f);

		session.save(apple);

		// 得到第二個蘋果，並保存
		Apple apple2 = new Apple();
		apple2.setId("Apple2");
		apple2.setColor("黃色");
		apple2.setSize(1.23f);
		apple2.setWeight(5.0f);

		session.save(apple2);

		String sid = apple.getId();
		String sid2 = apple2.getId();

		Apple show = new Apple();
		Apple show1 = new Apple();

		show = (Apple) session.get(Apple.class, sid);
		show1 = (Apple) session.get(Apple.class, sid2);

		System.out.println("蘋果1的id為：" + show.getId() + "\t蘋果1的顏色為："
				+ show.getColor() + "\t蘋果1的大小為：" + show.getSize()
				+ "\t蘋果1的重量為:" + show.getWeight());
		System.out.println("蘋果2的id為：" + show1.getId() + "\t蘋果2的顏色為："
				+ show1.getColor() + "\t蘋果2的大小為：" + show1.getSize()
				+ "\t蘋果2的重量為:" + show1.getWeight());

		show.setColor("綠色");
		session.update(show);
		System.out.println("蘋果1的id為：" + show.getId() + "\t蘋果1的顏色為："
				+ show.getColor() + "\t蘋果1的大小為：" + show.getSize()
				+ "\t蘋果1的重量為:" + show.getWeight());

		session.delete(show1);
		System.out.println("刪除成功!");
		t.commit();
		session.close();

	}
}
