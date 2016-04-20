package DaoImpl;

import java.util.ArrayList;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import Dao.UserDao;
import Entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	
	public void save(User user) {
		getHibernateTemplate().save(user);
	}

	
	public ArrayList loginvail(String account, String password) {
		return(ArrayList)getHibernateTemplate().find("from User a where a.account=? and a.password=?",new Object[]{account,password});
	}


	public void delete(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(user);
	}


	public void update(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(user);
	}


	public ArrayList getUserByAccount(String account) {
		// TODO Auto-generated method stub
		return (ArrayList)getHibernateTemplate().find("from User a where a.account=?",new Object[]{account});
	}


	public ArrayList getAllUser() {
		// TODO Auto-generated method stub
		return (ArrayList)getHibernateTemplate().find("from User a where a.account!=?",new Object[]{"admin"});
	}


	public ArrayList getUserById(int userid) {
		// TODO Auto-generated method stub
		return (ArrayList)getHibernateTemplate().find("from User a where a.userid=?",new Object[]{userid});
	}

	public ArrayList getUserLikeNickName(String nickname) {
		// TODO Auto-generated method stub
		return (ArrayList)getHibernateTemplate().find("from User a where a.nickname like ?",new Object[]{"%"+nickname+"%"});
	}


	public ArrayList getUserLikeAccount(String account) {
		// TODO Auto-generated method stub
		return (ArrayList)getHibernateTemplate().find("from User a where a.account like ?",new Object[]{"%"+account+"%"});
	}

}
