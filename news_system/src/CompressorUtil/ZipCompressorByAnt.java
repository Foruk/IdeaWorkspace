package CompressorUtil;

import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

public class ZipCompressorByAnt {

	private File zipFile;
	/*
	 * pathName:Ŀ��·�����ļ���
	 * srcPathName:Դ�ļ�·�����ļ���
	 */
	public ZipCompressorByAnt(String pathName) {   
        zipFile = new File(pathName);   
    }   
       
    public void compress(String srcPathName) {   
        File srcfile = new File(srcPathName);   
        if (!srcfile.exists())   
            throw new RuntimeException(srcPathName + "�����ڣ�");   
        
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
        //fileSet.setIncludes("**/*.java"); ������Щ�ļ����ļ��� eg:zip.setIncludes("*.java");   
        //fileSet.setExcludes(...); �ų���Щ�ļ����ļ���   
        zip.addFileset(fileSet);  
        zip.execute();                   
    }   
    
    public void compress(File file) {   
        if (!file.exists())   
            throw new RuntimeException("�ļ������ڣ�ѹ��ʧ��");   
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
        //fileSet.setIncludes("**/*.java"); ������Щ�ļ����ļ��� eg:zip.setIncludes("*.java");   
        //fileSet.setExcludes(...); �ų���Щ�ļ����ļ���   
        zip.addFileset(fileSet);  
        zip.execute();   
        }catch(Exception e)
        {
        	e.printStackTrace();
        	System.out.println("ѹ��ʧ��");
        }
    }   
    public static void main(String args[])
    {
    	ZipCompressorByAnt test=new ZipCompressorByAnt("f:\\��Ӱ\\123.zip");
    	System.out.println("ѹ����");
    	test.compress("f:\\��Ӱ\\��������.1080p.HD�������� .mkv");
    	System.out.println("ѹ�����");
    }
}  
