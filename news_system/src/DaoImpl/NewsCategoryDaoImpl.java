package DaoImpl;

import java.util.ArrayList;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import Dao.NewsCategoryDao;
import Entity.NewsCategory;

public class NewsCategoryDaoImpl extends HibernateDaoSupport implements NewsCategoryDao {

	public ArrayList getAllNewsCategory() {
		// TODO Auto-generated method stub
		return (ArrayList)getHibernateTemplate().find("from NewsCategory");
	}

	public void update(NewsCategory newsCategory) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(newsCategory);
	}

	public ArrayList getCategoryLikeName(String name) {
		// TODO Auto-generated method stub
		return (ArrayList)getHibernateTemplate().find("from NewsCategory a where a.name like ?",new Object[]{"%"+name+"%"});
	}

	public void addCategory(NewsCategory newsCategory) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(newsCategory);
	}

	public ArrayList getCategoryByName(String name) {
		// TODO Auto-generated method stub
		return (ArrayList)getHibernateTemplate().find("from NewsCategory a where a.name =?",new Object[]{name});
	}


}
