package DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import Dao.NewsDao;
import Entity.News;

public class NewsDaoImpl extends HibernateDaoSupport implements NewsDao {

	public void save(News news) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(news);
	}

	public void delete(News news) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(news);
	}

	public void update (News news) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(news);
	}

	public ArrayList getAllNews() {
		// TODO Auto-generated method stub
		return (ArrayList)getHibernateTemplate().find("from News");
	}

	public ArrayList getNewsByNewsid(int newsid) {
		// TODO Auto-generated method stub
		return (ArrayList)getHibernateTemplate().find("from News a where a.newsid=?",new Object[]{newsid});
	}

	public ArrayList getNewsByAccount(String account) {
		// TODO Auto-generated method stub
		return (ArrayList)getHibernateTemplate().find("from News a where a.publisher=?",new Object[]{account});
	}

	public ArrayList getNewsByTitle(String title) {
		// TODO Auto-generated method stub
		return (ArrayList)getHibernateTemplate().find("from News a where a.title like ?",new Object[]{"%"+title+"%"});
	}

	public ArrayList getNewsByPublisher(String Publisher) {
		// TODO Auto-generated method stub
		return (ArrayList)getHibernateTemplate().find("from News a where a.publisher like ?",new Object[]{"%"+Publisher+"%"});
	}

	public ArrayList getNewsByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return (ArrayList)getHibernateTemplate().find("from News a where a.categoryid=?",new Object[]{categoryId});
	}

////	public ArrayList getNewsByCategory(String Category) {
////		// TODO Auto-generated method stub
////		return (ArrayList)getHibernateTemplate().find("from News a where a.catgoryid like ?",new Object[]{Category});
//	}

}
