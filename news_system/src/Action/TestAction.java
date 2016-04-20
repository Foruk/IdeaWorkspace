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
			String strFileType;//后缀名有.
			//String temp=ServletActionContext.getRequest().getParameter("photo");
		    String temp = videoFileName; 
			int index = temp.lastIndexOf(".");    //获取最后一个点号的位置
			strFileType = temp.substring(index).toLowerCase();  	//获取文件后缀名有.
			
			File file=new File(ServletActionContext.getServletContext().getRealPath("/newsVideo"));
			if(!file.exists())
			{
				  //创建目录  
				file.mkdir();
			}
			String fileName=file.getPath()+"/"+new Date().getTime();
			 	//获得根目录路径
			File saveFile = new File(fileName+strFileType); 	//构造一个saveFile接收上传图片
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
	 *  根据路径删除指定的目录或文件，无论存在与否 
	 *@param sPath  要删除的目录或文件 
	 *@return 删除成功返回 true，否则返回 false。 
	 */  
	public boolean DeleteFolder(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // 判断目录或文件是否存在  
	    if (!file.exists()) {  // 不存在返回 false  
	        return flag;  
	    } else {  
	        // 判断是否为文件  
	        if (file.isFile()) {  // 为文件时调用删除文件方法  
	            return deleteFile(sPath);  
	        } else {  // 为目录时调用删除目录方法  
	            return deleteDirectory(sPath);  
	        }  
	    }  
	}
	
	/** 
	 * 删除单个文件 
	 * @param   sPath    被删除文件的文件名 
	 * @return 单个文件删除成功返回true，否则返回false 
	 */  
	public boolean deleteFile(String sPath) {  
		boolean flag = false;  
	   File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}  
	
	
	/** 
	 * 删除目录（文件夹）以及目录下的文件 
	 * @param   sPath 被删除目录的文件路径 
	 * @return  目录删除成功返回true，否则返回false 
	 */  
	public boolean deleteDirectory(String sPath) {  
	    //如果sPath不以文件分隔符结尾，自动添加文件分隔符  
	    if (!sPath.endsWith(File.separator)) {  
	        sPath = sPath + File.separator;  
	    }  
	    File dirFile = new File(sPath);  
	    //如果dir对应的文件不存在，或者不是一个目录，则退出  
	    if (!dirFile.exists() || !dirFile.isDirectory()) {  
	        return false;  
	    }  
	    boolean  flag = true;  
	    //删除文件夹下的所有文件(包括子目录)  
	    File[] files = dirFile.listFiles();  
	    for (int i = 0; i < files.length; i++) {  
	        //删除子文件  
	        if (files[i].isFile()) {  
	            flag = deleteFile(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        } //删除子目录  
	        else {  
	            flag = deleteDirectory(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        }  
	    }  
	    if (!flag) return false;  
	    //删除当前目录  
	    if (dirFile.delete()) {  
	        return true;  
	    } else {  
	        return false;  
	    }  
	}  
		
}
