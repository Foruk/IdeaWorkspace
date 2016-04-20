package Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;



import Entity.News;
import Entity.User;
import PagerUtil.Pager;
import PagerUtil.PagerService;
import Service.UserService;

public class UserAction {

	private User user;
	private UserService userService;
	private ArrayList<User> userList;
	
	//获得搜索的条件
	private String search;
	private String searchtext;
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
	
	//获取删除id
	private String id;
	
	//获取detail的id
	private String userid;
	
	//验证用户名
	private String account;

	//显示格式时间
	private String birthday;


	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String saveUser() {
		
		userService.save(user);
		return "success";
	}

	public String deleteUser() {
		//|是转译符  必须加\\
		String t[]=id.split("\\|");
		for(int i=0;i<t.length;i++)
		{
			user=userService.getUserById(t[i]);
			userService.delete(user);
		}
		return "success";
	}

	public String updateUser() {
		if(user.getPassword().equals("")||user.getPassword()==null)
			user.setPassword(userService.getUserById(String.valueOf(user.getUserid())).getPassword());
 		user.setAccount(ServletActionContext.getRequest().getSession().getAttribute("account").toString());
		userService.update(user);
		return "success";
	}

	public String getAllUser()
	{
		ArrayList list=userService.getAllUser();
		pagefunc(list);
		return "success";
	}
	
	public String edit()
	{
		if(ServletActionContext.getRequest().getParameter("editflag")==null)
			return "userEdit";
		String flag=ServletActionContext.getRequest().getParameter("editflag").toString();
		user=userService.getUserById(userid);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		birthday=sdf.format(user.getBirthday());
		if(flag.equals("1")==true)
			return "userEdit";
		else
			return "personEdit";
	}
	
	public String search()
	{
		if(searchtext==null)
			searchtext="";
		else
			searchtext=searchtext.trim();
		ArrayList list=new ArrayList();
		if(search.equals("account"))
		{
			list=userService.getUserLikeAccount(searchtext);
		}
		else if(search.equals("nickname"))
		{
			list=userService.getUserLikeNickName(searchtext);
		}
		else
		{
			list=userService.getAllUser();
		}
		
		ServletActionContext.getRequest().getSession().setAttribute("radio", search);
		ServletActionContext.getRequest().getSession().setAttribute("searchtext", searchtext);
		pagefunc(list);
		return "success";
	}
	
	public String login() {
		if (user.getAccount() == null || user.getPassword() == null)
			return "fail";
		User temp = userService
				.loginvail(user.getAccount(), user.getPassword());
		if (temp == null)
			return "fail";
		else {
			user = temp;
			ServletActionContext.getRequest().getSession()
					.setAttribute("account", user.getAccount());
			ServletActionContext.getRequest().getSession()
					.setAttribute("userid",String.valueOf(user.getUserid()));
			ServletActionContext.getRequest().getSession()
					.setAttribute("nickname", user.getNickname());
			return "user";
		}
	}
	public String loginout()
	{
		ServletActionContext.getRequest().getSession().removeAttribute("account");
		ServletActionContext.getRequest().getSession().removeAttribute("nickname");
		ServletActionContext.getRequest().getSession().removeAttribute("userid");
		return "success";
	}
	
	public String register()
	{		
		user.setJurisdiction("用户");
		userService.save(user);
		return "success";
	}
	public void checkAccount() throws IOException
	{
		ActionContext.getContext().getSession().remove("account");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=gb2312");
		response.setHeader("Cache-Control", "no-cache");		
		PrintWriter out = response.getWriter();
		String msg;		    
		User temp=userService.getUserByAccount(account);
		if(temp==null)
			msg="{\"result\":\"success\"}";//失败的写法
		else		
			msg="{\"result\":\"fail\"}"; //成功的写法	
	    out.print(msg);
		out.flush();
	}
	public void pagefunc(ArrayList list)
	{
		userList=new ArrayList<User>();	//每次都要重新分配
		totalRows=list.size();
		pagerService=new PagerService();
		pager=pagerService.getPager(currentPage, pagerMethod, totalRows, pagesize);
		currentPage=String.valueOf(pager.getCurrentPage());
		totalRows=pager.getTotalRows();
		totalPages=pager.getTotalPages();
		//System.out.println(currentPage);
		for(int i=pager.getStartRow();i<pager.getTotalRows()&&i<pager.getStartRow()+pager.getPageSize();i++)
	    {
			userList.add((User)list.get(i));
	    }	
	}
	
}
