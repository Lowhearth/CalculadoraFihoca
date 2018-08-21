package com.privalia.dao;

import com.privalia.common.Alumno;

import static com.privalia.util.FileManager.createFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AlumnoDao implements IDao<Alumno>{
	
	public static File x = null;
	
	static {
		x = createFile();
	}

	
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
		 String[] data = currentLine.split(",", 4);
		 
		 Alumno insertedAlumno = new Alumno();
		 insertedAlumno.setIdAlumno(Integer.parseInt(data[0]));
		 insertedAlumno.setNombre(data[1]);
		 insertedAlumno.setApellidos(data[2]);
		 insertedAlumno.setDni(data[3]);
		 
		 
		 
		return insertedAlumno;
	}
}
