package com.privalia.dao.integration.test;

import static org.junit.Assert.*;

import java.io.IOException;



import org.junit.Test;

import com.privalia.common.Alumno;
import com.privalia.dao.TxtAlumnoDAO;

public class AlumnoDaoTest {

	@Test
	public void testAdd() throws UnsupportedOperationException, IOException {
		
		Alumno alumno = new Alumno();
		alumno.setApellidos("Vilanova");
		alumno.setDni("46949999-R");
		alumno.setIdAlumno(6);
		alumno.setNombre("Daniel");
		TxtAlumnoDAO alumnoDao = new TxtAlumnoDAO();
		Alumno alumnoInserted = alumnoDao.add(alumno);
		
		
		
		assertTrue(alumnoInserted.equals(alumno));
		
	}
	
	

}
