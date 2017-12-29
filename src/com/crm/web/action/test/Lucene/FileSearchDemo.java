package com.crm.web.action.test.Lucene;

import java.io.File;

public class FileSearchDemo {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\zhang\\Desktop\\to_xutao";
		fileSearch(filePath);
	}
	
	public static void fileSearch(String filePath) {
		File file = new File(filePath);
		if(file.isDirectory()){
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				if(file2.isDirectory()){
					fileSearch(file2.getAbsolutePath());
				}else {
					System.out.println(file.getName()+"目录下的文件："+file2.getName());
				}
			}
		}else {
			System.out.println("顶层文件名："+file.getName());
		}
	}
}
