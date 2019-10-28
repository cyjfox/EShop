package pri.cyjfox.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import pri.cyjfox.pojo.UserInfo;

@Repository
public class UserDAO {
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	private Transaction transaction = null;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



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
