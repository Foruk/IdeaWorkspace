package Service;

import java.util.ArrayList;

import Entity.NewsCategory;


public interface NewsCategoryService {

	public ArrayList getAllNewsCategory();
	public void update(NewsCategory newsCategory);
	public ArrayList getCategoryLikeName(String name);
	public NewsCategory getCategoryByName(String name);
	public void addCategory(NewsCategory newsCategory);
}
