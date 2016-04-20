package CompressorUtil;

import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

public class ZipCompressorByAnt {

	private File zipFile;
	/*
	 * pathName:目标路径加文件名
	 * srcPathName:源文件路径加文件名
	 */
	public ZipCompressorByAnt(String pathName) {   
        zipFile = new File(pathName);   
    }   
       
    public void compress(String srcPathName) {   
        File srcfile = new File(srcPathName);   
        if (!srcfile.exists())   
            throw new RuntimeException(srcPathName + "不存在！");   
        
        Project prj = new Project();   
        Zip zip = new Zip();   
        zip.setProject(prj);   
        zip.setDestFile(zipFile);   
        FileSet fileSet = new FileSet();   
        fileSet.setProject(prj); 
        
        if(srcfile.isDirectory())
        	fileSet.setDir(srcfile);   
        else
        	fileSet.setFile(srcfile);
        //fileSet.setIncludes("**/*.java"); 包括哪些文件或文件夹 eg:zip.setIncludes("*.java");   
        //fileSet.setExcludes(...); 排除哪些文件或文件夹   
        zip.addFileset(fileSet);  
        zip.execute();                   
    }   
    
    public void compress(File file) {   
        if (!file.exists())   
            throw new RuntimeException("文件不存在！压缩失败");   
        try{
        Project prj = new Project();   
        Zip zip = new Zip();   
        zip.setProject(prj);   
        zip.setDestFile(zipFile);   
        FileSet fileSet = new FileSet();   
        fileSet.setProject(prj); 
        
        if(file.isDirectory())
        	fileSet.setDir(file);   
        else
        	fileSet.setFile(file);
        //fileSet.setIncludes("**/*.java"); 包括哪些文件或文件夹 eg:zip.setIncludes("*.java");   
        //fileSet.setExcludes(...); 排除哪些文件或文件夹   
        zip.addFileset(fileSet);  
        zip.execute();   
        }catch(Exception e)
        {
        	e.printStackTrace();
        	System.out.println("压缩失败");
        }
    }   
    public static void main(String args[])
    {
    	ZipCompressorByAnt test=new ZipCompressorByAnt("f:\\电影\\123.zip");
    	System.out.println("压缩中");
    	test.compress("f:\\电影\\笨贼别跑.1080p.HD国语中字 .mkv");
    	System.out.println("压缩完成");
    }
}  
