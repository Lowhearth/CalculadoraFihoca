package com.privalia.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.privalia.common.Alumno;


@RunWith(Parameterized.class)
public class AlumnoDaoParametrizedTest {
	
	private Alumno alumnoExample = new Alumno();
	private AlumnoDao alumnoDao;
	
	
	public AlumnoDaoParametrizedTest(Alumno alumno) {
		this.alumnoExample = alumno;
	}
	 @Before
	 public void initialize() {
		 alumnoDao = new AlumnoDao();
	 }
	 @Parameters
	    public static Collection<Object[]> data() {
	    	
	    	Object alumno1 = new Alumno(1, "Daniel", "Vilanova", "3123421-r");
	    	Object alumno2 = new Alumno(2, "David", "Lynch", "231231412-t");
	    	Object alumno3 = new Alumno(3, "Stanley", "Kubrick", "34543534-t");
	        return Arrays.asList(new Object[][] { {alumno1}, {alumno2}, {alumno3} });
	    }

	    
	@Test
	public void testAdd() throws NumberFormatException, UnsupportedOperationException, IOException {
	
		assertTrue(alumnoDao.add(alumnoExample).equals(alumnoExample) );
		
	}

}
