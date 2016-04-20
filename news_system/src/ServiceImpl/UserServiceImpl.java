package ServiceImpl;

import java.util.ArrayList;

import Dao.UserDao;
import Entity.User;
import Service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	
	public User loginvail(String account, String password) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		list=userDao.loginvail(account, password);
		if(list.size()>0)
			return (User) list.get(0);
		else
			return null;
	}

	public void delete(User user) {
		// TODO Auto-generated method stub
		userDao.delete(user);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	public User getUserByAccount(String account) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		list=userDao.getUserByAccount(account);
		if(list.size()==0)
			return null;
		else
			return (User)list.get(0);
	}

	public ArrayList getAllUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}

	public User getUserById(String userid) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		list=userDao.getUserById(Integer.parseInt(userid));
		if(list.size()==0)
			return null;
		else
			return (User)list.get(0);	
	}

	public ArrayList getUserLikeAccount(String account) {
		// TODO Auto-generated method stub
		return userDao.getUserByAccount(account);
	}

	public ArrayList getUserLikeNickName(String nickname) {
		// TODO Auto-generated method stub
		return userDao.getUserLikeNickName(nickname);
	}



}
