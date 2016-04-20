package CompressorUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

import org.apache.tools.zip.ZipEntry;   
import org.apache.tools.zip.ZipOutputStream;  

public class FileCompressor {

	static final int BUFFER = 1024*1024*30;  
	 private File zipFile;  
	 
	 public FileCompressor(String pathName) {   
	        zipFile = new File(pathName);   
	    }  
	 
	 public void compress(String srcPathName) {   
	        File file = new File(srcPathName);   
	        if (!file.exists())   
	            throw new RuntimeException(srcPathName + "�����ڣ�");   
	        try {   
	            FileOutputStream fileOutputStream = new FileOutputStream(zipFile);   
	            CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream,   
	                    new CRC32());   
	            ZipOutputStream out = new ZipOutputStream(cos);   
	            String basedir = "";   
	            compress(file, out, basedir);   
	            out.close();   
	        } catch (Exception e) {   
	            throw new RuntimeException(e);   
	        }   
	    }
	 
	 public void compress(File newfile) {    
	        if (!newfile.exists())   
	            throw new RuntimeException("�����ڣ�");   
	        try {   
	            FileOutputStream fileOutputStream = new FileOutputStream(zipFile);   
	            CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream,   
	                    new CRC32());   
	            ZipOutputStream out = new ZipOutputStream(cos);   
	            String basedir = "";   
	            compress(newfile, out, basedir);   
	            out.close();   
	        } catch (Exception e) {   
	            throw new RuntimeException(e);   
	        }   
	    }
	 
	 private void compress(File file, ZipOutputStream out, String basedir) {   
	        /* �ж���Ŀ¼�����ļ� */  
	        if (file.isDirectory()) {   
	            System.out.println("ѹ����" + basedir + file.getName());   
	            this.compressDirectory(file, out, basedir);   
	        } else {   
	            System.out.println("ѹ����" + basedir + file.getName());   
	            this.compressFile(file, out, basedir);   
	        }   
	    }
	 
	 /** ѹ��һ��Ŀ¼ */  
	    private void compressDirectory(File dir, ZipOutputStream out, String basedir) {   
	        if (!dir.exists())   
	            return;   
	  
	        File[] files = dir.listFiles();   
	        for (int i = 0; i < files.length; i++) {   
	            /* �ݹ� */  
	            compress(files[i], out, basedir + dir.getName() + "/");   
	        }   
	    }   
	  
	    
	    /** ѹ��һ���ļ� */  
	    private void compressFile(File file, ZipOutputStream out, String basedir) {   
	        if (!file.exists()) {   
	            return;   
	        }   
	        try {   
	            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));   
	            ZipEntry entry = new ZipEntry(basedir + file.getName());   
	            out.putNextEntry(entry);   
	            int count;   
	            byte data[] = new byte[BUFFER];   
	            while ((count = bis.read(data, 0, BUFFER)) != -1) {   
	                out.write(data, 0, count);   
	            }   
	            bis.close();   
	        } catch (Exception e) {   
	            throw new RuntimeException(e);   
	        }   
	    } 
	    public static void main(String args[])
	    {
	    	FileCompressor test=new FileCompressor("f:\\��Ӱ\\asd.zip");
	    	System.out.println("ѹ����");
	    	test.compress("f:\\��Ӱ\\asd");
	    	System.out.println("ѹ�����");
	    }
}
