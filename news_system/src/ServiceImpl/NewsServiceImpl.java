package ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import Dao.NewsDao;
import Entity.News;
import Service.NewsService;

public class NewsServiceImpl implements NewsService {

	private NewsDao newsDao;
	
	public NewsDao getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	public void save(News news) {
		// TODO Auto-generated method stub
		newsDao.save(news);
	}

	public void delete(News news) {
		// TODO Auto-generated method stub
		newsDao.delete(news);
	}

	public void update(News news) {
		// TODO Auto-generated method stub
		newsDao.update(news);
	}

	public ArrayList getAllNews() {
		// TODO Auto-generated method stub
		return newsDao.getAllNews();
	}

	public News getNewsByNewsid(int newsid) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		list=newsDao.getNewsByNewsid(newsid);
		return (News)list.get(0);
	}

	public ArrayList getNewsByAccount(String account) {
		// TODO Auto-generated method stub
		
		return newsDao.getNewsByAccount(account);
	}

	public ArrayList getNewsByTitle(String title) {
		// TODO Auto-generated method stub
		return newsDao.getNewsByTitle(title);
	}

	public ArrayList getNewsByPublisher(String Publisher) {
		// TODO Auto-generated method stub
		return newsDao.getNewsByPublisher(Publisher);
	}

	public ArrayList getNewsByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return newsDao.getNewsByCategoryId(categoryId);
	}

}
