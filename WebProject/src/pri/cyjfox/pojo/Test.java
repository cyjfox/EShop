package pri.cyjfox.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args)
    {
        UserInfo user = new UserInfo();
	    user.setUserName("cyjfox");
	    user.setUserEmail("cyjfox@hotmail.com");
        
        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        
        //提交事物
        transaction.commit();
        
        session.close();
        sessionFactory.close();
    }
}
