package com.privalia.dao;

import com.privalia.common.Alumno;

public abstract class DAOFactory {
	
	private final static int TXT = 1;
	private final static int JSON = 2;
	
	public abstract IDao<Alumno> getAlumnoDAO();
	public static DAOFactory getDAOFactory(int whichFactory) {
		
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
