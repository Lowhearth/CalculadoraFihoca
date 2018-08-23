package com.privalia.dao;




import static com.privalia.util.FileManager.createFile;
import static com.privalia.util.FileReader.readFile;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.privalia.common.Alumno;

public class JsonAlumnoDAO implements IDao<Alumno> {
	public static final String path = "Alumno.json";
	public static 		File   file = null;
	
	static {
		file = createFile(path);
	}
	
	
	@Override
	public Alumno add(Alumno model) throws JsonGenerationException, JsonMappingException, IOException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		
		if(file.length() > 0) {
			String jsonText = readFile(file);
			FileWriter writer = new FileWriter(file.getAbsolutePath());
			List<Alumno> alumnos = new ArrayList<>(Arrays.asList(new Gson().fromJson(jsonText, Alumno[].class)));
			alumnos.add(model);
			Alumno[] alumnosArray= (Alumno[]) alumnos.toArray(new Alumno[alumnos.size()]);
			String alumnosString = gson.toJson(alumnosArray);
			System.out.println("adding");
			writer.write(alumnosString);
			writer.close();
			
			
		}
		else {
			Alumno [] alumnosArray = {model};
			FileWriter writer = new FileWriter(file.getAbsolutePath());
			System.out.println("adding");
			String alumnosString = gson.toJson(alumnosArray);
			System.out.println("converted" + alumnosString);
			writer.write(alumnosString);
			System.out.println("added");
			writer.close();
		}
		
		
		Alumno foundAlumn = searchById(model.getIdAlumno());
		
		return foundAlumn;
	}
	
	
	public Alumno searchById(int id) throws IOException  {
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonText = readFile(file);
		;
		List<Alumno> alumnos = new ArrayList<>(Arrays.asList(mapper.readValue(jsonText, Alumno[].class)));
		Alumno foundAlumno = alumnos.stream().filter(alumno -> alumno.getIdAlumno() == id)
						.findFirst()
						.get();
		
		return foundAlumno;
		
	
	}
	
	
	
	

}
