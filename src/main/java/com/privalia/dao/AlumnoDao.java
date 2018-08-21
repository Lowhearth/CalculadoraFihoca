package com.privalia.dao;

import com.privalia.common.Alumno;

import static com.privalia.util.FileManager.createFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AlumnoDao implements IDao<Alumno>{
	
	public static File file = null;
	
	static {
		file = createFile();
	}

	
	public Alumno add(Alumno alumno) throws UnsupportedOperationException, IOException{
		
		FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		
		try {
			fw.write(alumno.toString());
			String.format("%n");
			fw.close();
		 
		 	}
		catch (IOException ex){
			throw ex;
		}
		finally {
			fw.close();
			
		}
		return searchById(alumno.getIdAlumno());
	}
	
	private Alumno searchById(int i) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String currentLine = "";
		boolean alumnoFound = false;
		 while ( br.readLine() != null || !alumnoFound) {
		        currentLine = br.readLine();
		        String[] data = currentLine.split(",", 4);
		        if(Integer.parseInt(data[0]) == i) {
		        	alumnoFound = true;
		        }
		 }
		 br.close();
		 String[] data = currentLine.split(",", 4);
		 Alumno foundAlumn = new Alumno();
		 foundAlumn.setIdAlumno(Integer.parseInt(data[0]));
		 foundAlumn.setNombre(data[1]);
		 foundAlumn.setApellidos(data[2]);
		 foundAlumn.setDni(data[3]);
		 
		 return foundAlumn;
		
	}
}
