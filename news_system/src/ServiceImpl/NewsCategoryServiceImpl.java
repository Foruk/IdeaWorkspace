package ServiceImpl;

import java.util.ArrayList;

import Dao.NewsCategoryDao;
import Entity.NewsCategory;
import Service.NewsCategoryService;

public class NewsCategoryServiceImpl implements NewsCategoryService {

	private NewsCategoryDao newsCategoryDao;

	
	public NewsCategoryDao getNewsCategoryDao() {
		return newsCategoryDao;
	}


	public void setNewsCategoryDao(NewsCategoryDao newsCategoryDao) {
		this.newsCategoryDao = newsCategoryDao;
	}


	public ArrayList getAllNewsCategory() {
		// TODO Auto-generated method stub
		return newsCategoryDao.getAllNewsCategory();
	}


	public void update(NewsCategory newsCategory) {
		// TODO Auto-generated method stub
		newsCategoryDao.update(newsCategory);
	}


	public ArrayList getCategoryLikeName(String name) {
		// TODO Auto-generated method stub
		return newsCategoryDao.getCategoryLikeName(name);
	}


	public void addCategory(NewsCategory newsCategory) {
		// TODO Auto-generated method stub
		newsCategoryDao.addCategory(newsCategory);
	}


	public NewsCategory getCategoryByName(String name) {
		// TODO Auto-generated method stub
		ArrayList<NewsCategory> list=newsCategoryDao.getCategoryByName(name);
		if(list.size()==0)
			return null;
		else
			return list.get(0);
	}

}
