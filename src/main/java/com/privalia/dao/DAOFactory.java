package com.privalia.dao;

import com.privalia.common.Alumno;

public abstract class DAOFactory {
	
	
	
	public abstract IDao<Alumno> getAlumnoDAO();
	public static DAOFactory getDAOFactory(FACTORY_NAME whichFactory) {
		
		switch (whichFactory) {
			case TXT:
				return new TxtDAOFactory();
			case JSON:
				return new JsonDAOFactory();
				
			default :
				return null;
		}
	}
	

}
