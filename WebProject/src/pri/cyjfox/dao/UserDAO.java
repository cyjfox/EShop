package pri.cyjfox.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import pri.cyjfox.pojo.UserInfo;

public class UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Transaction transaction = null;
	
	public int addUser(UserInfo user)
	{
		int id = -1;
		Session session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		id = (int)session.save(user);
		
		transaction.commit();
		session.close();
		
		return id;
	}
	
}
