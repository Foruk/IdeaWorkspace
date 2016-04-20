package Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import CompressorUtil.ZipCompressorByAnt;
import Entity.News;
import Entity.NewsCategory;
import FileUtil.DelFile;
import PagerUtil.Pager;
import PagerUtil.PagerService;
import Service.NewsService;
import ServiceImpl.NewsCategoryServiceImpl;

public class NewsAction {
	private News news;
	private ArrayList<News> newsList;
	private NewsService newsService;

	// �û��������ʱ����������
	private List<NewsCategory> categoryList;
	private NewsCategoryServiceImpl newsCategoryService;
	private String categoryname;

	// ����id �����ڻ�ȡ��������
	private int newsid;
	private String title;
	private String maincontent;

	// �������������
	private String search;
	private String searchtext;

	/**
	 * �ļ��ϴ�����
	 */
	private static final int BUFFER_SIZE = 1000*1024;
	private List<File> photo;
	private List<String> photoFileName;
	private List<File> video;
	private List<String> videoFileName;
	private List<File> enclosure;
	private List<String> enclosureFileName;

	
	/**
	 * �ļ�����
	 */
	private String enclosureName;
	private InputStream inStream;
	/**
	 * ��ҳ����
	 */
	private PagerService pagerService;
	private Pager pager;
	private String currentPage;
	private int totalPages;
	private int totalRows;
	private String pagerMethod;
	private int pagesize = 3;

	

	public String getEnclosureName() {
		return enclosureName;
	}

	public void setEnclosureName(String enclosureName) {
		this.enclosureName = enclosureName;
	}

	public List<File> getEnclosure() {
		return enclosure;
	}

	public void setEnclosure(List<File> enclosure) {
		this.enclosure = enclosure;
	}

	public List<String> getEnclosureFileName() {
		return enclosureFileName;
	}

	public void setEnclosureFileName(List<String> enclosureFileName) {
		this.enclosureFileName = enclosureFileName;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public List<File> getVideo() {
		return video;
	}

	public void setVideo(List<File> video) {
		this.video = video;
	}

	public List<String> getVideoFileName() {
		return videoFileName;
	}

	public void setVideoFileName(List<String> videoFileName) {
		this.videoFileName = videoFileName;
	}

	public List<NewsCategory> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<NewsCategory> categoryList) {
		this.categoryList = categoryList;
	}

	public NewsCategoryServiceImpl getNewsCategoryService() {
		return newsCategoryService;
	}

