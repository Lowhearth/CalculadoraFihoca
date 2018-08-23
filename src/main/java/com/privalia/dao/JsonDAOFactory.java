package com.privalia.dao;

import static com.privalia.util.FileManager.createFile;

import java.io.File;

import com.privalia.common.Alumno;

public class JsonDAOFactory extends DAOFactory {
	public static final String path = "Alumno.json";
	public static 		File   file = null;
	
	static {
		file = createFile(path);
	}

	@Override
	public IDao<Alumno> getAlumnoDAO() {
		
		return new JsonAlumnoDAO();
	}

}
