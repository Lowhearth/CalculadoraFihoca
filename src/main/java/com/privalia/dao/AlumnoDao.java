package com.privalia.dao;

import com.privalia.common.Alumno;

import static com.privalia.util.FileManager.createFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AlumnoDao implements IDao<Alumno>{
	
	public static File x = createFile(); 

	
	public Alumno add(Alumno alumno) throws UnsupportedOperationException, IOException{
		
		FileWriter fw = new FileWriter(x.getAbsoluteFile(), true);
		fw.write(String.format("%n"));
		fw.write(alumno.toString());
		fw.close();
		BufferedReader br = new BufferedReader(new FileReader(x));
		
		String currentLine = "";
		 while ( br.readLine() != null) {
		        currentLine = br.readLine();
		 }
		 br.close();
		 
		 
		return alumno;
	}
}
