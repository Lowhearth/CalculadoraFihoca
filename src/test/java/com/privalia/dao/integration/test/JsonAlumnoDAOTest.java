package com.privalia.dao.integration.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.privalia.common.Alumno;
import com.privalia.dao.JsonAlumnoDAO;

public class JsonAlumnoDAOTest {

	@Test
	public void test() throws NumberFormatException, UnsupportedOperationException, IOException {
		Alumno alumno = new Alumno();
		alumno.setApellidos("Vilanova");
		alumno.setDni("46949999-R");
		alumno.setIdAlumno(19);
		alumno.setNombre("Daniel");
		JsonAlumnoDAO alumnoDao = new JsonAlumnoDAO();
		Alumno alumnoInserted = alumnoDao.add(alumno);
		
		
		
		assertTrue(alumnoInserted.equals(alumno));
	}

}
