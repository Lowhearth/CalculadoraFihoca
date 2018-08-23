package com.privalia.dao;




import static com.privalia.util.FileManager.createFile;
import static com.privalia.util.FileReader.readFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.privalia.common.Alumno;

public class JsonAlumnoDAO implements IDao<Alumno> {
	public static final String path = "Alumno.json";
	public static 		File   file = null;
	
	static {
		file = createFile(path);
	}
	
	
	@Override
	public Alumno add(Alumno model) throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonText = readFile(file);
		
		List<Alumno> alumnos = new ArrayList<>(Arrays.asList(mapper.readValue(jsonText, Alumno[].class)));
		alumnos.add(model);
		Alumno[] alumnosArray= (Alumno[]) alumnos.toArray(new Alumno[alumnos.size()]);
		
		mapper.writeValue(file, alumnosArray);
		
		
		
		return null;
	}
	
	
	public Alumno searchById(Alumno model) throws IOException  {
		
		String jsonText = readFile(file);
		ObjectMapper mapper = new ObjectMapper();
		Alumno[] alumnos = mapper.readValue(jsonText, Alumno[].class);
		
		
		
		
		throw new UnsupportedOperationException();
	}
	
	
	
	

}
