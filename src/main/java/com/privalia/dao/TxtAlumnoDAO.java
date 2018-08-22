package com.privalia.dao;

import com.privalia.common.Alumno;

import static com.privalia.util.FileManager.createFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TxtAlumnoDAO implements IDao<Alumno> {

	public static String path = "Alumno.txt";
	public static File file = null;
	
	static {
		file = createFile(path);
	}

	public Alumno add(Alumno alumno) throws UnsupportedOperationException, NumberFormatException, IOException {

		try {

			FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true);
			fileWriter.write(alumno.toString());
			fileWriter.write(String.format(String.format("%n")));
			fileWriter.close();

		}

		catch (IOException exception) {
			System.out.println("The alumn wasnt added to the file " + exception.getMessage());
			throw exception;
		}

		return searchById(alumno.getIdAlumno());
	}

	private Alumno searchById(int id) throws NumberFormatException, IOException {
		
		Alumno foundAlumn = new Alumno();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String currentLine = "";
			boolean alumnoFound = false;
			
	
				while (currentLine != null && !alumnoFound) {
					currentLine = br.readLine();
					String[] userSplitInStringArray = currentLine.split(",", 4);
					if (Integer.parseInt(userSplitInStringArray[0]) == id) {
						alumnoFound = true;
					}
				}
	
			br.close();
			String[] userSplitInStringArray = currentLine.split(",", 4);
			foundAlumn.setIdAlumno(Integer.parseInt(userSplitInStringArray[0]));
			foundAlumn.setNombre(userSplitInStringArray[1]);
			foundAlumn.setApellidos(userSplitInStringArray[2]);
			foundAlumn.setDni(userSplitInStringArray[3]);
		}
		catch(IOException exception) {
			System.out.println("Cant search that " + exception.getMessage());
			throw exception;

		

		}	
		return foundAlumn;
	}
}
