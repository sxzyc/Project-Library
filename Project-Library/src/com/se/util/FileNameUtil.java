package com.se.util;

import java.io.File;
import java.util.UUID;

public class FileNameUtil {
	//根据UUID生成文件名
	public static String getUUIDFileName() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
	//从请求头中提取文件名和类型
	public static String getRealFileName(String context) {
		// Content-Disposition: form-data; name="myfile"; filename="a_left.jpg"
		int index = context.lastIndexOf("=");
		String filename = context.substring(index + 2, context.length() - 1);
		return filename;
	}
	//根据给定的文件名和后缀截取后缀
	public static String getFileType(String fileName){
		//9527s.jpg
		int index = fileName.lastIndexOf(".");
		return fileName.substring(index);

		//8b7cb153974c4947ad6934a3213dd1f4.jpg
	}
	
	public static void deleteFile(String filepath) {
		File f=new File(filepath);
		f.delete();
	}
}
