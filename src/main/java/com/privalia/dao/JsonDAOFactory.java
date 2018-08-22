package com.privalia.dao;

import com.privalia.common.Alumno;

public class JsonDAOFactory extends DAOFactory {
	

	@Override
	public IDao<Alumno> getAlumnoDAO() {
		
		return new JsonAlumnoDAO();
	}

}
