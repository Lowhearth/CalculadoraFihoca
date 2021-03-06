package com.privalia.dao;




import static com.privalia.util.FileManager.createFile;
import static com.privalia.util.FileReader.readFile;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	public Alumno add(Alumno model) throws IOException   {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			if(file.length() > 0) {
				
				String jsonText = readFile(file);
				FileWriter writer = new FileWriter(file.getAbsolutePath());
				List<Alumno> alumnos = new ArrayList<>(Arrays.asList(new Gson().fromJson(jsonText, Alumno[].class)));
				alumnos.add(model);
				String alumnosString = gson.toJson(alumnos.toArray(new Alumno[alumnos.size()]));
				writer.write(alumnosString);
				writer.close();
				}
			else {
				Alumno [] alumnosArray = {model};
				String alumnosString = gson.toJson(alumnosArray);
				FileWriter writer = new FileWriter(file.getAbsolutePath());
				writer.write(alumnosString);
				writer.close();
			
			}
		} catch (IOException e)  {
				
				e.printStackTrace();
				throw e;
				
		} 
			
		
		
		Alumno foundAlumn = searchById(model.getIdAlumno());
		
		return foundAlumn;
	}
	
	
	public Alumno searchById(int id) throws IOException  {
		
		Gson gson = new Gson();
		String jsonText = readFile(file);
		List<Alumno> alumnos = new ArrayList<>(Arrays.asList(gson.fromJson(jsonText, Alumno[].class)));
		Alumno foundAlumno = alumnos.stream()
									.filter(alumno -> alumno.getIdAlumno() == id)
									.findFirst()
									.get();
		
		return foundAlumno;
		
	
	}
	
	
	
	

}
