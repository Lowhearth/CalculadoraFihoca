package com.privalia.dao;

import com.privalia.common.Alumno;

public class TxtDAOFactory extends DAOFactory {

	@Override
	public IDao<Alumno> getAlumnoDAO() {
		// TODO Auto-generated method stub
		return new TxtAlumnoDAO();
	}

}
