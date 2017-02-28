package cn.edu.hevttc.psy.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFile {
	public static boolean CopyFileStream(String inputStreamAddr,String outputStreamAddr){
		boolean flag =false;
		try{
			BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream(inputStreamAddr));
			BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(outputStreamAddr));
			byte[] b = new byte[1024];
			int bytes;
			while((bytes = bis.read(b,0,b.length))!=-1){
				bos.write(b,0,bytes);
				bos.flush();
		    }
		    bis.close();
			bos.close();
			flag=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
}
