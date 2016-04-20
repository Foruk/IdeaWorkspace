package PagerUtil;

import PagerUtil.Pager;

public class PagerService {
	public Pager getPager(String currentPage,String pagerMethod,int totalRows,int pageSize) 
	{
		//	锟斤拷锟斤拷pager锟斤拷锟斤拷锟斤拷锟节达拷锟斤拷页锟斤拷
		Pager pager = new Pager(totalRows,pageSize);
		//	锟斤拷锟角�?筹拷锟轿拷眨锟斤拷锟绞疚拷状尾锟窖拷锟揭�
		//	锟斤拷锟轿拷眨锟斤拷锟剿拷锟絧ager锟斤拷锟斤拷锟斤拷锟诫当前页锟脚碉拷锟斤拷息
		if (currentPage != null) 
		{
			pager.refresh(Integer.parseInt(currentPage));
		}
		//	锟斤拷取锟斤拷前执锟叫的凤拷锟斤拷锟斤拷锟斤拷页锟斤拷前�?��锟斤拷锟斤拷�?��锟斤拷尾页锟斤拷
		if (pagerMethod != null) 
		{
			if (pagerMethod.equals("first")) 
			{
				pager.first();
			} 
			else if (pagerMethod.equals("previous")) 
			{
				pager.previous();
			} 
			else if (pagerMethod.equals("next")) 
			{
				pager.next();
			} 
			else if (pagerMethod.equals("last")) 
			{
				pager.last();
			}
		}
		else
		{
			pager.currentReturn();
		}
		return pager;
	}
}
