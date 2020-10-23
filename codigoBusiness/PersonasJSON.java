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
	
	
	public static void main(String[] args) {
		/*Persona p1 = new Persona("A",2,3,1,5);
		Persona p2 = new Persona("B",5,5,1,1);
		Persona p3 = new Persona("C",5,5,1,1);
		Persona p4 = new Persona("D",3,5,4,2);
		Persona p5 = new Persona("E",3,3,3,3);
		
		PersonasJSON personas = new PersonasJSON();
		personas.agregarPersona(p1);
		personas.agregarPersona(p2);
		personas.agregarPersona(p3);
		personas.agregarPersona(p4);
		personas.agregarPersona(p5);
	
		
		String jsonPretty = personas.generarJSONPretty();
		
		personas.guardarJSON(jsonPretty, "Personas.JSON");*/
		
	}
	
	
}
