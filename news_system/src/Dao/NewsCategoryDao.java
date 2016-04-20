package Dao;

import java.util.ArrayList;

import Entity.NewsCategory;

public interface NewsCategoryDao {

	public ArrayList getAllNewsCategory();
	public void update(NewsCategory newsCategory);
	public ArrayList getCategoryLikeName(String name);
	public ArrayList getCategoryByName(String name);
	public void addCategory(NewsCategory newsCategory);
}
