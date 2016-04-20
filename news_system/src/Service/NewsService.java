package Service;

import java.util.ArrayList;
import java.util.List;

import Entity.News;

public interface NewsService {
	public void save(News news);
	public void delete(News news);
	public void update(News news);
	public ArrayList getAllNews();
	public News getNewsByNewsid(int newsid);
	public ArrayList getNewsByAccount(String account); 
	public ArrayList getNewsByTitle(String title);
	public ArrayList getNewsByPublisher(String Publisher);
	public ArrayList getNewsByCategoryId(int categoryId);
}
