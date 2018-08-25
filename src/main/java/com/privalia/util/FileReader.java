package com.privalia.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {
	
	public static String readFile(File file) throws IOException {
		
		
		FileInputStream fileStream = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		fileStream.read(data);
		fileStream.close();
		String r = new String(data, "UTF-8");
		
		return r;
		
	}

}
