package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import codigoBusiness.AGM;
import codigoBusiness.Grafo;

public class AGMTest {

	private Grafo grafo;

	@Before
	public void crear() {
		grafo = new Grafo(9);	
	}
	
	
	
	@Test
	public void agmPesoCorrecto() {
		
		grafo.agregarArista(0, 1, 4); //AB
		grafo.agregarArista(0, 2, 8); //AH
		grafo.agregarArista(1, 2, 12); //BH
		grafo.agregarArista(1, 3, 8); //BC
		grafo.agregarArista(2, 5, 1);  //HG
		grafo.agregarArista(2, 4, 6); //HI
		grafo.agregarArista(3, 4, 3); //CI
		grafo.agregarArista(3, 6, 6); //CD
		grafo.agregarArista(3, 7, 4); //CF
		grafo.agregarArista(4, 5, 5); //IG
		grafo.agregarArista(5, 7, 3); //GF
		grafo.agregarArista(6, 8, 9); //DE
		grafo.agregarArista(6, 7, 13); //DF
		grafo.agregarArista(7, 8, 10); //FE
		
		Grafo nuevoGrafo = AGM.getAGM(grafo);
		
		
		assertEquals(38,nuevoGrafo.getPesoAristas());
		
	}

}
