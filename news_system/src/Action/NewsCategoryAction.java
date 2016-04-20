package Action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import PagerUtil.Pager;
import PagerUtil.PagerService;
import Service.NewsCategoryService;

import Entity.News;
import Entity.NewsCategory;

public class NewsCategoryAction {

	//实体属性
	private int categoryid;
	private String name;
	
	private NewsCategory newsCategory;
	private ArrayList categoryList;
	private NewsCategoryService newsCategoryService;
	/**
	 * 分页参数
	 */
	private PagerService pagerService;
	private Pager pager;
	private String currentPage;
	private int totalPages;
	private int totalRows;
	private String pagerMethod;
	private int pagesize=3;
	
	//获得搜索的条件
	private String search;
	private String searchtext;
	
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getSearchtext() {
		return searchtext;
	}
	public void setSearchtext(String searchtext) {
		this.searchtext = searchtext;
	}
	public NewsCategory getNewsCategory() {
		return newsCategory;
	}
	public void setNewsCategory(NewsCategory newsCategory) {
		this.newsCategory = newsCategory;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(ArrayList categoryList) {
		this.categoryList = categoryList;
	}
	public PagerService getPagerService() {
		return pagerService;
	}
	public void setPagerService(PagerService pagerService) {
		this.pagerService = pagerService;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public String getPagerMethod() {
		return pagerMethod;
	}
	public void setPagerMethod(String pagerMethod) {
		this.pagerMethod = pagerMethod;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	
	public NewsCategoryService getNewsCategoryService() {
		return newsCategoryService;
	}
	public void setNewsCategoryService(NewsCategoryService newsCategoryService) {
		this.newsCategoryService = newsCategoryService;
	}
	public String getAllCategory()
	{
		ArrayList list=newsCategoryService.getAllNewsCategory();
		pagefunc(list);
		return "success";
	}
	public String AllCategory()
	{
		categoryList=newsCategoryService.getAllNewsCategory();
		return "success";
	}
	public String update() throws UnsupportedEncodingException
	{
		//地址栏传递了中文
		name=new String(name.getBytes("ISO-8859-1"),"utf-8");
		newsCategory=new NewsCategory();
//		System.out.println(categoryid);
//		System.out.println(name);
//		System.out.println(newsCategory);
		newsCategory.setCategoryid(categoryid);
		newsCategory.setName(name);
		newsCategoryService.update(newsCategory);
		return "success";
	}
	
	public String add() throws UnsupportedEncodingException
	{
		name=new String(name.getBytes("ISO-8859-1"),"utf-8");
		newsCategory=new NewsCategory();
		newsCategory.setName(name);
		return "success";
	}
	
	public String search()
	{
		ArrayList list=newsCategoryService.getCategoryLikeName(searchtext);
		pagefunc(list);
		return "success";
	}
	public void pagefunc(ArrayList list)
	{
		categoryList=new ArrayList<NewsCategory>();	//每次都要重新分配
		totalRows=list.size();
		pagerService=new PagerService();
		pager=pagerService.getPager(currentPage, pagerMethod, totalRows, pagesize);
		currentPage=String.valueOf(pager.getCurrentPage());
		totalRows=pager.getTotalRows();
		totalPages=pager.getTotalPages();
		//System.out.println(currentPage);
		for(int i=pager.getStartRow();i<pager.getTotalRows()&&i<pager.getStartRow()+pager.getPageSize();i++)
	    {
			categoryList.add((NewsCategory)list.get(i));
	    }	
	}
}
