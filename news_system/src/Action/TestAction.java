package Action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import CompressorUtil.FileCompressor;
import CompressorUtil.ZipCompressorByAnt;

public class TestAction {

	private File video;
	private String videoFileName;
	private String videoContentType;
	private String asd;
	
	
	public String getAsd() {
		return asd;
	}
	public void setAsd(String asd) {
		this.asd = asd;
	}
	public File getVideo() {
		return video;
	}
	public void setVideo(File video) {
		this.video = video;
	}
	public String getVideoFileName() {
		return videoFileName;
	}
	public void setVideoFileName(String videoFileName) {
		this.videoFileName = videoFileName;
	}
	public String getVideoContentType() {
		return videoContentType;
	}
	public void setVideoContentType(String videoContentType) {
		this.videoContentType = videoContentType;
	}
	
	public String test()
	{
		System.out.println(videoContentType);
		System.out.println(videoFileName);
		System.out.println(video);
		System.out.println(asd);
		if(video!=null)
		{
			String strFileType;//��׺����.
			//String temp=ServletActionContext.getRequest().getParameter("photo");
		    String temp = videoFileName; 
			int index = temp.lastIndexOf(".");    //��ȡ���һ����ŵ�λ��
			strFileType = temp.substring(index).toLowerCase();  	//��ȡ�ļ���׺����.
			
			File file=new File(ServletActionContext.getServletContext().getRealPath("/newsVideo"));
			if(!file.exists())
			{
				  //����Ŀ¼  
				file.mkdir();
			}
			String fileName=file.getPath()+"/"+new Date().getTime();
			 	//��ø�Ŀ¼·��
			File saveFile = new File(fileName+strFileType); 	//����һ��saveFile�����ϴ�ͼƬ
			copy(video,saveFile);  
			ZipCompressorByAnt zcba=new ZipCompressorByAnt(fileName+".zip");		
			//copy(video,newfile); 
			zcba.compress(saveFile);
			DeleteFolder(saveFile.getPath());
//			FileCompressor fcrs=new FileCompressor(fileName);
//			fcrs.compress(video);
		}
		return "success";
	}
	
	private static void copy(File src,File dst)  {
	       try  {
	          InputStream in = null ;
	          OutputStream out = null ;
	           try  {                
	              in = new BufferedInputStream( new FileInputStream(src), 1024*1024);
	              out = new BufferedOutputStream( new FileOutputStream(dst), 1024*1024);
	               byte [] buffer = new byte [1024*1024];
	               while (in.read(buffer) > 0 )  {
	                  out.write(buffer);
	              } 
	           } finally  {
	               if ( null != in)  {
	                  in.close();
	              } 
	                if ( null != out)  {
	                  out.close();
	              } 
	          } 
	       } catch (Exception e)  {
	          e.printStackTrace();
	      } 
   }
	
	/** 
	 *  ����·��ɾ��ָ����Ŀ¼���ļ������۴������ 
	 *@param sPath  Ҫɾ����Ŀ¼���ļ� 
	 *@return ɾ���ɹ����� true�����򷵻� false�� 
	 */  
	public boolean DeleteFolder(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // �ж�Ŀ¼���ļ��Ƿ����  
	    if (!file.exists()) {  // �����ڷ��� false  
	        return flag;  
	    } else {  
	        // �ж��Ƿ�Ϊ�ļ�  
	        if (file.isFile()) {  // Ϊ�ļ�ʱ����ɾ���ļ�����  
	            return deleteFile(sPath);  
	        } else {  // ΪĿ¼ʱ����ɾ��Ŀ¼����  
	            return deleteDirectory(sPath);  
	        }  
	    }  
	}
	
	/** 
	 * ɾ�������ļ� 
	 * @param   sPath    ��ɾ���ļ����ļ��� 
	 * @return �����ļ�ɾ���ɹ�����true�����򷵻�false 
	 */  
	public boolean deleteFile(String sPath) {  
		boolean flag = false;  
	   File file = new File(sPath);  
	    // ·��Ϊ�ļ��Ҳ�Ϊ�������ɾ��  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}  
	
	
	/** 
	 * ɾ��Ŀ¼���ļ��У��Լ�Ŀ¼�µ��ļ� 
	 * @param   sPath ��ɾ��Ŀ¼���ļ�·�� 
	 * @return  Ŀ¼ɾ���ɹ�����true�����򷵻�false 
	 */  
	public boolean deleteDirectory(String sPath) {  
	    //���sPath�����ļ��ָ�����β���Զ�����ļ��ָ���  
	    if (!sPath.endsWith(File.separator)) {  
	        sPath = sPath + File.separator;  
	    }  
	    File dirFile = new File(sPath);  
	    //���dir��Ӧ���ļ������ڣ����߲���һ��Ŀ¼�����˳�  
	    if (!dirFile.exists() || !dirFile.isDirectory()) {  
	        return false;  
	    }  
	    boolean  flag = true;  
	    //ɾ���ļ����µ������ļ�(������Ŀ¼)  
	    File[] files = dirFile.listFiles();  
	    for (int i = 0; i < files.length; i++) {  
	        //ɾ�����ļ�  
	        if (files[i].isFile()) {  
	            flag = deleteFile(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        } //ɾ����Ŀ¼  
	        else {  
	            flag = deleteDirectory(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        }  
	    }  
	    if (!flag) return false;  
	    //ɾ����ǰĿ¼  
	    if (dirFile.delete()) {  
	        return true;  
	    } else {  
	        return false;  
	    }  
	}  
		
}
