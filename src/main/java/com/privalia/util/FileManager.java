package com.privalia.util;

import java.io.File;

public class FileManager {
	public static String path = "alumnos.txt";
	

	
	public static File createFile() {
		if (searchFile() != null ) {
			return searchFile();
		}
		else {
			File file = new File(path);
			
			return file;
		}
	}
	
	public static File searchFile() {
		File file = new File(path);
		if(file.isFile()){
			return file;
		}
		return null;
		
		
		
	}

}
