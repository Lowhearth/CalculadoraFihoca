package com.privalia.dao.integration.test;

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
import com.privalia.dao.AlumnoDao;


@RunWith(Parameterized.class)
public class AlumnoDaoParametrizedTest {
	
	private Alumno alumnoEnviado = new Alumno();
	private Alumno alumnoEsperado = new Alumno();
	private AlumnoDao alumnoDao;
	
	
	public AlumnoDaoParametrizedTest(Alumno alumnoEnviado, Alumno alumnoEsperado) {
		this.alumnoEnviado = alumnoEnviado;
		this.alumnoEsperado = alumnoEsperado;
	}
	 @Before
	 public void initialize() {
		 alumnoDao = new AlumnoDao();
	 }
	 @Parameters
	    public static Collection<Object[]> data() {
	    	
	    	Object alumno1Enviado = new Alumno(1, "Daniel", "Vilanova", "3123421-r");
	    	Object alumno1Esperado = new Alumno(1, "Daniel", "Vilanova", "3123421-r");

	    	
	    	Object alumno2Enviado = new Alumno(2, "David", "Lynch", "231231412-t");
	    	Object alumno2Esperado = new Alumno(2, "David", "Lynch", "231231412-t");
	    	
	    	Object alumno3Enviado = new Alumno(3, "Stanley", "Kubrick", "34543534-t");
	    	Object alumno3Esperado = new Alumno(3, "Stanley", "Kubrick", "34543534-t");
	        return Arrays.asList(new Object[][] { {alumno1Enviado, alumno1Esperado}, 
	        									  {alumno2Enviado, alumno2Esperado}, 
	        									  {alumno3Enviado, alumno3Esperado} });
	    }

	    
	@Test
	public void testAdd() throws NumberFormatException, UnsupportedOperationException, IOException {
		
		Alumno alumnoDevuelto = alumnoDao.add(alumnoEnviado);
		boolean resultado = alumnoDevuelto.equals(alumnoEsperado);
		assertTrue(resultado);
		
	}

}
