package com.privalia.dao;

import com.privalia.common.Alumno;
import com.privalia.util.FileManager;

import static com.privalia.util.FileManager.createFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class AlumnoDao implements IDao<Alumno>{
	public Alumno add(Alumno alumno) throws UnsupportedOperationException, IOException{
		
		File x = createFile(); 
		FileWriter fw = new FileWriter(x.getAbsoluteFile(), true);
		fw.write(alumno.toString());
		fw.write(String.format("%n"));
		fw.close();
		return alumno;
	}
}
