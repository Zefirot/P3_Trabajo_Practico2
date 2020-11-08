package codigoBusiness;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PersonasJSON {

	private ArrayList<Persona> personas;
	
	
	public PersonasJSON() {
		this.personas=new ArrayList<Persona>();
	}
	
	public void agregarPersona(Persona persona) {
		personas.add(persona);
	}
	
	public Persona getPersona(int i) {
		return personas.get(i);
	}
	
	public int getCantidadPersonas() {
		return personas.size();
	}
	
	public ArrayList<Persona> getTodasLasPersonas(){
		return personas;
	}
	
	public String generarJSONBasico() {
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(this);
		
		return json;
	}
	
	public String generarJSONPretty() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(this);
		
		return json;
	}
	
	public void guardarJSON(String jsonParaGuardar, String archivoDestino) {
		
		try {
			FileWriter writer = new FileWriter(archivoDestino);
			writer.write(jsonParaGuardar);
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public PersonasJSON leerJSON(String archivo) {
		Gson gson = new Gson();
		PersonasJSON ret = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			
			ret = gson.fromJson(br, PersonasJSON.class);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return ret;
	}	
	
}
