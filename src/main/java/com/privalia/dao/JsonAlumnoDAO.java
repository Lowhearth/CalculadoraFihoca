
package com.privalia.dao;




import static com.privalia.util.FileManager.createFile;

import java.io.File;
import java.io.IOException;

import com.privalia.common.Alumno;

public class JsonAlumnoDAO implements IDao<Alumno> {
	public static final String path = "Alumno.json";
	public static 		File   file = null;
	
	static {
		file = createFile(path);
	}
	
	
	@Override
	public Alumno add(Alumno model) throws  IOException {
		throw new UnsupportedOperationException();
	}
	
	public Alumno searchById(Alumno model) throws IOException  {
		
		
		throw new UnsupportedOperationException();
	}
	
	

}