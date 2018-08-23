package com.privalia.dao.integration.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.privalia.common.Alumno;
import com.privalia.dao.DAOFactory;
import com.privalia.dao.FACTORY_NAME;
import com.privalia.dao.IDao;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class DAOFactoryTest {

	@Test
	@Parameters(method = "containsParameters")
	public void test(Alumno alumnoEnviado, Alumno alumnoEsperado) throws UnsupportedOperationException, IOException {
		
		DAOFactory daoFactory = DAOFactory.getDAOFactory(FACTORY_NAME.TXT);
		IDao<Alumno> iDao = daoFactory.getAlumnoDAO();
		assertTrue(iDao.add(alumnoEnviado).equals(alumnoEsperado));
	
		
		
		
	}
	
	@Test
	@Parameters(method = "containsParameters")
	public void test2(Alumno alumnoEnviado, Alumno alumnoEsperado) throws UnsupportedOperationException, IOException {
		
		DAOFactory daoFactory = DAOFactory.getDAOFactory(FACTORY_NAME.JSON);
		IDao<Alumno> iDao = daoFactory.getAlumnoDAO();
		assertTrue(iDao.add(alumnoEnviado).equals(alumnoEsperado));
	
		
		
		
	}


	
	public Object[] containsParameters() {
    	
    	Alumno alumnoEnviado = new Alumno();
		alumnoEnviado.setIdAlumno(2);
		alumnoEnviado.setNombre("Daniel");
		alumnoEnviado.setApellidos("Vilanova");
		alumnoEnviado.setDni("38115062z");
		
		Alumno alumnoEsperado = new Alumno();
		alumnoEsperado.setIdAlumno(2);
		alumnoEsperado.setNombre("Daniel");
		alumnoEsperado.setApellidos("Vilanova");
		alumnoEsperado.setDni("38115062z");
		
		Alumno alumnoEnviado1 = new Alumno();
		alumnoEnviado1.setIdAlumno(3);
		alumnoEnviado1.setNombre("Linus");
		alumnoEnviado1.setApellidos("Trovalds");
		alumnoEnviado1.setDni("454545454x");
		
		Alumno alumnoEsperado1 = new Alumno();
		alumnoEsperado1.setIdAlumno(3);
		alumnoEsperado1.setNombre("Linus");
		alumnoEsperado1.setApellidos("Trovalds");
		alumnoEsperado1.setDni("454545454x");
		
        return new Object[]{
                new Object[]{alumnoEnviado, alumnoEsperado},
                new Object[]{alumnoEnviado1, alumnoEsperado1}
        };
	

}
	
}
