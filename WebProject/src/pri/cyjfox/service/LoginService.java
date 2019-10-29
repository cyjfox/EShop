package pri.cyjfox.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.apache.struts2.ServletActionContext;
import pri.cyjfox.pojo.UserInfo;

@Service("loginService")
public class LoginService {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * userPasswordÎªMD5ÃÜÂë´®
	 * @param userName
	 * @param userPassword
	 * @return
	 */
	public UserInfo userLogin(String userName, String userPassword)
	{
		UserInfo user = null;
		Session session = sessionFactory.openSession();
		
		String sql = "select * from user_info where user_name = '" + userName + "' and user_password = '" + userPassword + "'";
		Query<Object[]> query = (Query<Object[]>)session.createSQLQuery(sql);
		List<Object[]> resultList = query.getResultList();
		if (resultList.isEmpty())
		{
			user = null;
		}
		else
		{
			user = new UserInfo();
			user.setUserId((Integer)resultList.get(0)[0]);
			user.setUserName((String)resultList.get(0)[1]);
			user.setUserEmail((String)resultList.get(0)[2]);
			
			System.out.println(user);
			
			
		}
		return user;
	}
	

	public String testUserLogin()
	{
		String result = null;
		UserInfo user = this.userLogin("ssss", "ssssPassword");
		
		if (user == null)
		{
			result = "user_not_exist";
		}
		else
		{
			HttpSession httpSession = ServletActionContext.getRequest().getSession();
			httpSession.setAttribute("user_info", user);
			
			result = "success";
		}
		
		return result;
	}
}
