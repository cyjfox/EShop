package pri.cyjfox.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import pri.cyjfox.dao.UserDAO;
import pri.cyjfox.pojo.UserInfo;


public class UserAction {
	private String userName;
	private String userEmail;
	
	@Autowired
	private UserDAO userDao;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	public String addUser2(HttpSession session, String userName, String userEmail)
	{
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(userName);
		userInfo.setUserEmail(userEmail);
		
		System.out.println(userInfo);
		
		UserDAO	userDao = new UserDAO();
		int userId = userDao.addUser(userInfo);
		userInfo.setUserId(userId);
		
		session.setAttribute("user_info", userInfo);
		return "success";
	}
	
	public String addUser()
	{
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(this.userName);
		userInfo.setUserEmail(this.userEmail);
		
		System.out.println(userInfo);
		
		//UserDAO	userDao = new UserDAO();
		int userId = userDao.addUser(userInfo);
		userInfo.setUserId(userId);
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user_info", userInfo);
		return "success";
	}

	public String addUser1234()
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserInfo user = new UserInfo();
		user.setUserId(123);
		user.setUserName("ppp");
		user.setUserEmail("ggggg");
		session.setAttribute("user_info", user);
		return "success";
	}
	
	public String addUser1111()
	{
		return "error";
	}
}
