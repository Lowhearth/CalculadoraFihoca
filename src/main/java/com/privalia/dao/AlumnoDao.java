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
			fw.write(alumno.toString());
			fw.write(String.format(String.format("%n")));
			fw.close();

			
		
		    return searchById(alumno.getIdAlumno());
	}
	
	private Alumno searchById(int id) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String currentLine = "";
		
		boolean alumnoFound = false;
		
		 while (currentLine !=null && !alumnoFound) {
		        currentLine = br.readLine();
		        System.out.println(currentLine);
		        String[] userSplitInStringArray = currentLine.split(",", 4);
		        if(Integer.parseInt(userSplitInStringArray[0]) == id) {
		        	alumnoFound = true;
		        }
		 }
		        
		 
		 br.close();
		 String[] userSplitInStringArray = currentLine.split(",", 4);
		 Alumno foundAlumn = new Alumno();
		 foundAlumn.setIdAlumno(Integer.parseInt(userSplitInStringArray[0]));
		 foundAlumn.setNombre(userSplitInStringArray[1]);
		 foundAlumn.setApellidos(userSplitInStringArray[2]);
		 foundAlumn.setDni(userSplitInStringArray[3]);
		 
		 return foundAlumn;
		
	}
}
