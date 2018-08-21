package com.privalia.dao.integration.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static com.privalia.util.FileManager.createFile;


import org.junit.Test;

import com.privalia.common.Alumno;
import com.privalia.dao.AlumnoDao;

public class AlumnoDaoTest {

	@Test
	public void testAdd() throws UnsupportedOperationException, IOException {
		Alumno alumno = new Alumno();
		alumno.setApellidos("Vilanova");
		alumno.setDni("46949999-R");
		alumno.setIdAlumno(1);
		alumno.setNombre("Daniel");
		AlumnoDao alumnoDao = new AlumnoDao();
		alumnoDao.add(alumno);
		
		File x = createFile(); 
		BufferedReader br = new BufferedReader(new FileReader(x));
		
		String currentLine = "";
		 while ( br.readLine() != null) {
		        currentLine = br.readLine();
		 }
		 br.close();
		 assertTrue(alumno.toString().equals(currentLine));
		
	}
	
	

}
