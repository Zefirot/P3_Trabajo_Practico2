package tests;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import codigoBusiness.Grafo;


public class GrafoVecinosTest {

private Grafo grafo;
	
	@Before
	public void crar() {
		this.grafo = new Grafo(5);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void vecinoNegativos() {
		
		grafo.agregarArista(1, 2, 5);
		
		grafo.vecinos(-1);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void vecinosMayoresQueTamano() {
		
		grafo.agregarArista(1, 2 , 7);
		
		grafo.vecinos(6);
		
	}
	
	
	@Test
	public void aislado() {
		
		assertEquals(0,grafo.vecinos(4).size());
		
	}
	
	@Test
	public void vecinoUniversal() {
		
		grafo.agregarArista(1, 0,54);
		grafo.agregarArista(1, 2,5);
		grafo.agregarArista(1, 3,30);
		
		Set<Integer> vecinos = grafo.vecinos(1);
		
		assertEquals(3, vecinos.size());
		
		assertTrue(vecinos.contains(0));
		assertTrue(vecinos.contains(2));
		assertTrue(vecinos.contains(3));
		
	}
	
	
	@Test
	public void vecinoNormal() {
		
		grafo.agregarArista(1, 3,50);
		grafo.agregarArista(2, 3,35);
		grafo.agregarArista(1, 2,20);
		
		Set<Integer> vecinos = grafo.vecinos(3);
		
		assertEquals(2, vecinos.size());
		
		assertTrue(vecinos.contains(1));
		assertTrue(vecinos.contains(2));

	}

}
