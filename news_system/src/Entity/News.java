package Entity;

import java.util.Date;

public class News {
	private int newsid;
	private String title;
	private String maincontent;
	private String image;
	private String video;
	private String enclosure;
	private Date date;
	private String publisher;
	private int clickVolume; 
	private int categoryid;
	private String categoryname;
	
	
	public String getEnclosure() {
		return enclosure;
	}
	public void setEnclosure(String enclosure) {
		this.enclosure = enclosure;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public int getNewsid() {
		return newsid;
	}
	public void setNewsid(int newsid) {
		this.newsid = newsid;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getClickVolume() {
		return clickVolume;
	}
	public void setClickVolume(int clickVolume) {
		this.clickVolume = clickVolume;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	
	
}
