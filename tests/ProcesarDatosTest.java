package tests;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import codigoBusiness.Persona;
import codigoBusiness.ProcesarDatos;

public class ProcesarDatosTest {

	private ArrayList<Persona> personas;
	private ProcesarDatos procesarDatos;

	@Before
	public void preparar() {
		prepararDatos();
		
		procesarDatos = new ProcesarDatos(personas);
	}
	
	@Test
	public void grupo1Test() {
		
		Set<Integer> datos = procesarDatos.getGrupo1();
		
		ArrayList<Persona> grupo1Actual = obtenerGrupo(datos);
		ArrayList<Persona> grupo1Esperado = grupo1Esperado();
		
		Assert.sonIguales(grupo1Esperado, grupo1Actual);
	}
	
	@Test
	public void grupo2Test() {
		
		Set<Integer> datos = procesarDatos.getGrupo2();
		
		ArrayList<Persona> grupo2Actual = obtenerGrupo(datos);
		ArrayList<Persona> grupo2Esperado = grupo2Esperado();
		
		Assert.sonIguales(grupo2Esperado, grupo2Actual);
		
	}
	
	private ArrayList<Persona> obtenerGrupo(Set<Integer> posicionPersonas){
		ArrayList<Persona> grupo = new ArrayList<Persona>();
		
		for(Integer persona: posicionPersonas) {
			grupo.add(personas.get(persona));
		}
		
		return grupo;
	}
	
	private void prepararDatos() {
		
		Persona p1 = new Persona("A",2,3,1,5);
		Persona p2 = new Persona("B",5,5,1,1);
		Persona p3 = new Persona("C",5,5,1,1);
		Persona p4 = new Persona("D",3,5,4,2);
		Persona p5 = new Persona("E",3,3,3,3);
		
		personas = new ArrayList<Persona>();
		personas.add(p1);
		personas.add(p2);
		personas.add(p3);
		personas.add(p4);
		personas.add(p5);
	}

	private ArrayList<Persona> grupo1Esperado(){
		ArrayList<Persona> grupo1 = new ArrayList<Persona>();
		
		Persona p1 = new Persona("A",2,3,1,5);
		Persona p4 = new Persona("D",3,5,4,2);
		Persona p5 = new Persona("E",3,3,3,3);
		
		grupo1.add(p1);
		grupo1.add(p4);
		grupo1.add(p5);
		
		return grupo1;
	}
	
	private ArrayList<Persona> grupo2Esperado(){
		
		ArrayList<Persona> grupo2 = new ArrayList<Persona>();

		Persona p2 = new Persona("B",5,5,1,1);
		Persona p3 = new Persona("C",5,5,1,1);

		grupo2.add(p2);
		grupo2.add(p3);

		return grupo2;
		
	}
	
}
