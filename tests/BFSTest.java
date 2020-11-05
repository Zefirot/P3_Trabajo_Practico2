package tests;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import codigoBusiness.BFS;
import codigoBusiness.Grafo;


public class BFSTest {

	@Test (expected=IllegalArgumentException.class)
	public void testNull() 
	{
		BFS.esConexo(null);
	}
	
	@Test
	public void testVacio()
	{
		Grafo g = new Grafo(0);
		assertTrue(BFS.esConexo(g));
	}
	
	@Test
	public void testNoConexo()
	{
		Grafo g = inicializarEjemplo();
		assertFalse(BFS.esConexo(g));
	}

	@Test
	public void testConexo()
	{
		Grafo g = inicializarEjemplo();
		g.agregarArista(3, 4, 1);
		assertTrue(BFS.esConexo(g));
	}
	
	@Test
	public void alcanzablesTest()
	{
		Grafo g = inicializarEjemplo();
		Set<Integer> alcanzables = BFS.alcanzables(g, 0);
		
		int[] esperado = {0, 1, 2, 3};
		Assert.sonIguales(esperado, alcanzables);
	}
	
	@Test
	public void alcanzablesTodosTest()
	{
		Grafo g = inicializarEjemplo();
		g.agregarArista(3, 4, 10);
		
		Set<Integer> alcanzables = BFS.alcanzables(g, 0);
		
		int[] esperado = {0, 1, 2, 3, 4};
		Assert.sonIguales(esperado, alcanzables);
	}
	
	private Grafo inicializarEjemplo() 
	{
		Grafo g = new Grafo(5);
		g.agregarArista(0, 1, 1);
		g.agregarArista(0, 2, 1);
		g.agregarArista(2, 3, 1);
		return g;
	}
	
	
	
}