	public void setNewsCategoryService(
			NewsCategoryServiceImpl newsCategoryService) {
		this.newsCategoryService = newsCategoryService;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMaincontent() {
		return maincontent;
	}

	public void setMaincontent(String maincontent) {
		this.maincontent = maincontent;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
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

	public List<File> getPhoto() {
		return photo;
	}

	public void setPhoto(List<File> photo) {
		this.photo = photo;
	}

	public List<String> getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(List<String> photoFileName) {
		this.photoFileName = photoFileName;
	}

	public static int getBufferSize() {
		return BUFFER_SIZE;
	}

	public int getNewsid() {
		return newsid;
	}

	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public ArrayList<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(ArrayList<News> newsList) {
		this.newsList = newsList;
	}

	public String saveNews() {
		if (photo != null) {
			String filePath=ServletActionContext.getServletContext().getRealPath("/newsImages");
			String fileName=uploadfunc(filePath,photoFileName.get(0),photo.get(0));
			news.setImage(fileName); // ���ϴ��ļ�·��������������
		}
		if (video != null) {
			String filePath=ServletActionContext.getServletContext()
					.getRealPath("/newsVideo");
			String fileName =uploadfunc(filePath,videoFileName.get(0),video.get(0));
			news.setVideo(fileName); // ���ϴ��ļ�·��������������
//			ZipCompressorByAnt zcba = new ZipCompressorByAnt(fileName + ".zip");
//			 copy(video,newfile);
//			zcba.compress(saveFile);
//			DelFile.DeleteFolder(saveFile.getPath());		
		}
		if(enclosure!=null)
		{
			String filePath=ServletActionContext.getServletContext()
					.getRealPath("/newsEnclosure");
			String fileName =uploadfunc(filePath,enclosureFileName.get(0),enclosure.get(0));
			news.setEnclosure(fileName); // ���ϴ��ļ�·��������������
		}
		// ���ݻ�õ����������ѯ������id
		NewsCategory temp1 = newsCategoryService
				.getCategoryByName(categoryname);
		System.out.println("temp:" + temp1 + "\ncategoryName:"
				+ categoryname + "\nnewsCategoryService:"
				+ newsCategoryService);
		news.setCategoryid(temp1.getCategoryid());
		news.setDate(new Date());
		news.setPublisher(ServletActionContext.getRequest().getSession()
				.getAttribute("account").toString());
		newsService.save(news);
		return "success";
	}

	public String deleteNews() {
		news = newsService.getNewsByNewsid(newsid);
		//ɾ�����Ų��鿴�Ƿ���ͼƬ����Ƶ��һ��ɾ��
		File photo=new File(ServletActionContext.getServletContext().getRealPath("/newsImages")+"/"+news.getImage());
		if(photo.exists())
			DelFile.deleteFile(photo.getPath());
		File video=new File(ServletActionContext.getServletContext().getRealPath("/newsVideo")+"/"+news.getVideo());
		if(video.exists())
			DelFile.deleteFile(video.getPath());
		File encFile=new File(ServletActionContext.getServletContext().getRealPath("/newsEnclosure")+"/"+news.getEnclosure());
		if(encFile.exists())
			DelFile.deleteFile(encFile.getPath());
		newsService.delete(news);
		return "success";
	}

	public String updateNews() {
		
		if (photo != null && photoFileName != null) {
			String filePath=ServletActionContext.getServletContext().getRealPath("/newsImages");
			String fileName=uploadfunc(filePath,photoFileName.get(0),photo.get(0));
			/* ͼƬ�ļ��ϴ����� */
			//�ȼ��ԭ���Ƿ��ϴ���ͼƬ
			if(news.getImage()!=null)
				DelFile.deleteFile(filePath+"/"+news.getImage());
			news.setImage(fileName); // ���ϴ��ļ�·��������������
		}
		if(video!=null && videoFileName!=null)
		{
			String filePath=ServletActionContext.getServletContext()
					.getRealPath("/newsVideo");
			String fileName =uploadfunc(filePath,videoFileName.get(0),video.get(0));
			//�ȼ��ԭ���Ƿ��ϴ�����Ƶ
			if(news.getVideo()!=null)
				DelFile.deleteFile(filePath+"/"+news.getVideo());
			news.setVideo(fileName);
			
		}
		if(enclosure!=null && enclosureFileName!=null)
		{
			String filePath=ServletActionContext.getServletContext()
					.getRealPath("/newsEnclosure");
			String fileName =uploadfunc(filePath,enclosureFileName.get(0),enclosure.get(0));
			//�ȼ��ԭ���Ƿ��ϴ�������
			if(news.getEnclosure()!=null)
				DelFile.deleteFile(filePath+"/"+news.getEnclosure());
			news.setEnclosure(fileName); // ���ϴ��ļ�·��������������
		}
		if (photo == null || photoFileName == null)
			{
			if(newsService.getNewsByNewsid(newsid).getImage()!=null)
			news.setImage(newsService.getNewsByNewsid(newsid).getImage());
			}
		if(video==null || videoFileName==null)
			{
			if(newsService.getNewsByNewsid(newsid).getVideo()!=null)
				news.setVideo(newsService.getNewsByNewsid(newsid).getVideo());		
			}
		if(enclosure==null || enclosureFileName==null)
		{
			
			if(newsService.getNewsByNewsid(newsid).getEnclosure()!=null)
				news.setEnclosure(newsService.getNewsByNewsid(newsid).getEnclosure());	
		}
		news.setPublisher(ServletActionContext.getRequest().getSession()
				.getAttribute("account").toString());
		news.setNewsid(newsid);
		newsService.update(news);
		return "success";
	}

	//
	public String getMyNews() {
		Object o = ServletActionContext.getRequest().getSession()
				.getAttribute("account");
		if (o == null || o.toString().equals("") == true) {
			newsList = null;
			return "success";
		} else {
			ArrayList list = newsService.getNewsByAccount(o.toString());
			pagefunc(list);
			ServletActionContext.getRequest().getSession()
					.setAttribute("owner", "owner");
		}
		return "success";
	}

	// �����������
	public String getAllNews() {
		newsList = new ArrayList<News>();

		ArrayList list = newsService.getAllNews();
		pagefunc(list);
		return "success";
	}

	/*
	 * �鿴���ž���
	 */
	public String detail()

	{
		news = newsService.getNewsByNewsid(newsid);
		return "success";
	}

	/*
	 * �༭���ž���
	 */
	public String edit() {
		news = newsService.getNewsByNewsid(newsid);
		categoryList = newsCategoryService.getAllNewsCategory();
		return "success";
	}

	// ��������
	public String search() {
		if (searchtext == null)
			searchtext = "";
		else
			searchtext = searchtext.trim();
		ArrayList<News> list = new ArrayList<News>();
		if (search.equals("title")) {
			list = newsService.getNewsByTitle(searchtext);
		} else if (search.equals("publisher")) {
			list = newsService.getNewsByPublisher(searchtext);
		} else {
			ArrayList<NewsCategory> categoryList = new ArrayList<NewsCategory>();
			categoryList = newsCategoryService.getCategoryLikeName(searchtext);
			ArrayList<News> tempList = new ArrayList<News>();
			for (int i = 0; i < categoryList.size(); i++) {
				tempList = newsService.getNewsByCategoryId(categoryList.get(i)
						.getCategoryid());
				int size = tempList.size();
				for (int j = 0; j < size; j++)
					list.add(tempList.get(j));
			}
		}

		ServletActionContext.getRequest().getSession()
				.setAttribute("radio", search);
		ServletActionContext.getRequest().getSession()
				.setAttribute("searchtext", searchtext);
		pagefunc(list);
		// System.out.println(searchtext);
		// System.out.println(newsList);
		return "success";
	}
	
	public InputStream getDownloadFile() throws Exception
	{
		enclosureName=newsService.getNewsByNewsid(newsid).getEnclosure();
		return ServletActionContext.getServletContext().getResourceAsStream("newsEnclosure/"+enclosureName);
	}
	public String downloadFile() throws Exception
	{
		return "success";
	}

	// �ļ��ϴ�
	private static void copy(File src, File dest) {
		try {
			FileInputStream in=null;
			FileOutputStream out=null;
			try {
				in=new FileInputStream(src);
				out=new FileOutputStream(dest);
				byte[] buffer = new byte[BUFFER_SIZE];
				int count=0;
				while ((count=in.read(buffer,0,buffer.length))!=-1) {
					out.write(buffer,0,count);
					out.flush();
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * ��ҳ�������� ����������б����з�ҳ�ٸ�ֵ��newsList
	 */
	public void pagefunc(ArrayList list) {
		newsList = new ArrayList<News>(); // ÿ�ζ�Ҫ���·���
		totalRows = list.size();
		pagerService = new PagerService();
		pager = pagerService.getPager(currentPage, pagerMethod, totalRows,
				pagesize);
		currentPage = String.valueOf(pager.getCurrentPage());
		totalRows = pager.getTotalRows();
		totalPages = pager.getTotalPages();
		// System.out.println(currentPage);
		for (int i = pager.getStartRow(); i < pager.getTotalRows()
				&& i < pager.getStartRow() + pager.getPageSize(); i++) {
			newsList.add((News) list.get(i));
		}
	}


	/*
	 * �����ϴ��ļ������ļ��ŵ���������destPath
	 */
	public String uploadfunc(String destPath,String fileName,File destfile)
	{
		/* ͼƬ�ļ��ϴ���ʼ */
		String strFileType;// ��׺����.
		// String
		// temp=ServletActionContext.getRequest().getParameter("photo");
		String temp = fileName;
		int index = temp.lastIndexOf("."); // ��ȡ���һ����ŵ�λ��
		strFileType = temp.substring(index).toLowerCase(); // ��ȡ�ļ���׺����.
		// ���Ŀ¼������
		File file = new File(destPath);
		if (!file.exists()) {
			// ����Ŀ¼
			file.mkdir();
		}
		System.out.print(file.getPath());
		String dir = file.getPath(); // ��ø�Ŀ¼·��
		File saveFile = new File(dir + "/" + new Date().getTime()
				+ strFileType); // ����һ��saveFile�����ϴ��ļ�
		copy(destfile, saveFile);
		return saveFile.getName();
	}
}
