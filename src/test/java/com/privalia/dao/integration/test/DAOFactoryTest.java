package com.privalia.dao.integration.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.privalia.common.Alumno;
import com.privalia.dao.DAOFactory;
import com.privalia.dao.IDao;

public class DAOFactoryTest {

	@Test
	public void test() {
		DAOFactory daoFactory = DAOFactory.getDAOFactory(1);
		IDao<Alumno> iDao = daoFactory.getAlumnoDAO();
		Alumno alumno = new Alumno(7,"Isaac", "Newton", "45345345-t");
		try {
			assertTrue(iDao.add(alumno).equals(alumno));
		} catch (UnsupportedOperationException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
