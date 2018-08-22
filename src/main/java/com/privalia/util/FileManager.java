package com.privalia.util;

import java.io.File;

public class FileManager {
	
	

	
	public static File createFile(String path) {
		
		File sFile = searchFile(path);
		if (sFile != null ) {
			return sFile;
		}
		else {
			File file = new File(path);
			
			return file;
		}
	}
	
	public static File searchFile(String path) {
		File file = new File(path);
		if(file.isFile()){
			return file;
		}
		return null;
		
		
		
	}

}
