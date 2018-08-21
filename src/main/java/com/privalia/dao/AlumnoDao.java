package com.privalia.dao;

import com.privalia.common.Alumno;

import static com.privalia.util.FileManager.createFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AlumnoDao implements IDao<Alumno>{
	
	public static File x = createFile(); 

	
	public Alumno add(Alumno alumno) throws UnsupportedOperationException, IOException{
		
		FileWriter fw = new FileWriter(x.getAbsoluteFile(), true);
		fw.write(String.format("%n"));
		fw.write(alumno.toString());
		fw.close();
		return alumno;
	}
}
