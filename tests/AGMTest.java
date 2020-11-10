package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import codigoBusiness.AGM;
import codigoBusiness.Grafo;

public class AGMTest {

	private Grafo grafo;
	private AGM agm;

	@Before
	public void crear() {
		agm = new AGM();
	}
	
	@Test(expected = RuntimeException.class)
	public void grafoDisconexo() {
		grafo = new Grafo(5);
		
		Grafo nuevoGrafo = agm.getAGM(grafo);
	}
	
	@Test
	public void agmPesoCorrectoEjemploTest1() {
		grafo = new Grafo(9);
		
		//Este ejemplo esta sacado de la presentacion del tp
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
	 
		Grafo nuevoGrafo = agm.getAGM(grafo);
		
		assertEquals(38,nuevoGrafo.getPesoAristas());
		
	}
	
	@Test
	public void agmPesoCorrectoEjemploTest2() {
		grafo = new Grafo(5);
		
		grafo.agregarArista(0, 1, 9);  
		grafo.agregarArista(0, 2, 9); 
		grafo.agregarArista(0, 3, 9); 
		grafo.agregarArista(0, 4, 5); 
		grafo.agregarArista(1, 2, 0); 
		grafo.agregarArista(1, 3, 6); 
		grafo.agregarArista(1, 4, 8); 
		grafo.agregarArista(2, 3, 6); 
		grafo.agregarArista(2, 4, 8); 
		grafo.agregarArista(3, 4, 4); 
				
		Grafo nuevoGrafo = agm.getAGM(grafo);
		assertEquals(15,nuevoGrafo.getPesoAristas());
		
	}
	
	
	@Test
	public void agmPesoCorrectoEjemploTest3() {
		grafo = new Grafo(7);
		
		grafo.agregarArista(0, 1, 5);  
		grafo.agregarArista(0, 2, 8); 
		grafo.agregarArista(0, 3, 9);
		grafo.agregarArista(1, 4, 6);
		grafo.agregarArista(1, 2, 3);
		grafo.agregarArista(2, 3, 4);
		grafo.agregarArista(2, 5, 2);
		grafo.agregarArista(3, 6, 7);
		grafo.agregarArista(4, 5, 10);
		grafo.agregarArista(5, 6, 2);
		
		Grafo nuevoGrafo = agm.getAGM(grafo);
		assertEquals(22,nuevoGrafo.getPesoAristas());
	}
	
	@Test
	public void agmPesoCorrectoVerticeUniversalTest() {
		grafo = new Grafo(6);
		
		grafo.agregarArista(0, 1, 3);
		grafo.agregarArista(0, 2, 5);
		grafo.agregarArista(0, 3, 7);
		grafo.agregarArista(0, 4, 1);
		grafo.agregarArista(0, 5, 8);
		grafo.agregarArista(1, 2, 15);
		grafo.agregarArista(2, 3, 5);
		grafo.agregarArista(3, 4, 2);
		grafo.agregarArista(4, 5, 10);
		grafo.agregarArista(5, 1, 4);
		
		Grafo nuevoGrafo = agm.getAGM(grafo);
		
		assertEquals(15,nuevoGrafo.getPesoAristas());
	}
	
	@Test
	public void agmPesoUnicoVerticeTest() { //Cuando solo hay un vertice no existe peso alguno
		grafo = new Grafo(1);
		
		Grafo nuevoGrafo = agm.getAGM(grafo);
		
		assertEquals(0,nuevoGrafo.getPesoAristas());
	}
	
	
	
	

}
