package com.privalia.util;

import java.io.File;

public class FileManager {
	

	
	public static File createFile() {
		if (searchFile() != null ) {
			return searchFile();
		}
		else {
			File file = new File("alumnos.txt");
			return file;
		}
	}
	
	public static File searchFile() {
		File file = new File("alumnos.txt");
		if(file.isFile()){
			return file;
		}
		return null;
		
		
		
	}

}
