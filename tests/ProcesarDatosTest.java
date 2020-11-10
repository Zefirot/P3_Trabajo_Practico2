package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import codigoBusiness.Persona;
import codigoBusiness.ProcesarDatos;

public class ProcesarDatosTest {

	private ArrayList<Persona> personas;
	private ProcesarDatos procesarDatos;


	@Test (expected=IllegalArgumentException.class)
	public void procesarDatosVacios() {
		
		this.personas = new ArrayList<Persona>();
		
		procesarDatos = new ProcesarDatos(personas);
		
	}
	

	@Test (expected=IllegalArgumentException.class)
	public void procesarDatosNull() {
		
		this.personas = null;
		
		procesarDatos = new ProcesarDatos(personas);
		
	}
	
	@Before
	public void preparar() {
		prepararDatos();
		
		procesarDatos = new ProcesarDatos(personas);
	}
	
	@Test
	public void grupo1Test() {
		
		ArrayList<Persona> grupo1Actual = procesarDatos.getGrupo1();
		ArrayList<Persona> grupo1Esperado = grupo1Esperado();
		
		Assert.sonIguales(grupo1Esperado, grupo1Actual);
	}
	
	@Test
	public void grupo2Test() {
		
		ArrayList<Persona> grupo2Actual = procesarDatos.getGrupo2();
		ArrayList<Persona> grupo2Esperado = grupo2Esperado();
		
		Assert.sonIguales(grupo2Esperado, grupo2Actual);
		
	}

	@Test
	public void promedioGrupo1Test() {
		
		ArrayList<Persona> grupo1Actual = procesarDatos.getGrupo1();
		
		ArrayList<Integer> promediosActual = ProcesarDatos.getPromedio(grupo1Actual);
		
		int[] promediosEsperados = {2,3,2,3};	
		
		Assert.sonIguales(promediosEsperados, promediosActual);
	}
	
	@Test
	public void promedioGrupo2Test() {

		ArrayList<Persona> grupo2Actual = procesarDatos.getGrupo2();

		ArrayList<Integer> promediosActual = ProcesarDatos.getPromedio(grupo2Actual);

		int[] promediosEsperados = {5,5,1,1};	

		Assert.sonIguales(promediosEsperados, promediosActual);

	}
	
	@Test
	public void grupo2NullTest() {
		
		ArrayList<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona("A",1,2,3,4));
		
		procesarDatos = new ProcesarDatos(personas); //Al procesar una sola persona entonces el grupo 2 no existe como tal.
		
		assertEquals(null, procesarDatos.getGrupo2());
		
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
