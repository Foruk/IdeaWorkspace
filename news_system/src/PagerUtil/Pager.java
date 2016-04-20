package PagerUtil;

public class Pager {
	private int totalRows; //������
	private int pageSize = 3; //ÿҳ��ʾ������
	private int currentPage; //��ǰҳ��
	private int totalPages; //��ҳ��
	private int startRow; //��ǰҳ�����ݿ��е���ʼ��
	
	public Pager() 
	{
	}
	
	public Pager(int _totalRows,int pageSize) //ȷ���ּ�ҳ
	{
		totalRows = _totalRows;
		this.pageSize=pageSize;
		totalPages=totalRows/pageSize;
		int mod=totalRows%pageSize;
		if(mod>0)
		{
			totalPages++;
		}
		currentPage = 1;
		startRow = 0;
	}
	
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public void first() 
	{
		currentPage = 1;
		startRow = 0;
	}
	public void previous() 
	{
		if (currentPage == 1) 
		{
			return;
		}
		else
		{
			currentPage--;
			startRow = (currentPage - 1) * pageSize;
		}
	}
	public void next() 
	{
		if(currentPage==totalPages)
		{
			return;
		}
		else
		{
			currentPage++;
			startRow=(currentPage-1)*pageSize;
		}
	}
	public void last() 
	{
		currentPage = totalPages;
		startRow = (currentPage - 1) * pageSize;
	}
	public void currentReturn(){
		startRow = (currentPage - 1) * pageSize;
	}
	public void refresh(int _currentPage) 
	{
		if(_currentPage > totalPages) {
			currentPage = totalPages;
		}
		else {
			currentPage = _currentPage;
		}
		
	}
	
}
