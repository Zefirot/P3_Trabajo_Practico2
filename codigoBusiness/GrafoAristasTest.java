package codigoBusiness;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class GrafoAristasTest {

	private Grafo grafo;
	
	@Before
	public void crear() {
		this.grafo = new Grafo(5);
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void parametroIncorrectoNegativo() {
		grafo.agregarArista(-1, 5,5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void parametroIncorrectoMayorQueGrafo() {
		grafo.agregarArista(1, 6,5);
	}
	
	
	@Test
	public void existeArista() {
		grafo.agregarArista(1, 2,5);
		assertTrue(grafo.existeArista(1, 2));
	}
	
	@Test
	public void existeAristaInversa() {
		grafo.agregarArista(1, 2,5);
		assertTrue(grafo.existeArista(2, 1));
	}
	
	@Test
	public void eliminarArista() {
		grafo.agregarArista(1, 2,5);
		grafo.eliminarArista(1, 2);
		assertFalse(grafo.existeArista(1, 2));
		 
	}
	@Test
	public void eliminarAristaInversa() {
		grafo.agregarArista(1, 2,5);
		grafo.eliminarArista(2, 1);
	
		assertFalse(grafo.existeArista(2, 1));
		
	}

}
